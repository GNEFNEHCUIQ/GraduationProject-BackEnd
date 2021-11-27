package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Article;
import com.sise.makerSpace.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/article")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/findAllArticle")
    public List<Article> findAllArticle(){
        return articleService.findAllArticle();
    }
}
