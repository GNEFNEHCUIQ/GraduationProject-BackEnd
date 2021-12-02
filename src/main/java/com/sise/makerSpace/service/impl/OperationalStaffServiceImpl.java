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

    @Override
    public List<ReviewCertifiedAsTeacher> findAllCATApplication() {
        return operationalStaffDao.findAllCATApplication();
    }

    @Override
    public void reviewCATApplication(int review_id,int handler_id, int approved) {
        operationalStaffDao.reviewCATApplication(review_id,handler_id,approved);
    }

    @Override
    public void reviewCTApplication(int review_id, int handler_id, int approved) {
        operationalStaffDao.reviewCTApplication(review_id,handler_id,approved);
    }
}
