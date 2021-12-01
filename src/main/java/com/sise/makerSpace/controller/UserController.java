package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Resume;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.service.UserService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", maxAge = 3600)


public class UserController {

    @Autowired
    private UserService userService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @PostMapping(value = "/getUserInfoByUserId")   //完成
    public ReturnMsgUtils getUserInfoByUserId(/*@RequestBody User user*/@RequestParam("userId")int userId){
        List<Resume> resumeList=userService.getUserInfoByUserId(userId);
        if (null==resumeList){
            return returnMsgUtils.fail("null");
        }else {
            return returnMsgUtils.setData(resumeList);
        }
    }

    @GetMapping(value = "/certifiedAsTeacher")
    public ReturnMsgUtils certifiedAsTeacher(@RequestParam("user_id")int user_id){
        if (!userService.isTeacher(user_id)) {
            System.out.println("userService.isTeacher(user_id)::"+userService.isTeacher(user_id));
            userService.certifiedAsTeacher(user_id);
            return returnMsgUtils.success("申请提交成功");
        }else{
            System.out.println("userService.isTeacher(user_id)::"+userService.isTeacher(user_id));
            return returnMsgUtils.fail("你已经是老师啦，无需重复认证");
        }
    }

}
