package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionRecord {
    private int Crecord_id;
    private int competition_id;
    private int session;
    private String start_time;
    private String end_time;
    private String CRdescribe;
}
