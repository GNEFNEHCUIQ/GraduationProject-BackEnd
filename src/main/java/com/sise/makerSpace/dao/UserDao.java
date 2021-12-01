package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.Resume;
import com.sise.makerSpace.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDao {
    /*@Select("select * from user where uid=#{uid} and password=#{password}")*/
    User getUserById(int uid,String password) ;

    void register(User user);

    User checkDuplicateName(String name);

    List<Resume> getUserInfoByUserId(int user_id);

    void createResumeByName(String name);

    Integer isTeacher(Integer user_id);

    void certifiedAsTeacher(int user_id);
}
