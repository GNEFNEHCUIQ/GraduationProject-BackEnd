package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.ReviewCreateItem;
import com.sise.makerSpace.service.ReviewService;
import com.sise.makerSpace.service.TeacherService;
import com.sise.makerSpace.service.TeamService;
import com.sise.makerSpace.service.UserService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/teacher/basic")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeacherController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @GetMapping(value = "/findUnreviewedCTA")
    public ReturnMsgUtils findATeachersUnreviewedCTA(Principal principal){
        int teacher_id=userService.getUserByUserName(principal.getName()).getUser_id();
        return returnMsgUtils.setData(reviewService.findATeachersUnreviewedCTA(teacher_id));
    }

    @GetMapping(value = "/findAllCTA")
    public ReturnMsgUtils findATeachersAllCTA(Principal principal){
        int teacher_id=userService.getUserByUserName(principal.getName()).getUser_id();
        return returnMsgUtils.setData(reviewService.findATeachersAllCTA(teacher_id));
    }

    @PutMapping(value = "/reviewCTA")
    public ReturnMsgUtils reviewTeacherCTA(
            @RequestParam("review_id")int review_id,
            Principal principal,
            @RequestParam("t_approved")int t_approved){
        int teacher_id=userService.getUserByUserName(principal.getName()).getUser_id();
        reviewService.reviewTeacherCTA(review_id,teacher_id,t_approved);
        if (t_approved==-1){
            return returnMsgUtils.success("审核成功！已拒绝");
        }else {
            return returnMsgUtils.success("审核成功！已接受！正等待运营人员审核！");
        }
    }

    @GetMapping("/getUnreviewedCIA")
    public ReturnMsgUtils getUnreviewedCIA(Principal principal){
        return returnMsgUtils.setData(reviewService.getUnreviewedCIAByTId(userService.getUserByUserName(principal.getName()).getUser_id()));
    }

    @PutMapping("/reviewTeacherCIA")
    public ReturnMsgUtils reviewTeacherCIA(@RequestParam("review_id")int review_id,
                                           @RequestParam("t_approved")int t_approved){
            reviewService.reviewTeacherCIA(review_id,t_approved);
        if (t_approved==-1){
            return returnMsgUtils.success("审核成功！已拒绝");
        }else {
            return returnMsgUtils.success("审核成功！已接受！正等待运营人员审核！");
        }
    }

}
