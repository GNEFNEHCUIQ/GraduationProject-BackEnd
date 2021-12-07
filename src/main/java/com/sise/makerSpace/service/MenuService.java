package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {
    List<Menu> getMenuByUserId();

    List<Menu> getMenuWithRole();
}
