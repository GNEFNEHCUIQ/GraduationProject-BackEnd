package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.dao.ReviewDao;
import com.sise.makerSpace.domain.*;
import com.sise.makerSpace.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewDao reviewDao;


    @Override
    public List<ReviewCreateTeam> findUnreviewedCTA() {
        return reviewDao.findUnreviewedCTA();
    }

    @Override
    public List<ReviewCertifiedAsTeacher> findAllCATApplication() {
        return reviewDao.findAllCATApplication();
    }

    @Override
    public void reviewCATApplication(int review_id,int handler_id, int h_approved) {
        reviewDao.reviewCATApplication(review_id,handler_id,h_approved);
    }

    @Override
    public void reviewCTApplication(int review_id, int handler_id, int approved) {
        reviewDao.reviewCTApplication(review_id,handler_id,approved);
    }

    /*下面是老师的*/

    @Override
    public List<ReviewCreateTeam> findATeachersUnreviewedCTA(int teacher_id) {
        return reviewDao.findATeachersUnreviewedCTA(teacher_id);
    }

    @Override
    public List<ReviewCreateTeam> findATeachersAllCTA(int teacher_id) {
        return reviewDao.findATeachersAllCTA(teacher_id);
    }

    @Override
    public void reviewTeacherCTA(int review_id, int teacher_id, int t_approved) {
        reviewDao.reviewTeacherCTA(review_id,teacher_id,t_approved);
    }

    @Override
    public void reviewCIA(int review_id, int handler_id, int h_approved) {
        reviewDao.reviewCIA(review_id,handler_id,h_approved);
    }

    @Override
    public void reviewJoinTeamAppl(int review_id,  int t_approved,int t_handler) {
        reviewDao.reviewJoinTeamAppl(review_id,t_approved,t_handler);
    }

    @Override
    public TeamMember getTidAndUidFromReview(int review_id) {
        return reviewDao.getTidAndUidFromReview(review_id);
    }

    @Override
    public void reviewCTA(int review_id, int h_approved,int handler_id) {
        reviewDao.reviewCTA(review_id,h_approved,handler_id);
    }

    @Override
    public ReviewCreateTeam getCTAInfoByRid(int review_id) {
        return reviewDao.getCTAInfoByRid(review_id);
    }

    @Override
    public List<ReviewCreateItem> getUnreviewedCIAByTId(int teacher_id) {
        return reviewDao.getUnreviewedCIAByTId(teacher_id);
    }

    @Override
    public void reviewTeacherCIA(int review_id, int t_approved) {
        reviewDao.reviewTeacherCIA(review_id,t_approved);
    }

    @Override
    public List<ReviewJoinTeam> getJoinTeamReview(int user_id) {
        return reviewDao.getJoinTeamReview(user_id);
    }

    @Override
    public List<ReviewCreateItem> findUnreviewedCIA() {
        return reviewDao.findUnreviewedCIA();
    }

    @Override
    public List<ReviewCertifiedAsTeacher> findUnreviewedCATA() {
        return reviewDao.findUnreviewedCATA();
    }
}
