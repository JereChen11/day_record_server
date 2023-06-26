package com.day_record.server.serviceImpl;

import com.day_record.server.bean.UserBean;
import com.day_record.server.mapper.UserMapper;
import com.day_record.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author JereChen
 */
@Service
public class UserServiceImpl implements UserService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(String name, String password, String introduce) {

        UserBean userBean = new UserBean();
        userBean.setUsername(name);
        userBean.setPassword(password);
        userBean.setRegisterDate(new Date());
        if (introduce == null) {
            userBean.setIntroduce("default introduce!");
        } else {
            userBean.setIntroduce(introduce);
        }
        userMapper.insertUser(userBean);

    }

    @Override
    public UserBean login(String name, String password) {
        return userMapper.getUserByNameAndPassword(name, password);
    }

    @Override
    public int updateUserInfo(UserBean userBean) {
        return userMapper.updateUser(userBean);
    }

    @Override
    public UserBean getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<UserBean> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
