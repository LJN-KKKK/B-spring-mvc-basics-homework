package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotEmpty(message = "username不能为空")
    @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$", message = "username不合法,只能由字母、数字或下划线组成")
    @Size(min = 3, max = 10, message = "username长度需为3-10位")
    private String username;

    @NotEmpty(message = "password不能为空")
    @Size(min = 5, max = 12, message = "password不合法，长度需为5-12位")
    private String password;

    @Email(regexp = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "email不合法")
    private String email;

}
