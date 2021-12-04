package com.sise.makerSpace.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class ItemProgress {
    private int progress_id;
    private int item_id;
    private String demand;
    private int principal_id;
    private String priority;
    private int statue;
    private int progress_level;
    private int parent_item_id;
    private String progress_describe;
    private String creation_time;
}
