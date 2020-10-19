package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService; }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User user) {
        userService.createUser(user);
    }

    @GetMapping(value = "/login")
    @ResponseStatus(HttpStatus.OK)
    public User login(@RequestParam("username")
                      @NotEmpty(message = "username不能为空")
                      @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$", message = "username不合法")
                      @Size(min = 3, max = 10, message = "username不合法")
                      @Valid
                        String username,
                      @RequestParam("password")
                      @NotEmpty(message = "password不合法")
                      @Size(min = 5, max = 12, message = "password不合法")
                      @Valid
                        String password) {
        return userService.login(username, password);
    }
}
