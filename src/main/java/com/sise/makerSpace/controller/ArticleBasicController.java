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

@RestController
@RequestMapping(value = "/article/basic")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArticleBasicController {

    @Autowired
    private ArticleService articleService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    /*@GetMapping(value = "/findAllArticleWithPage") //result：pageNum,pageSize,totalPages,totalSize
    public PageResult findAllArticleWithPage(@RequestParam("pageNum") int pageNum,@RequestParam("pageSize") int pageSize){
        PageRequest pageRequest=new PageRequest(pageNum,pageSize);
        System.out.println("pageRequest"+pageRequest);
        return articleService.findAllArticleWithPage(pageRequest);
    }*/

    @GetMapping(value = "/findAllArticleWithPage") //result：pageNum,pageSize,totalPages,totalSize
    public ReturnMsgUtils findAllArticleWithPage(){
        PageRequest pageRequest=new PageRequest(1,10);
        System.out.println("pageRequest"+pageRequest);
        return returnMsgUtils.setData(  articleService.findAllArticleWithPage(pageRequest));
    }

    @PostMapping(value = "/findArticleBySort")
    public PageResult findArticle(@RequestParam("sort")String sort, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize){
        System.out.println("sort:"+sort+",pageNum"+",pageSize:"+pageSize);
        PageRequest pageRequest=new PageRequest(pageNum,pageSize);
        System.out.println("pageRequest"+pageRequest);
        return articleService.findArticle(sort,pageRequest);
    }

}
