package com.sise.makerSpace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    VisitorController visitorController;

    @GetMapping("/")
    public String index(){
        //return "welcome to maker space";
        return "index";

        //return "hi!"+ userController.login(001,"admin");
    }

    @GetMapping("/toLoginPage")
    public String toLoginPage(){
        return "login";
    }

    @GetMapping("/toHomePage")
    public String toHomePage(){
        return "homePage";
    }

    @GetMapping("/toTeamPage")
    public String toTeamPage(){return "teamPage/teamView";}
}
