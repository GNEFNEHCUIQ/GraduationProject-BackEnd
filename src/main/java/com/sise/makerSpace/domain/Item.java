package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private int item_id;
    private int team_id;
    private String item_name;
    private int item_status;
    private String item_describe;
    private String create_time;
}
