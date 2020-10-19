package com.thoughtworks.capacity.gtb.mvc;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put("aaa", new User("aaa", "12345", "aaa@qq.com"));
        userMap.put("aaa", new User("bbb", "23456", "bbb@qq.com"));
    }

    public void createUser(User user) {
        User userExit = userMap.get(user.getUsername());
        if (userExit != null){
            throw new UserExistException("user exists");
        }
        userMap.put(user.getUsername(), user);
    }

}
