package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Resume;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.domain.User;
import com.sise.makerSpace.service.ReviewService;
import com.sise.makerSpace.service.UserService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*", maxAge = 3600)


public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ReviewService reviewService;

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

    @GetMapping("/getUserInfoByPrincipal")
    public User getUserInfo(Principal principal){
        if (null==principal){
            return null;
        }
        String user_name=principal.getName();
        User user=userService.getUserByUserName(user_name);
        user.setPassword(null);
        user.setRoles(userService.getRoles(user.getUser_id()));
        return user;
    }

    @GetMapping(value = "/certifiedAsTeacher")
    public ReturnMsgUtils certifiedAsTeacher(@RequestParam("user_id")int user_id){
        if (userService.isTeacher(user_id)) {
            System.out.println("userService.isTeacher(user_id)::"+userService.isTeacher(user_id));
            return returnMsgUtils.fail("你已经是老师啦，无需重复认证");
        }else if(userService.alreadyCommitTeacherApply(user_id)){
            return returnMsgUtils.fail("你已提交申请，无需重复提交。");
        }
        else {
            System.out.println("userService.isTeacher(user_id)::"+userService.isTeacher(user_id));
            userService.certifiedAsTeacher(user_id);
            return returnMsgUtils.success("申请提交成功");
        }
    }

    @PostMapping("/applyJoinTeam")
    public ReturnMsgUtils applyJoinTeam(Principal principal,@RequestParam("team_id")int team_id){
        userService.applyJoinTeam(principal.getName(),team_id);
        return returnMsgUtils.success("申请成功！正等待团队管理员审核。");
    }

}
