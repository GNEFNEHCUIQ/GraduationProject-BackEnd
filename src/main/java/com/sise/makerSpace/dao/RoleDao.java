package com.sise.makerSpace.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleDao {
    public void addSomeOnesRole(int applicant_id, int role_id);
}
