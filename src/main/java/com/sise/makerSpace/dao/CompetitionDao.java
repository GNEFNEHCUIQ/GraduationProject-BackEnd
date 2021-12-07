package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.CompetitionInfo;
import com.sise.makerSpace.domain.CompetitionRecord;
import com.sise.makerSpace.domain.CompetitionResult;
import com.sise.makerSpace.domain.CompetitionTeam;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompetitionDao {
    CompetitionInfo getCompetitionInfo() ;

    CompetitionRecord getAllCompeteRecord();

    CompetitionResult getCompetitionResult(int cresult_id);

    void enterCompetition(CompetitionTeam competitionTeam);
}
