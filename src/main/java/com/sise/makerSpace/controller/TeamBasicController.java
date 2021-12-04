package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.PageRequest;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.domain.TeamMember;
import com.sise.makerSpace.service.TeamService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/team/basic")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamBasicController {

    @Autowired
    private TeamService teamService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @GetMapping(value = "/findTeamMember")
    public List<TeamMember> findTeamMember(@RequestParam("team_id")int team_id){
        List<TeamMember> teamMembers=teamService.findAllTeamMember(team_id);
        System.out.println(teamMembers);
        return teamMembers;
        //return "teamPage/teamView";
    }

    @GetMapping(value = "/getTeamInfoByTeamId")
    public ReturnMsgUtils getTeamInfo(@RequestParam("team_id")int team_id){
        //PageRequest pageRequest=new PageRequest(pageNum,pageSize);
        return returnMsgUtils.setData(teamService.getTeamInfo(team_id));
    }

    @PostMapping(value = "/applyToCreateATeam")
    public ReturnMsgUtils applyToCreateATeam(@RequestBody Team team){
        //重复检查
        teamService.applyToCreateATeam(team);
        return returnMsgUtils.success("申请成功，请等待老师与管理员审批");
    }

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
