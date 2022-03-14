package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.domain.ItemProgress;
import com.sise.makerSpace.service.ItemService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/team/item/manager")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemManagerController {

    @Autowired
    private ItemService itemService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @PostMapping("/createDemand")
    public ReturnMsgUtils createDemand(@RequestBody ItemProgress itemProgress){
        itemService.createDemand(itemProgress);
        return returnMsgUtils.success("创建需求成功");
    }

    @GetMapping("/getItemProgress")
    public ReturnMsgUtils getItemProgress(@RequestParam("item_id")int item_id){
        return returnMsgUtils.setData(itemService.getItemProgress(item_id));
    }

    @PutMapping ("/checkProgress")
    public ReturnMsgUtils checkProgress(@RequestParam("progress_id")int progress_id){
        itemService.checkProgress(progress_id);
        return returnMsgUtils.success("已完成！");
    }

    @DeleteMapping("/deleteProgress")
    public ReturnMsgUtils deleteProgress(@RequestParam("progress_id")int progress_id){
        itemService.deleteProgress(progress_id);
        return returnMsgUtils.success("已完成！");
    }

    @GetMapping("/getOneProgressById")
    public ReturnMsgUtils getOneProgressById(@RequestParam("progress_id")int progress_id){
        ItemProgress itemProgress=itemService.getOneProgressById(progress_id);
        return returnMsgUtils.setData(itemProgress,null);
    }

    @PutMapping("/updateProgress")
    public ReturnMsgUtils updateProgress(@RequestBody ItemProgress itemProgress){
        itemService.updateProgress(itemProgress);
        return returnMsgUtils.success("修改成功！");
    }

}
