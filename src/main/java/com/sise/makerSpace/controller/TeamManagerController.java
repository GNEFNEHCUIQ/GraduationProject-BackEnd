package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.CompetitionTeam;
import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.domain.TeamMember;
import com.sise.makerSpace.service.*;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping(value = "/team/manage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamManagerController {
    @Autowired
    private TeamService teamService;
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private CompetitionService competitionService;

    @Autowired
            private UserService userService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @PostMapping("/applyToCreateItem")
    public ReturnMsgUtils applyToCreateItem(
            @RequestParam("applicant_team_id")int applicant_team_id,
            @RequestParam("item_name")String item_name,
            @RequestParam("item_describe")String item_describe){
        ;
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
            @RequestParam("t_approved")int t_approved,
            Principal principal){
        int t_handler=userService.getUserByUserName(principal.getName()).getUser_id();

        System.out.println("review_id:"+review_id+",t_approved:"+t_approved+",t_handler:"+t_handler);
        reviewService.reviewJoinTeamAppl(review_id,t_approved,t_handler);
        if (t_approved==-1){
            return returnMsgUtils.success("已拒绝该请求");
        }else {
            TeamMember teamMember=reviewService.getTidAndUidFromReview(review_id);
            teamService.letJoinTeam(teamMember.getTeam_id(),teamMember.getUser_id());
            roleService.addSomeOnesRole(teamMember.getUser_id(),6);
            return returnMsgUtils.success("已接受该用户已加入团队！");
        }
    }

    private TeamMember getTidAndUidFromReview(int review_id){
        return reviewService.getTidAndUidFromReview(review_id);
    }

    @GetMapping("/modTeamInfo")
    public ReturnMsgUtils modTeamInfo(@RequestBody Team team){
        return returnMsgUtils.success("还没做呢！");
    }

    @GetMapping("/getJoinTeamReview")
    public ReturnMsgUtils getJoinTeamReview(Principal principal){
        return returnMsgUtils.setData(reviewService.getJoinTeamReview(userService.getUserByUserName(principal.getName()).getUser_id()));
    }


    @PostMapping("/enterCompetition")
    public ReturnMsgUtils enterCompetition(@RequestBody CompetitionTeam competitionTeam){
        competitionService.enterCompetition(competitionTeam);
        return returnMsgUtils.success("报名成功！");
    }

}