package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.dao.TeamDao;
import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.domain.TeamMember;
import com.sise.makerSpace.service.TeamService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao teamDao;

    @Override
    public List<TeamMember> findAllTeamMember(int team_id) {
        return teamDao.findAllTeamMember(team_id);
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

    @Override
    public List<Team> findAllTeam() {
        return teamDao.findAllTeam();
    }

    @Override
    public List<Team> findTeamByTeamName(String team_name) {
        return teamDao.findTeamByTeamName(team_name);
    }

    @Override
    public List<Team> findTeamByCategory(String category) {
        return teamDao.findTeamByCategory(category);
    }

    @Override
    public List<Item> findItemByTeamId(int team_id) {
        return teamDao.findItemByTeamId(team_id);
    }

    @Override
    public void inviteSBJoinTeam(int team_id, int user_id) {
        teamDao.inviteSBJointeam(team_id,user_id);
    }

    @Override
    public void letJoinTeam(int team_id, int member_id) {
        teamDao.letJoinTeam(team_id,member_id);
    }

    @Override
    public void changeLeader(int team_id, int newLeader) {
        teamDao.changeLeader(team_id,newLeader);
    }

    @Override
    public void addManager(int team_id, int user_id) {
        teamDao.addManager(team_id,user_id);
    }

    @Override
    public void delManager(int tm_id) {
        teamDao.delManager(tm_id);
    }


}
