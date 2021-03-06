package com.sise.makerSpace.service.impl;

import com.sise.makerSpace.config.JwtTokenConfig;
import com.sise.makerSpace.domain.*;
import com.sise.makerSpace.dao.UserDao;
import com.sise.makerSpace.service.UserService;
import com.sise.makerSpace.utils.ReturnMsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenConfig jwtTokenConfig;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private ReturnMsgUtils returnMsgUtils=new ReturnMsgUtils();

    @Override
    public User getUserByUserName(String user_name,String password){
        return userDao.getUserById(user_name,password);
    }

    @Override
    public User getUserByUserName(String user_name){
        return userDao.getUserByUserName(user_name);
    }

    @Override
    public ReturnMsgUtils login(String user_name, String password, HttpServletRequest request) {
        UserDetails userDetails=userDetailsService.loadUserByUsername(user_name);
        String encode = passwordEncoder.encode(userDetails.getPassword());
        if (null==userDetails || !passwordEncoder.matches(password,encode)){
            System.out.println("passwordEncoder.matches:"+passwordEncoder.matches(password,userDetails.getPassword()));
            return returnMsgUtils.fail("???????????????????????????");
        }
        UsernamePasswordAuthenticationToken authenticationToken=new
                UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        String token=jwtTokenConfig.generateToken(userDetails);
        Map<String,String> tokenMap=new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        System.out.println("tokenMap:"+tokenMap);
        return returnMsgUtils.setData(tokenMap);
    }

    @Override
    public void applyJoinTeam(int user_id, int team_id) {
        userDao.applyJoinTeam(user_id,team_id);
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
    public Resume getUserResume(int user_id) {
        return userDao.getUserResume(user_id);
    }

    @Override
    public void createResumeByName(String name) {
        userDao.createResumeByName(name);
    }

    @Override
    public boolean isTeacher(int user_id) {
        if (userDao.isTeacher(user_id)==0)
            return false;
        else
            return true;
    }

    @Override
    public void certifiedAsTeacher(Teacher teacher) {
        userDao.certifiedAsTeacher(teacher);
    }

    @Override
    public boolean alreadyCommitTeacherApply(int user_id) {
        if (userDao.alreadyCommitTeacherApply(user_id)!=0)
            return true;
        else
            return false;
    }

    @Override
    public void initROU(String name) {
        userDao.initROU(name);
    }

    @Override
    public List<Role> getRoles(Integer user_id) {
        return userDao.getRoles(user_id);
    }

    @Override
    public void updateUserResume(Resume resume) {
        userDao.updateUserResume(resume);
    }

}
