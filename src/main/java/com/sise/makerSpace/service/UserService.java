package com.sise.makerSpace.service;

import com.sise.makerSpace.domain.*;
import com.sise.makerSpace.utils.ReturnMsgUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
     //User getUserById(int uid, String password);

    void register(User user);

    boolean checkDuplicateName(String name);

    Resume getUserResume(int user_id);

    void createResumeByName(String name);

    boolean isTeacher(int user_id);

    void certifiedAsTeacher(Teacher teacher);

    boolean alreadyCommitTeacherApply(int user_id);

    void initROU(String name);

    User getUserByUserName(String user_name, String password);

    User getUserByUserName(String user_name);

    ReturnMsgUtils login(String user_name, String password, HttpServletRequest request);

    void applyJoinTeam(int user_id,int team_id);

    List<Role> getRoles(Integer user_id);

    void updateUserResume(Resume resume);
}
