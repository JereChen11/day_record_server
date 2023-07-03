package com.day_record.server.serviceImpl;

import com.day_record.server.bean.UserBean;
import com.day_record.server.bean.UserTokenBean;
import com.day_record.server.config.exception.BizException;
import com.day_record.server.mapper.UserMapper;
import com.day_record.server.mapper.UserTokenMapper;
import com.day_record.server.service.UserService;
import com.day_record.server.utils.TokenTool;
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
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public void register(String name, String password, String introduce) {

        if (userMapper.selectUserByName(name) != null) {
            logger.info(name + " 已存在，请更换一个新昵称");
            throw new BizException(name + " 已存在，请更换一个新昵称");
        }

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
    public UserBean login(String username, String password) {
        logger.error("UserServiceImpl username = " + username + ", password = " + password);
        UserBean userBean = userMapper.selectUserByNameAndPassword(username, password);
        logger.error("the userBean by get = " + userBean);
        //接着去更新一下UserToken信息
        if (userBean != null) {
            String newToken = TokenTool.getNewToken(String.valueOf(System.currentTimeMillis()), userBean.getUserId());
            logger.info("newToken = " + newToken + ", newToken.length() = " + newToken.length());
            UserTokenBean userTokenBean = userTokenMapper.selectByUserId(userBean.getUserId());
            //当前时间
            Date updateTime = new Date();
            //过期时间 48 小时
            Date expireTime = new Date(updateTime.getTime() + 2 * 24 * 3600 * 1000);
            //如果表中查询的Token会null，就新创建一个。
            if (userTokenBean == null) {
                userTokenBean = new UserTokenBean();
                userTokenBean.setUserId(userBean.getUserId());
                userTokenBean.setToken(newToken);
                userTokenBean.setUpdateTime(updateTime);
                userTokenBean.setExpireTime(expireTime);
                //新增一条userToken数据
                logger.error("userTokenBean 不存在，插入 userTokenBean = " + userTokenBean.toString());
                userTokenMapper.insertUserToken(userTokenBean);
            } else {

                //否则更新Token、updateTime、expireTime信息
                userTokenBean.setToken(newToken);
                userTokenBean.setUpdateTime(updateTime);
                userTokenBean.setExpireTime(expireTime);
                //更新userTokenBean
                logger.error("userTokenBean 已经存在，更新 userTokenBean = " + userTokenBean.toString());
                userTokenMapper.updateByUserToken(userTokenBean);
            }
        }
        return userBean;
    }

    @Override
    public Boolean logout(Long userId) {
        return (userTokenMapper.deleteById(userId) > 0);
    }

    @Override
    public int updateUserInfo(UserBean userBean) {
        return userMapper.updateUser(userBean);
    }

    @Override
    public UserBean getUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public List<UserBean> getAllUsers() {
        return userMapper.selectAllUsers();
    }
}
