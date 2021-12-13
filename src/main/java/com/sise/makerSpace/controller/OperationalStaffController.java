package com.sise.makerSpace.controller;

import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.domain.ReviewCertifiedAsTeacher;
import com.sise.makerSpace.domain.ReviewCreateTeam;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.service.*;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

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

    @Autowired
    private UserService userService;

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

    @PutMapping("/reviewCTA")
    public ReturnMsgUtils reviewCTA(@RequestParam("review_id")int review_id,
                                    @RequestParam("h_approved")int h_approved,
                                    Principal principal){
        reviewService.reviewCTA(review_id,h_approved,userService.getUserByUserName(principal.getName()).getUser_id());
        if (h_approved==-1){
            return returnMsgUtils.success("操作成功！已拒绝该请求");
        }else{
            ReviewCreateTeam team_info=reviewService.getCTAInfoByRid(review_id);
            System.out.println("team_info="+team_info);
            teamService.addTeam(
                    team_info.getTeam_name(),
                    team_info.getCategory(),
                    team_info.getTeacher_id(),
                    team_info.getApplicant_id(),
                    team_info.getTeam_describe());
            teamService.addTeammenber(team_info.getApplicant_id(),teamService.getTeamIdByTeamName(team_info.getTeam_name()));
            roleService.addSomeOnesRole(team_info.getApplicant_id(),6);
            return returnMsgUtils.success("审核已通过！已创建团队"+team_info.getTeam_name());
        }
    }

    @GetMapping("/findAllCATApplication")
    public ReturnMsgUtils findAllCATApplication(){
        //Review_certified_as_teacher;
        //operationalStaffService.findAllCATApplication();
        return returnMsgUtils.setData(reviewService.findAllCATApplication());
    }


    @GetMapping("/findUnreviewedCTA")
    public ReturnMsgUtils findUnreviewedCTA(){

        return returnMsgUtils.setData(reviewService.findUnreviewedCTA());
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


    @GetMapping("/findAllCTA")
    public ReturnMsgUtils findAllCTA(){
        return returnMsgUtils.success("还没做！");
    }


    @GetMapping("/findUnreviewedCIA")
    public ReturnMsgUtils getUnreviewedCIA(){
        return returnMsgUtils.success("还没做呢！哈哈！");
    }

    @GetMapping("/findAllCIA")
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
