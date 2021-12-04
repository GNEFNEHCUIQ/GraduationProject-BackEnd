package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.ReviewCertifiedAsTeacher;
import com.sise.makerSpace.domain.ReviewCreateTeam;
import com.sise.makerSpace.domain.TeamMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ReviewDao {
    List<ReviewCreateTeam> findATeachersUnreviewedCTA(int teacher_id) ;

    List<ReviewCreateTeam> findATeachersAllCTA(int teacher_id);

    void reviewTeacherCTA(int review_id, int teacher_id, int approved);

    List<ReviewCertifiedAsTeacher> findAllCATApplication();

    void reviewCATApplication(int review_id,int handler_id, int approved);

    void reviewCTApplication(int review_id, int handler_id, int approved);

    void reviewCIA(int review_id, int handler_id, int h_approved);

    void reviewJoinTeamAppl(int review_id, int approved);

    TeamMember getTidAndUidFromReview(int review_id);
}
