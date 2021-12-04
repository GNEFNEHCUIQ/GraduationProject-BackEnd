package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.domain.TeamMember;
import com.sise.makerSpace.service.ReviewService;
import com.sise.makerSpace.service.TeamService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/team/manager")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamManagerController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private ReviewService reviewService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @PostMapping("/applyToCreateItem")
    public ReturnMsgUtils applyToCreateItem(
            @RequestParam("applicant_team_id")int applicant_team_id,
            @RequestParam("item_name")String item_name,
            @RequestParam("item_describe")String item_describe){
        teamService.applyToCreateItem(applicant_team_id,item_name,item_describe);
        return returnMsgUtils.success("申请成功！正等待回应！");
    }

    @PostMapping("/inviteSBJointeam")
    public ReturnMsgUtils inviteSBJoinTeam(@RequestParam("team_id")int team_id,@RequestParam("user_name")int user_id){
        teamService.inviteSBJoinTeam(team_id,user_id);
        return returnMsgUtils.success("邀请提交成功，正等待对方验证通过");
    }

    @PutMapping("/reviewJoinTeamAppl")
    public ReturnMsgUtils reviewJoinTeamAppl(
            @RequestParam("review_id")int review_id,
            @RequestParam("approved")int approved){
        reviewService.reviewJoinTeamAppl(review_id,approved);
        if (approved==-1){
            return returnMsgUtils.success("已拒绝该请求");
        }else {
            TeamMember teamMember=getTidAndUidFromReview(review_id);
            teamService.letJoinTeam(teamMember.getTeam_id(),teamMember.getMember_id());
            return returnMsgUtils.success("已接受该用户已加入团队！");
        }

    }

    private TeamMember getTidAndUidFromReview(int review_id){
        return reviewService.getTidAndUidFromReview(review_id);
    }

    @GetMapping
    public ReturnMsgUtils modTeamInfo(@RequestBody Team team){
        return returnMsgUtils.success("还没做呢！");
    }

}