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
public class Menu {
    private Integer menu_id;
    private String url;
    private String path;
    private String component;
    private String name;
    private String icon;
    private Integer parent_id;

    private List<Menu> children;

    private List<Role> roles;

}
