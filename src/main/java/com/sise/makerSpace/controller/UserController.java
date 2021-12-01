package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Resume;
import com.sise.makerSpace.domain.User;
import com.sise.makerSpace.service.UserService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private UserService userService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();


    @PostMapping(value = "/doLogin")
    public User login(@RequestParam("uid") int uid,
                        @RequestParam("password") String password){
        User user=userService.getUserById(uid,password);
        System.out.println("uid:"+user.getUserId()+",password:"+user.getPassword()+",name:"+user.getName()+",role:"+user.getRole());
        return user;
        //-----------------最后应该写成return userService.getUserById(uid,password);
        //return "uid="+check_login.getUid()+"\npwd="+check_login.getPassword()+"\nname="+check_login.getName();
        //return "homePage";
    }

    /*@PostMapping(value = "/doRegister")
    public void register(@RequestBody User user){
        if (this.checkDuplicateName(user.getName()))
            return;
        userService.register(user);
    }

    private boolean checkDuplicateName(String name){
        return userService.checkDuplicateName(name);
    }*/

    @PostMapping(value = "/doRegister")
    public ReturnMsgUtils register(@RequestBody User user){
        //ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();
        if (userService.checkDuplicateName(user.getName())) {   //if user exist
            //System.out.println("fail");
            return returnMsgUtils.fail("the username already exist");
        } /*else if(user.getName()) {

        }*/else {
            userService.register(user);
            //createResumeByName(user.getName());
            userService.createResumeByName(user.getName());
            //System.out.println("success");
            return returnMsgUtils.success("注册成功");
        }
    }

    @PostMapping(value = "/getUserInfoByUserId")   //完成
    public ReturnMsgUtils getUserInfoByUserId(@RequestBody User user){
        List<Resume> resumeList=userService.getUserInfoByUserId(/*user.getUserId()*/1);
        if (null==resumeList){
            return returnMsgUtils.fail("null");
        }else {
            return returnMsgUtils.setData(resumeList);
        }
    }

}