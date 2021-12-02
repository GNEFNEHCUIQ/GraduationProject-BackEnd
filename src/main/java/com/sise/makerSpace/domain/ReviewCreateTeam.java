package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreateTeam {
    private int review_id;
    private int applicant_id;
    private String team_name;
    private String category;
    private int teacher_id;
    private String team_describe;
    private int handler_id;
    private int approved;
    private String creation_time;

}
