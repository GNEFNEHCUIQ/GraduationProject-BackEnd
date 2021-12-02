package com.sise.makerSpace.controller;

import com.sise.makerSpace.service.ReviewService;
import com.sise.makerSpace.service.TeacherService;
import com.sise.makerSpace.service.TeamService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/teacher")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeacherController {
    @Autowired
    private ReviewService reviewService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @GetMapping(value = "/findATeachersUnreviewedCTA")
    public ReturnMsgUtils findATeachersUnreviewedCTA(@RequestParam("teacher_id")int teacher_id){
        return returnMsgUtils.setData(reviewService.findATeachersUnreviewedCTA(teacher_id));
    }

    @GetMapping(value = "/findATeachersAllCTA")
    public ReturnMsgUtils findATeachersAllCTA(@RequestParam("teacher_id")int teacher_id){
        return returnMsgUtils.setData(reviewService.findATeachersAllCTA(teacher_id));
    }


    @PutMapping(value = "/reviewTeacherCTA")
    public ReturnMsgUtils reviewCTApplication(
            @RequestParam("review_id")int review_id,
            @RequestParam("teacher_id")int teacher_id,
            @RequestParam("t_approved")int t_approved){
        reviewService.reviewTeacherCTA(review_id,teacher_id,t_approved);
        if (t_approved==-1){
            return returnMsgUtils.success("审核成功！已拒绝");
        }else {
            return returnMsgUtils.success("审核成功！已接受！正等待运营人员审核！");
        }
    }

}
