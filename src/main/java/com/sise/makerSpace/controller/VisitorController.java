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

@Controller
@ResponseBody
@RequestMapping(value = "/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VisitorController {

    @Autowired
    private UserService userService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();


    @PostMapping(value = "/doLogin")
    public User doLogin(@RequestParam("user_name") String user_name,
                        @RequestParam("password") String password){
        User user=userService.getUserByUserName(user_name,password);
        System.out.println("user_name:"+user.getUsername()+",password:"+user.getPassword()+",name:"+user.getUsername());
        return user;
    }

    @PostMapping("/login")
    public ReturnMsgUtils login(@RequestBody User user, HttpServletRequest request){
        return userService.login(user.getUser_name(),user.getPassword(),request);
    }

    @PostMapping(value = "/register")
    public ReturnMsgUtils register(@RequestBody User user){
        //ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();
        if (userService.checkDuplicateName(user.getUsername())) {   //if user exist
            //System.out.println("fail");
            return returnMsgUtils.fail("the username already exist");
        } /*else if(user.getName()) {

        }*/else {
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