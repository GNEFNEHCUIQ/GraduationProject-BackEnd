package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.dao.ReviewDao;
import com.sise.makerSpace.domain.ReviewCertifiedAsTeacher;
import com.sise.makerSpace.domain.ReviewCreateTeam;
import com.sise.makerSpace.domain.TeamMember;
import com.sise.makerSpace.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewDao reviewDao;


    @Override
    public List<ReviewCertifiedAsTeacher> findAllCATApplication() {
        return reviewDao.findAllCATApplication();
    }

    @Override
    public void reviewCATApplication(int review_id,int handler_id, int approved) {
        reviewDao.reviewCATApplication(review_id,handler_id,approved);
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
    public void reviewJoinTeamAppl(int review_id,  int approved) {
        reviewDao.reviewJoinTeamAppl(review_id,approved);
    }

    @Override
    public TeamMember getTidAndUidFromReview(int review_id) {
        return reviewDao.getTidAndUidFromReview(review_id);
    }
}
