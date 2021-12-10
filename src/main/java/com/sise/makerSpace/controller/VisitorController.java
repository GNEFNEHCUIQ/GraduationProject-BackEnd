package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Resume;
import com.sise.makerSpace.domain.User;
import com.sise.makerSpace.service.UserService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VisitorController {

    @Autowired
    private UserService userService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    /*@PostMapping("/login")
    public ReturnMsgUtils login(@RequestBody User user, HttpServletRequest request){
        return returnMsgUtils.setData(userService.login(user.getUser_name(),
                user.getPassword(),
                request)
        );
    }*/
    @PostMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest request){
        return userService.login(user.getUser_name(),
                user.getPassword(),
                request
        );
    }

    @PostMapping(value = "/register")
    public ReturnMsgUtils register(@RequestBody User user){
        if (userService.checkDuplicateName(user.getUsername())) {   //if user exist
            return returnMsgUtils.fail("用户名已存在");
        } else {
            userService.register(user);
            //createResumeByName(user.getName());
            userService.createResumeByName(user.getUsername());
            //System.out.println("success");
            userService.initROU(user.getUsername());
            return returnMsgUtils.success("注册成功");
        }
    }

    @PostMapping("/logout")
    public ReturnMsgUtils logout(){
        return returnMsgUtils.success("注销成功！");
    }


}