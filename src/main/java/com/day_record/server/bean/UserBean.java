package com.day_record.server.bean;

import java.util.Date;

/**
 * @author JereChen
 */
public class UserBean {

    private Long id;
    private String username;
    private String password;
    private String introduce;
    private Date registerDate;

    public UserBean() {

    }

    public UserBean(UserBean userBean) {
        this(userBean.getId(), userBean.getUsername(), userBean.getPassword(), userBean.getIntroduce(), userBean.getRegisterDate());
    }

    public UserBean(Long id, String username, String password, String introduce, Date registerDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.introduce = introduce;
        this.registerDate = registerDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", introduce='" + introduce + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
