package com.sise.makerSpace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    UserController userController;

    @GetMapping("/")
    public String index(){
        //return "welcome to maker space";
        /*return "index";*/

        return "hi!"+ userController.login(001,"admin");
    }
}
