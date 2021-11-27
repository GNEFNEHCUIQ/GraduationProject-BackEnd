package com.sise.makerSpace.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class TeamMember {
        private int memberId;
        private int userId;
        private int teamId;
        private String role;

}
