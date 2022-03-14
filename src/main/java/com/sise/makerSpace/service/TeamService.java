package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.Item;
import com.sise.makerSpace.domain.Team;
import com.sise.makerSpace.domain.TeamMember;
import com.sise.makerSpace.utils.ReturnMsgUtils;

import java.util.List;
import java.util.Map;

public interface TeamService {
    List<TeamMember> findAllTeamMember(int team_id);

    void applyToCreateATeam(Team team);

    Team getTeamInfo(int team_id);

    void addTeam(String team_name, String category, int teacher_id, int applicant_id, String team_describe);

    Team getTeamInfoFromReviewId(int review_id);

    void applyToCreateItem(int applicant_team_id, String item_name, String item_describe);

    List<Team> findAllTeam();

    List<Team> findTeamByTeamName(String team_name);

    List<Team> findTeamByCategory(String category);

    List<Item> findItemByTeamId(int team_id);

    void inviteSBJoinTeam(int team_id, int user_id);

    void letJoinTeam(int team_id, int user_id);

    void changeLeader(int team_id, int newLeader);

    void addManager(int team_id, int user_id);

    void delManager(int tm_id);

    List<Team> getYourTeam(int user_id);

    Integer getTeacherIdByRealName(String teacherRealName);

    boolean checkTeamNameIfExist(String team_name);

    int getTeamIdByTeamName(String team_name);

    void addTeammenber(int user_id, int team_id);

    int findTeacherByTid(int team_id);

    List<Map<String, String>> getTeacherList();
}
