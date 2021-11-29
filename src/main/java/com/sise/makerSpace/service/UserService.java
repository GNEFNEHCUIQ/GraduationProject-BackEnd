package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.User;

public interface UserService {
     User getUserById(int uid, String password);

    void register(User user);

    boolean checkDuplicateName(String name);
}
