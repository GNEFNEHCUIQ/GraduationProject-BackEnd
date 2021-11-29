package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    /*@Select("select * from user where uid=#{uid} and password=#{password}")*/
    User getUserById(int uid,String password) ;

    void register(User user);

    boolean checkDuplicateName(String name);
}
