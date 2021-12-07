package com.sise.makerSpace.config.component;

import com.sise.makerSpace.domain.Menu;
import com.sise.makerSpace.domain.Role;
import com.sise.makerSpace.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

//根据请求的url分析请求所需的角色
public class CustomFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> menus = menuService.getMenuWithRole();
        for (Menu menu : menus){
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                String[] strings=menu.getRoles().stream().map(Role::getRole_name).toArray(String[]::new);
                return SecurityConfig.createList(strings);
            }
        }

        return SecurityConfig.createList("ROLE_visitor");
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
