package com.sise.makerSpace.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/team/manager")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ItemManagerController {
}
