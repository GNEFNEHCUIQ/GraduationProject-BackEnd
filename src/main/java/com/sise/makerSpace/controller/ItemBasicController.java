package com.sise.makerSpace.controller;

import com.sise.makerSpace.service.ItemService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/team/item/basic")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemBasicController {
    @Autowired
    private ItemService itemService;

    private ReturnMsgUtils returnMsgUtils;

    @GetMapping("/findTeamAllItem")
    public ReturnMsgUtils findTeamAllItem(@RequestParam("team_id")int team_id){
        return returnMsgUtils.setData(itemService.findTeamAllItem(team_id));
    }

    @GetMapping("/findProgressById")
    public ReturnMsgUtils findProgressById(@RequestParam("item_id")int item_id){
        return returnMsgUtils.setData(itemService.findProgressById(item_id));
    }




}
