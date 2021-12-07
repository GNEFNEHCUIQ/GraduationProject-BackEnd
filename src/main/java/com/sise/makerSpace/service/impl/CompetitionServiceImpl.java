package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.dao.CompetitionDao;
import com.sise.makerSpace.domain.CompetitionInfo;
import com.sise.makerSpace.domain.CompetitionRecord;
import com.sise.makerSpace.domain.CompetitionResult;
import com.sise.makerSpace.domain.CompetitionTeam;
import com.sise.makerSpace.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionDao competitionDao;

    @Override
    public CompetitionInfo getCompetitionInfo() {
        return competitionDao.getCompetitionInfo();
    }

    @Override
    public CompetitionRecord getAllCompeteRecord() {
        return competitionDao.getAllCompeteRecord();
    }

    @Override
    public CompetitionResult getCompetitionResult(int cresult_id) {
        return competitionDao.getCompetitionResult(cresult_id);
    }

    @Override
    public void enterCompetition(CompetitionTeam competitionTeam) {
        competitionDao.enterCompetition(competitionTeam);
    }
}
