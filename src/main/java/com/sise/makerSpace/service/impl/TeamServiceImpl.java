package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.dao.TeamDao;
import com.sise.makerSpace.domain.ReviewCreateTeam;
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

    @Override
    public void addTeam(String team_name, String category, int teacher_id, int applicant_id, String team_describe) {
        teamDao.addTeam(team_name,category,teacher_id,applicant_id,team_describe);
    }

    @Override
    public Team getTeamInfoFromReviewId(int review_id) {
        return teamDao.getTeamInfoFromReviewId(review_id);
    }

    @Override
    public void applyToCreateItem(int applicant_team_id, String item_name, String item_describe) {
        teamDao.applyToCreateItem(applicant_team_id,item_name,item_describe);
    }


}
