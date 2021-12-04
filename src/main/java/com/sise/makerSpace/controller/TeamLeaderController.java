package com.sise.makerSpace.controller;

import com.sise.makerSpace.service.TeamService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/team/leader")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeamLeaderController {

    @Autowired
    private TeamService teamService;

    private ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @PutMapping("/changeLeader")    //有精力的话检测下是否本队、是否本人!!!!!!!!!!!!
    public ReturnMsgUtils changeLeader(@RequestParam("team_id")int team_id,@RequestParam("user_id")int newLeader){
        teamService.changeLeader(team_id,newLeader);
        return returnMsgUtils.success("更换成功！");
    }

    @PostMapping("/addManager")
    public ReturnMsgUtils addManager(@RequestParam("team_id")int team_id,@RequestParam("user_id")int user_id){
        teamService.addManager(team_id,user_id);
        return returnMsgUtils.success("添加成功！");
    }

    @DeleteMapping("/delManager")
    public ReturnMsgUtils delManager(@RequestParam("tm_id")int tm_id){
        teamService.delManager(tm_id);
        return returnMsgUtils.success("撤销职位成功！");
    }
}
