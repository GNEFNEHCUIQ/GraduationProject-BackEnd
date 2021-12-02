package com.sise.makerSpace.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class ReviewCertifiedAsTeacher {
    private int review_id;
    private int applicant_id;
    private int handler_id;
    private int approved;
    private String creation_time;
    private String handling_time;
}
