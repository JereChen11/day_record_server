package com.day_record.server.service;

import com.day_record.server.bean.UserBean;

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
     * @param name
     * @param password
     */
    UserBean login(String name, String password);

    /**
     * 更新用户信息
     *
     * @param userBean
     */
    int updateUserInfo(UserBean userBean);

    /**
     * 通过指定ID来获取用户信息
     *
     * @param id
     * @return
     */
    UserBean getUserById(Long id);
}
