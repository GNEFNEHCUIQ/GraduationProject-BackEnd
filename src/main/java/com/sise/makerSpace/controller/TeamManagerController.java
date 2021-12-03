package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.service.TeamService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/team/manager")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamManagerController {
    @Autowired
    private TeamService teamService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @PostMapping("/applyToCreateItem")
    public ReturnMsgUtils applyToCreateItem(
            @RequestParam("applicant_team_id")int applicant_team_id,
            @RequestParam("item_name")String item_name,
            @RequestParam("item_describe")String item_describe){
        teamService.applyToCreateItem(applicant_team_id,item_name,item_describe);
        return returnMsgUtils.success("申请成功！正等待回应！");
    }
}