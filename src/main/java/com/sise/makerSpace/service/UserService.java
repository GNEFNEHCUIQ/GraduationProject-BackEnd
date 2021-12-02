package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.Resume;
import com.sise.makerSpace.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserService {
     User getUserById(int uid, String password);

    void register(User user);

    boolean checkDuplicateName(String name);

    List<Resume> getUserInfoByUserId(int uid);

    void createResumeByName(String name);

    boolean isTeacher(int user_id);

    void certifiedAsTeacher(int user_id);

    boolean alreadyCommitTeacherApply(int user_id);

    void initROU(String name);
}
