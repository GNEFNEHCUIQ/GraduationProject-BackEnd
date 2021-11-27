package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.User;
import com.sise.makerSpace.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/doLogin")
    public User login(@RequestParam("uid") int uid,
                        @RequestParam("password") String password){
        User user=userService.getUserById(uid,password);
        System.out.println("uid:"+user.getUid()+",password:"+user.getPassword()+",name:"+user.getName()+",role:"+user.getRole());
        return user;
        //-----------------最后应该写成return userService.getUserById(uid,password);
        //return "uid="+check_login.getUid()+"\npwd="+check_login.getPassword()+"\nname="+check_login.getName();
        //return "homePage";
    }

}