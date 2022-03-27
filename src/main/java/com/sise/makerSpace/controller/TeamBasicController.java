package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.PageRequest;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.domain.TeamMember;
import com.sise.makerSpace.domain.User;
import com.sise.makerSpace.service.TeamService;
import com.sise.makerSpace.service.UserService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/team/basic")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamBasicController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private UserService userService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @GetMapping("/getYourTeam")
    public ReturnMsgUtils getYourTeam(Principal principal){
        if (null==principal){
            return null;
        }
        String user_name=principal.getName();
        User user=userService.getUserByUserName(user_name);
        List<Team> yourTeam=teamService.getYourTeam(user.getUser_id());
        if (null==yourTeam){
            return returnMsgUtils.fail("你还没有队伍，快加入一个吧！");
        }else {
            return returnMsgUtils.setData(yourTeam);
        }

    }

    @GetMapping(value = "/findTeamMember")
    public ReturnMsgUtils findTeamMember(@RequestParam("team_id")int team_id){
        List<TeamMember> teamMembers=teamService.findAllTeamMember(team_id);
        return returnMsgUtils.setData(teamMembers,null);
        //return "teamPage/teamView";
    }

    @GetMapping(value = "/getTeamInfoByTeamId")
    public ReturnMsgUtils getTeamInfo(@RequestParam("team_id")int team_id){
        //PageRequest pageRequest=new PageRequest(pageNum,pageSize);
        return returnMsgUtils.setData(teamService.getTeamInfo(team_id),null);
    }

    @PostMapping(value = "/applyToCreateATeam")
    public ReturnMsgUtils applyToCreateATeam(
            @RequestParam("team_name")String team_name,
            @RequestParam("category")String category,
            @RequestParam("teacherId")String teacherRealName,
            @RequestParam("teamDescribe")String teamDescribe,
            Principal principal){
        //重复检查
        Integer teacherId=teamService.getTeacherIdByRealName(teacherRealName);
        if (null==teacherId) {
            return returnMsgUtils.fail("无此教师");
        }else if (teamService.checkTeamNameIfExist(team_name)) {
            return returnMsgUtils.fail("队伍名已存在");
        }else{
                Team team = new Team();
                team.setTeam_name(team_name);
                team.setCategory(category);
                team.setTeacher_id(teacherId);
                team.setTeam_describe(teamDescribe);
                team.setLeader_id(userService.getUserByUserName(principal.getName()).getUser_id());
                teamService.applyToCreateATeam(team);
                return returnMsgUtils.success("申请成功，请等待老师与管理员审批");
            }

    }

    @GetMapping("/getTeacherList")
    public ReturnMsgUtils getTeacherList(){return returnMsgUtils.setData(teamService.getTeacherList(),null);}

    @GetMapping("/findAllTeam")
    public ReturnMsgUtils findAllTeam(){
        return returnMsgUtils.setData(teamService.findAllTeam());
    }

    @GetMapping("/findTeamByTeamName")
    public ReturnMsgUtils findTeamByTeamName(@RequestParam("team_name")String team_name){
        return returnMsgUtils.setData(teamService.findTeamByTeamName(team_name));
    }

    @GetMapping("/findTeamByCategory")
    public ReturnMsgUtils findTeamByCategory(@RequestParam("category")String category){
        return returnMsgUtils.setData(teamService.findTeamByCategory(category));
    }

    @GetMapping("/findItemByTeamId")
    public ReturnMsgUtils findItemByTeamId(@RequestParam("team_id")int team_id){
        return returnMsgUtils.setData(teamService.findItemByTeamId(team_id));
    }


}
