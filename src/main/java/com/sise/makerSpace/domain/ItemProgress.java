package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
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
    private String handle_time;

    private List<ItemProgress> children;

}
