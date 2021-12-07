package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private int menu_id;
    private String url;
    private String path;
    private String component;
    private String menu_name;
    private String icon;
    private String parent_id;

    //@TableField(exist = false)
    private List<Role> roles;



}
