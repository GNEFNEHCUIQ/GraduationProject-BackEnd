package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.TeamMember;
import com.sise.makerSpace.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/team")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping(value = "/findAllTeamMember")
    public List<TeamMember> findAllTeamMember(){
        List<TeamMember> teamMembers=teamService.findAllTeamMember();
        System.out.println(teamMembers);
        return teamMembers;
        //return "teamPage/teamView";
    }
}
