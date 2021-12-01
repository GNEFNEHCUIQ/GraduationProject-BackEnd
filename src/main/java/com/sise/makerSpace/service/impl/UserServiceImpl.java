package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.domain.Resume;
import com.sise.makerSpace.domain.User;
import com.sise.makerSpace.dao.UserDao;
import com.sise.makerSpace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int uid,String password){
        return userDao.getUserById(uid,password);
    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }

    @Override
    public boolean checkDuplicateName(String name) {
        if (userDao.checkDuplicateName(name)==null)
            return false;
        else
            return true;
    }

    @Override
    public List<Resume> getUserInfoByUserId(int user_id) {
        return userDao.getUserInfoByUserId(user_id);
    }

    @Override
    public void createResumeByName(String name) {
        userDao.createResumeByName(name);
    }
}
