package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionTeam {
    private int Cteam_id;
    private int Crecord_id;
    private int team_id;
    private String entry;
    private String CTdescribe;
}
