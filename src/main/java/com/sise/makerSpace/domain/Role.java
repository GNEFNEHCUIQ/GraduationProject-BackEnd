package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private int role_id;
    private String role_name;
    private String role_nameCN;


}
