package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.domain.ReviewCertifiedAsTeacher;
import com.sise.makerSpace.domain.ReviewCreateTeam;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.service.*;
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
    private TeamService teamService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ItemService itemService;

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

    @GetMapping(value = "/findUnreviewedCATA")
    public ReturnMsgUtils findUnreviewedCATA(){
        return returnMsgUtils.success("还没做！");
    }

    @GetMapping("/findAllCATApplication")
    public ReturnMsgUtils findAllCATApplication(){
        //Review_certified_as_teacher;
        //operationalStaffService.findAllCATApplication();
        return returnMsgUtils.setData(reviewService.findAllCATApplication());
    }

    @PutMapping(value = "/reviewCATApplication")
    public ReturnMsgUtils reviewCATApplication(@RequestBody ReviewCertifiedAsTeacher reviewCertifiedAsTeacher){
        reviewService.reviewCATApplication(
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

    @GetMapping("/findUnreviewedCTA")   //一定要老师那边t_approved为-1才select进去
    public ReturnMsgUtils findUnreviewedCTA(){
        return returnMsgUtils.success("还没做！");
    }

    @GetMapping("/findAllCTA")
    public ReturnMsgUtils findAllCTA(){
        return returnMsgUtils.success("还没做！");
    }

    @PutMapping(value = "reviewCTA")
    public ReturnMsgUtils reviewCTA(@RequestParam("review_id")int review_id,@RequestParam("handler_id")int handler_id,@RequestParam("h_approved")int approved) {
        reviewService.reviewCTApplication(review_id,handler_id,approved);
        if (approved == -1) {
            //发消息说没通过？
            return returnMsgUtils.success("审核成功！该用户未通过审核！");
        } else {    //insert into team (team_name,category,teacher_id,leader_id,team_describe) values (1,2,3,4,5)
            Team newTeam=teamService.getTeamInfoFromReviewId(review_id);
            teamService.addTeam(
                    newTeam.getTeam_name(),
                    newTeam.getCategory(),
                    newTeam.getTeacher_id(),
                    newTeam.getLeader_id(),
                    newTeam.getTeam_describe());
            return returnMsgUtils.success("审批成功！已自动创建团队："+newTeam.getTeam_name());
        }
    }

    @GetMapping("/getUnreviewedCIA")
    public ReturnMsgUtils getUnreviewedCIA(){
        return returnMsgUtils.success("还没做呢！哈哈！");
    }

    @GetMapping("/getAllCIA")
    public ReturnMsgUtils getAllCIA(){
        return returnMsgUtils.success("还没做呢！哈哈！");
    }

    @PutMapping("/reviewCIA")
    public ReturnMsgUtils reviewCIA(@RequestParam("review_id")int review_id,
                                    @RequestParam("handler_id")int handler_id,
                                    @RequestParam("h_approved")int h_approved){
        reviewService.reviewCIA(review_id,handler_id,h_approved);
        if (h_approved==-1){
            //发消息说没通过？
            return returnMsgUtils.success("审核成功！该用户未通过审核！");
        }else {
            Item newItem=itemService.getItemInfoFromReviewId(review_id);
            itemService.CreateItem(
                    newItem.getTeam_id(),
                    newItem.getItem_name(),
                    newItem.getItem_describe()
            );
            //System.out.println(newItem.getItem_describe());
            return returnMsgUtils.success("审批成功！该团队已创建项目："+newItem.getItem_name());
        }
    }

}
