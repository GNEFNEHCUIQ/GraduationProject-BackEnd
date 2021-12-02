package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.dao.OperationalStaffDao;
import com.sise.makerSpace.domain.ReviewCertifiedAsTeacher;
import com.sise.makerSpace.service.OperationalStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationalStaffServiceImpl implements OperationalStaffService {
    @Autowired
    OperationalStaffDao operationalStaffDao;


}
