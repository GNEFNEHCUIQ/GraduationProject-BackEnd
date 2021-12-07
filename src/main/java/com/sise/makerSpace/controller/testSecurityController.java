package com.sise.makerSpace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testSecurityController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/team/item/test2")
    public String test2(){
        return "test2";
    }
}
