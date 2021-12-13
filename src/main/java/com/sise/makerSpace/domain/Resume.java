package com.sise.makerSpace.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Repository
public class Resume {
    private Integer resume_id;
    private Integer user_id;
    private String real_name;
    private String gender;
    private String birthday;
    private String phone;
    private String school;
    private String education;
    private String experience;
    private String self_assessment;

    /*private User user;

    public Resume(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUser_id() {
        return user.getUser_id();
    }

    public void setUserId(int user_id) {
        user.setUser_id(user_id);
    }

    public String getPassword() {
        return user.getPassword();
    }

    public void setPassword(String password) {
        user.setPassword(password);
    }

    public String getName() {
        return user.getUsername();
    }

    public void setName(String name) {
        user.setUser_name(name);
    }*/

}
