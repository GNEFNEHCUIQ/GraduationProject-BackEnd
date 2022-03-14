package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreateItem {
    private int review_id;
    private int applicant_team_id;
    private String item_name;
    private String item_describe;
    private int teacher_id;
    private int t_approved;
    private int handler_id;
    private int h_approved;
    private String creation_time;
    private String handling_time;
}
