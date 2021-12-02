package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.ReviewCertifiedAsTeacher;
import com.sise.makerSpace.domain.ReviewCreateTeam;

import java.util.List;

public interface ReviewService {

    List<ReviewCertifiedAsTeacher> findAllCATApplication();

    void reviewCATApplication(int review_id,int handler_id, int approved);

    void reviewCTApplication(int review_id, int handler_id, int approved);

    /*下面是老师的*/


    List<ReviewCreateTeam> findATeachersUnreviewedCTA(int teacher_id);

    List<ReviewCreateTeam> findATeachersAllCTA(int teacher_id);

    void reviewTeacherCTA(int review_id, int teacher_id, int t_approved);

}
