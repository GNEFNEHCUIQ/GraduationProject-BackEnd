package com.sise.makerSpace.dao;

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
}
