package com.sise.makerSpace.controller;

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

    @GetMapping(value = "/findAllTeamMember")
    public List<TeamMember> findAllTeamMember(){
        List<TeamMember> teamMembers=teamService.findAllTeamMember();
        System.out.println(teamMembers);
        return teamMembers;
        //return "teamPage/teamView";
    }

    @GetMapping(value = "/getTeamInfo")
    public ReturnMsgUtils getTeamInfo(@RequestParam("team_id")int team_id){
        return returnMsgUtils.setData(teamService.getTeamInfo(team_id));
    }


}
