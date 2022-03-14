package com.sise.makerSpace.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class Teacher {
    private int teacher_id;
    private int user_id;
    private int job_number;
    private String qualification;
    private String category;
    private String description;

}
