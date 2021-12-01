package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Team {
    private int team_id;
    private String team_name;
    private String category;
    private int teacher_id;
    private int leader_id;
    private String team_describe;
}
