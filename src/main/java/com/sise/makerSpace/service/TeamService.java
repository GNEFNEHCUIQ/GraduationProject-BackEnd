package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.domain.TeamMember;

import java.util.List;

public interface TeamService {
    List<TeamMember> findAllTeamMember();

    void applyToCreateATeam(Team team);

    Team getTeamInfo(int team_id);
}
