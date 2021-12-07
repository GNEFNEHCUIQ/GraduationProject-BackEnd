package com.sise.makerSpace.controller;

import com.sise.makerSpace.service.CompetitionService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/competition/basic")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CompetitionBasicController {
    @Autowired
    private CompetitionService competitionService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @GetMapping("/getCompeteInfo")
    public ReturnMsgUtils getCompetitionInfo(){
        return returnMsgUtils.setData(competitionService.getCompetitionInfo());
    }

    @GetMapping("/getAllCompeteRecord")
    public ReturnMsgUtils getAllCompetRecord(){
        return returnMsgUtils.setData(competitionService.getAllCompeteRecord());
    }

    @GetMapping("/getCompeteResultById")
    public ReturnMsgUtils getCompetitionResult(@RequestParam("Cresult_id")int Cresult_id){
        return returnMsgUtils.setData(competitionService.getCompetitionResult(Cresult_id));
    }


}
