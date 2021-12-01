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

    @PostMapping(value = "/addArticle")
    public void addArticle(@RequestParam("title") String title,@RequestParam("sort") String sort,@RequestParam("content") String content){
        System.out.println("title:"+title+",sort:"+sort+",content:"+content);
        int author=1;
        articleService.addArticle(title,sort,content,author);
    }

    @PostMapping(value = "/delArticle")
    public ReturnMsgUtils delArticle(@RequestParam("article_id")int article_id){
        ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();
        System.out.println("article_id"+article_id);
        if (articleService.ifArticleExist(article_id)){
            return returnMsgUtils.fail("文章不存在");
        }else {
            articleService.delArticle(article_id);
            return returnMsgUtils.success("删除成功");
        }
    }



}
