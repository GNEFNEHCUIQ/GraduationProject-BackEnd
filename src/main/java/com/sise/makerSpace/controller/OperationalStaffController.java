package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.ReviewCertifiedAsTeacher;
import com.sise.makerSpace.domain.ReviewCreateTeam;
import com.sise.makerSpace.service.ArticleService;
import com.sise.makerSpace.service.OperationalStaffService;
import com.sise.makerSpace.service.RoleService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin/operation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OperationalStaffController {
    @Autowired
    private OperationalStaffService operationalStaffService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ArticleService articleService;

    ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @PostMapping(value = "/addArticle")
    public ReturnMsgUtils addArticle(@RequestParam("title") String title, @RequestParam("sort") String sort, @RequestParam("content") String content){
        System.out.println("title:"+title+",sort:"+sort+",content:"+content);
        int author=1;
        articleService.addArticle(title,sort,content,author);
        return returnMsgUtils.success("文章发表成功！");
    }

    @DeleteMapping (value = "/delArticle")
    public ReturnMsgUtils delArticle(@RequestParam("article_id")int article_id){
        System.out.println("article_id"+article_id);
        if (articleService.ifArticleExist(article_id)){
            return returnMsgUtils.fail("文章不存在");
        }else {
            articleService.delArticle(article_id);
            return returnMsgUtils.success("删除成功");
        }
    }

    @GetMapping("/findAllCATApplication")
    public ReturnMsgUtils findAllCATApplication(){
        //Review_certified_as_teacher;
        operationalStaffService.findAllCATApplication();
        return returnMsgUtils.setData(operationalStaffService.findAllCATApplication());
    }

    @PutMapping(value = "/reviewCATApplication")
    public ReturnMsgUtils reviewCATApplication(@RequestBody ReviewCertifiedAsTeacher reviewCertifiedAsTeacher){
        operationalStaffService.reviewCATApplication(
                reviewCertifiedAsTeacher.getReview_id(),
                reviewCertifiedAsTeacher.getHandler_id(),
                reviewCertifiedAsTeacher.getApproved());
        if (reviewCertifiedAsTeacher.getApproved()==-1){
            //发消息说没通过？
            return returnMsgUtils.success("审核成功！该用户未通过审核！");
        }else{
            roleService.addSomeOnesRole(reviewCertifiedAsTeacher.getApplicant_id(),3);
            return returnMsgUtils.success("审批成功！");
        }
    }

    @PutMapping(value = "reviewCTApplication")
    public ReturnMsgUtils reviewCTApplication(@RequestBody ReviewCreateTeam reviewCreateTeam) {
        operationalStaffService.reviewCTApplication(
                reviewCreateTeam.getReview_id(),
                reviewCreateTeam.getHandler_id(),
                reviewCreateTeam.getApproved()
        );
        if (reviewCreateTeam.getApproved() == -1) {
            //发消息说没通过？
            return returnMsgUtils.success("审核成功！该用户未通过审核！");
        } else {
            //roleService.addTeam(reviewCreateTeam.getApplicant_id(),3);
            return returnMsgUtils.success("审批成功！");
        }
    }

}
