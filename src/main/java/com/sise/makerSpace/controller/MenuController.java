package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Menu;
import com.sise.makerSpace.service.MenuService;
import com.sise.makerSpace.service.UserService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/menu")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MenuController {
    @Autowired
    private MenuService menuService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @GetMapping("/getMenu")
    public ReturnMsgUtils getMenu(){
        return returnMsgUtils.setData(menuService.getMenuByUserId());
    }


}
