package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.ReviewCertifiedAsTeacher;

import java.util.List;

public interface OperationalStaffService {
    List<ReviewCertifiedAsTeacher> findAllCATApplication();

    void reviewCATApplication(int review_id,int handler_id, int approved);

    void reviewCTApplication(int review_id, int handler_id, int approved);
}
