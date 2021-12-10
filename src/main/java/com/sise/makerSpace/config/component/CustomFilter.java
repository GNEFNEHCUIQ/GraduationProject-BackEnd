package com.sise.makerSpace.config.component;

import com.sise.makerSpace.domain.Menu;
import com.sise.makerSpace.domain.Role;
import com.sise.makerSpace.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
//根据请求的url分析请求所需的角色
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        System.out.println("requestUrl:"+requestUrl);
        List<Menu> menus = menuService.getMenuWithRole();
        System.out.println("menus："+menus);
        for (Menu menu : menus){
            System.out.println("match(menu.getUrl():"+menu.getUrl());
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                String[] strings=menu.getRoles().stream().map(Role::getRole_name).toArray(String[]::new);
                System.out.println("strings:"+ Arrays.toString(strings));
                return SecurityConfig.createList(strings);
            }
        }
        System.out.println("我还是出来了");
        return SecurityConfig.createList("ROLE_user");
        //return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
