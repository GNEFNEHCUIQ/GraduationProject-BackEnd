package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.*;

import java.util.List;

public interface ReviewService {


    List<ReviewCreateTeam> findUnreviewedCTA();

    List<ReviewCertifiedAsTeacher> findAllCATApplication();

    void reviewCATApplication(int review_id,int h_handler_id, int approved);

    void reviewCTApplication(int review_id, int handler_id, int approved);

    void reviewCTA(int review_id, int h_approved,int handler_id);

    /*下面是老师的*/


    List<ReviewCreateTeam> findATeachersUnreviewedCTA(int teacher_id);

    List<ReviewCreateTeam> findATeachersAllCTA(int teacher_id);

    void reviewTeacherCTA(int review_id, int teacher_id, int t_approved);

    void reviewCIA(int review_id, int handler_id, int h_approved);

    void reviewJoinTeamAppl(int review_id,int t_approved,int t_handler);

    TeamMember getTidAndUidFromReview(int review_id);


    ReviewCreateTeam getCTAInfoByRid(int review_id);

    List<ReviewCreateItem> getUnreviewedCIAByTId(int teacher_id);

    void reviewTeacherCIA(int review_id, int t_approved);

    List<ReviewJoinTeam> getJoinTeamReview(int user_id);

    List<ReviewCreateItem> findUnreviewedCIA();

    List<ReviewCertifiedAsTeacher> findUnreviewedCATA();
}
