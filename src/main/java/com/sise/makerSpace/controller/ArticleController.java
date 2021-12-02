package com.sise.makerSpace.controller;

import com.github.pagehelper.PageHelper;
import com.sise.makerSpace.domain.Article;
import com.sise.makerSpace.domain.PageRequest;
import com.sise.makerSpace.domain.PageResult;
import com.sise.makerSpace.service.ArticleService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/article")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArticleController {

    //private static int _pageIndex=0;
    //private static int _pageSize=5;

    @Autowired
    private ArticleService articleService;



    @PostMapping(value = "/findAllArticleWithPage") //result：pageNum,pageSize,totalPages,totalSize
    public PageResult findAllArticleWithPage(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        PageRequest pageRequest=new PageRequest(pageNum,pageSize);
        System.out.println("pageRequest"+pageRequest);
        return articleService.findAllArticleWithPage(pageRequest);
    }

    @PostMapping(value = "/findArticle")   //没前端做不了阿
    public PageResult findArticle(@RequestParam("sort")String sort, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        System.out.println("sort:"+sort+",pageNum"+",pageSize:"+pageSize);
        PageRequest pageRequest=new PageRequest(pageNum,pageSize);
        System.out.println("pageRequest"+pageRequest);
        return articleService.findArticle(sort,pageRequest);
    }






}
