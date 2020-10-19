package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.exception.LoginException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserExistException;
import com.thoughtworks.capacity.gtb.mvc.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put("aaa", new User("aaa", "12345", "aaa@qq.com"));
        userMap.put("bbb", new User("bbb", "23456", "bbb@qq.com"));
    }

    public void createUser(User user) {
        User userExit = userMap.get(user.getUsername());
        if (userExit != null){
            throw new UserExistException("user exists");
        }
        userMap.put(user.getUsername(), user);
    }

    public User login(String username, String password) {
        User userExit = userMap.get(username);
        if(userExit == null){
            throw new UserExistException("wrong username or password");
        }
        if(!userExit.getPassword().equals(password)){
            throw new LoginException("wrong username or password");
        }
        return userExit;
    }
}
