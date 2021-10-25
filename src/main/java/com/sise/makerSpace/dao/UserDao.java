package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserDao {
    /*@Select("select * from user where uid=#{uid} and password=#{password}")*/
    User getUserById(User user) ;
}
