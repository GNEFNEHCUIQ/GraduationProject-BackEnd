package com.sise.makerSpace.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class TeamMember {
        private int member_id;
        private int user_id;
        private int team_id;
        private String role;

}
