package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.dao.TeamDao;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.domain.TeamMember;
import com.sise.makerSpace.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao teamDao;

    @Override
    public List<TeamMember> findAllTeamMember() {
        return teamDao.findAllTeamMember();
    }

    @Override
    public void applyToCreateATeam(Team team) {
        teamDao.applyToCreateATeam(team);
    }

    @Override
    public Team getTeamInfo(int team_id) {
        return teamDao.getTeamInfo(team_id);
    }
}
