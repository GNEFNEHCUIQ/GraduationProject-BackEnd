package com.sise.makerSpace.dao;

import com.sise.makerSpace.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDao {
    public List<Menu> getMenuByUserId(int user_id) ;

    List<Menu> getMenuWithRole();
}
