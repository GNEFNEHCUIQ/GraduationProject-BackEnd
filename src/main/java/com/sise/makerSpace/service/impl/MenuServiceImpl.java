package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.dao.MenuDao;
import com.sise.makerSpace.domain.Menu;
import com.sise.makerSpace.domain.User;
import com.sise.makerSpace.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenuByUserId() {
        return menuDao.getMenuByUserId(((User) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal()).getUser_id());
    }

    @Override
    public List<Menu> getMenuWithRole() {
        return menuDao.getMenuWithRole();
    }
}
