package com.sise.makerSpace.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class User {
        private int uid;
        private String password;
        private String name;
        private String role;
}
