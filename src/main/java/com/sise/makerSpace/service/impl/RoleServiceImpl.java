package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.dao.RoleDao;
import com.sise.makerSpace.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    public static final int _ADMIN=1;
    public static final int _USER=1;
    public static final int _TEAM_MANAGER=1;
    public static final int _TEACHER=1;
    public static final int _STUFF=1;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void addSomeOnesRole(int applicant_id, int role_id) {
        roleDao.addSomeOnesRole(applicant_id,role_id);
    }
}
