package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Resume;
import com.sise.makerSpace.domain.Teacher;
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

    @GetMapping(value = "/getUserResume")   //完成
    public ReturnMsgUtils getUserResume(Principal principal){
        Resume resume=userService.getUserResume(userService.getUserByUserName(principal.getName()).getUser_id());
        if (null==resume){
            return returnMsgUtils.fail("null");
        }else {
            return returnMsgUtils.setData(resume);
        }
    }

    @GetMapping("/getUserInfoByPrincipal")
    public User getUserInfoByPrincipal(Principal principal){
        if (null==principal){
            return null;
        }
        String user_name=principal.getName();
        User user=userService.getUserByUserName(user_name);
        user.setPassword(null);
        user.setRoles(userService.getRoles(user.getUser_id()));
        return user;
    }

    @PostMapping("/certifiedAsTeacher")
    public ReturnMsgUtils certifiedAsTeacher(@RequestBody Teacher teacher,Principal principal){
        teacher.setUser_id(userService.getUserByUserName(principal.getName()).getUser_id());
        if (userService.isTeacher(teacher.getUser_id())) {
            System.out.println("userService.isTeacher(user_id)::"+userService.isTeacher(teacher.getUser_id()));
            return returnMsgUtils.fail("你已经是老师啦，无需重复认证");
        }else if(userService.alreadyCommitTeacherApply(teacher.getUser_id())){
            return returnMsgUtils.fail("你已提交申请，无需重复提交。");
        }
        else {
            System.out.println("提交成功 userService.isTeacher(user_id)::"+userService.isTeacher(teacher.getUser_id()));
            userService.certifiedAsTeacher(teacher);
            return returnMsgUtils.success("申请提交成功");
        }
        //return returnMsgUtils.success("success");
    }

    @PostMapping("/applyJoinTeam")
    public ReturnMsgUtils applyJoinTeam(Principal principal,@RequestParam("team_id")int team_id){
        userService.applyJoinTeam(userService.getUserByUserName(principal.getName()).getUser_id(),team_id);
        return returnMsgUtils.success("申请成功！正等待团队管理员审核。");
    }

    @PutMapping("/updateUserResume")
    public ReturnMsgUtils updateUserResume(@RequestBody Resume resume){
        userService.updateUserResume(resume);
        return returnMsgUtils.success("修改成功");
    }

    /*@PostMapping("/logout")
    public ReturnMsgUtils logout(){
        return returnMsgUtils.success("注销成功");
    }*/

}
