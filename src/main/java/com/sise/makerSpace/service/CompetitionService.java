package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.CompetitionInfo;
import com.sise.makerSpace.domain.CompetitionRecord;
import com.sise.makerSpace.domain.CompetitionResult;
import com.sise.makerSpace.domain.CompetitionTeam;

public interface CompetitionService {
    CompetitionInfo getCompetitionInfo();

     CompetitionRecord getAllCompeteRecord();

    CompetitionResult getCompetitionResult(int cresult_id);

    void enterCompetition(CompetitionTeam competitionTeam);
}
