package com.day_record.server.mapper;

import com.day_record.server.bean.UserBean;

import java.util.List;

/**
 * @author JereChen
 */
public interface UserMapper {

    /**
     * 获取所有用户信息
     *
     * @return
     */
    List<UserBean> selectAllUsers();

    /**
     * 通过指定ID来查找相对应用户
     *
     * @param userId
     * @return
     */
    UserBean selectUserById(Long userId);

    /**
     * 通过用户名来查找相对应用户
     *
     * @param name
     * @return userBean
     */
    UserBean selectUserByName(String name);

    /**
     * 通过用户名与密码来查找相对应用户
     *
     * @param username
     * @param password
     * @return userBean
     */
    UserBean selectUserByNameAndPassword(String username, String password);

    /**
     * 插入指定用户
     *
     * @param userBean
     */
    void insertUser(UserBean userBean);

    /**
     * 更新指定用户信息
     *
     * @param userBean
     */
    int updateUser(UserBean userBean);

    /**
     * 通过 id 来删除指定用户
     *
     * @param userId
     */
    void deleteUserById(Long userId);

}
