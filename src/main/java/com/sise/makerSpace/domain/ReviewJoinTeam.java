package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewJoinTeam {
    private int review_id;
    private int applicant_id;
    private int team_id;
    private int t_approved;
    private String creation_time;
    private String handling_time;
}
