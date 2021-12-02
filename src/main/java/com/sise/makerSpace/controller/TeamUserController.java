package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.service.TeamService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/team/basic")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamUserController {
    @Autowired
    private TeamService teamService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @PostMapping(value = "/applyToCreateATeam")
    public ReturnMsgUtils applyToCreateATeam(@RequestBody Team team){
        //重复检查
        teamService.applyToCreateATeam(team);
        return returnMsgUtils.success("申请成功，请等待老师与管理员审批");
    }


}
