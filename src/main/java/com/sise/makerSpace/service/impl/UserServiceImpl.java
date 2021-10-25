package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.domain.User;
import com.sise.makerSpace.dao.UserDao;
import com.sise.makerSpace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(User user){
        return userDao.getUserById(user);
    }
}
