package com.day_record.server.service;

import com.day_record.server.bean.UserBean;

import java.util.List;

/**
 * @author JereChen
 */
public interface UserService {

    /**
     * 注册
     *
     * @param name
     * @param password
     */
    void register(String name, String password, String introduce);

    /**
     * 登入
     *
     * @param username
     * @param password
     */
    UserBean login(String username, String password);

    /**
     * 登出
     *
     * @param userId
     * @return
     */
    Boolean logout(Long userId);

    /**
     * 更新用户信息
     *
     * @param userBean
     */
    int updateUserInfo(UserBean userBean);

    /**
     * 通过指定ID来获取用户信息
     *
     * @param userId
     * @return
     */
    UserBean getUserById(Long userId);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<UserBean> getAllUsers();
}
