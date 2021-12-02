package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.ReviewCreateTeam;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.domain.TeamMember;

import java.util.List;

public interface TeamService {
    List<TeamMember> findAllTeamMember();

    void applyToCreateATeam(Team team);

    Team getTeamInfo(int team_id);

    void addTeam(String team_name, String category, int teacher_id, int applicant_id, String team_describe);

    Team getTeamInfoFromReviewId(int review_id);

}
