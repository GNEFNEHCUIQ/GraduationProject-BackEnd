package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.ReviewCertifiedAsTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OperationalStaffDao {
    List<ReviewCertifiedAsTeacher> findAllCATApplication();

    void reviewCATApplication(int review_id,int handler_id, int approved);

    void reviewCTApplication(int review_id, int handler_id, int approved);
}
