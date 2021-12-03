package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.ReviewCreateTeam;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.domain.TeamMember;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeamDao {
    List<TeamMember> findAllTeamMember();

    void applyToCreateATeam(Team team);

    Team getTeamInfo(int team_id);

    void addTeam(String team_name, String category, int teacher_id, int applicant_id, String team_describe);

    Team getTeamInfoFromReviewId(int review_id);

    void applyToCreateItem(int applicant_team_id, String item_name, String item_describe);
}
