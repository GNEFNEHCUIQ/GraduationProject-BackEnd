package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionInfo {
    private int competition_id;
    private String competition_name;
    private String level;
    private String describe;
}
