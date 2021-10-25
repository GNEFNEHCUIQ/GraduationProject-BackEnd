package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.User;
import com.sise.makerSpace.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login")
    public String login(@Param("uid") int uid,
                      @Param("password") String password){
        User user = new User();
        user.setUid(uid);
        user.setPassword(password);
        User check_login= userService.getUserById(user);
        return "uid="+check_login.getUid()+"\npwd="+check_login.getPassword()+"\nname="+check_login.getName();
    }
}
