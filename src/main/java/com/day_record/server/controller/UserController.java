package com.day_record.server.controller;

import com.day_record.server.bean.BaseBean;
import com.day_record.server.bean.UserBean;
import com.day_record.server.common.SqlOperateResult;
import com.day_record.server.config.annotation.TokenToUser;
import com.day_record.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author JereChen
 */
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @PostMapping("/user/register")
    public BaseBean<String> register(@RequestParam("username") String username,
                                     @RequestParam("password") String password,
                                     String introduce) {
        logger.info("username: " + username + ", password: " + password + ", introduce = " + introduce);
        String resultMsg = "register success.";

        if (username.isBlank() || password.isBlank()) {
            resultMsg = "username and password can't empty.";
            return new BaseBean<>(403, resultMsg, "params error, please check params again.");
        }
        userService.register(username, password, introduce);

        return new BaseBean<>(resultMsg);
    }


    @PostMapping("/user/login")
    public BaseBean<UserBean> login(@RequestParam("username") String username,
                                    @RequestParam("password") String password) {
        logger.info("username = " + username + ", password = " + password);
        if (username.isBlank() || password.isBlank()) {
            return new BaseBean<>(403, null, "params error, please check params again.");
        }
        UserBean userBean = userService.login(username, password);
        return new BaseBean<>(userBean);
    }

    @PostMapping("/user/logout")
    public BaseBean<String> logout(@TokenToUser UserBean userBean) {
        String resultMsg = "logout success.";
        if (!userService.logout(userBean.getUserId())) {
            resultMsg = "logout failed.";
        }
        return new BaseBean<>(resultMsg);
    }

    @GetMapping("/user/get_all_users")
    public BaseBean<List<UserBean>> getAllUsers() {
        logger.debug("test debug log info, get_all_users");
        return new BaseBean<>(userService.getAllUsers());
    }

    @GetMapping("/user/get_user_by_id")
    public BaseBean<UserBean> getUserById(@RequestParam("userId") Long userId) {
        UserBean userBean = userService.getUserById(userId);
        return new BaseBean<>(userBean);
    }

    @PostMapping("/user/update_user_info")
    public BaseBean<String> updateUserInfo(String username,
                                           String password,
                                           String introduce,
                                           @TokenToUser UserBean userBean) {
        logger.info("username = " + username + ", password = " + password + ", introduce = " + introduce);
        logger.info("userBean = " + userBean.toString());

        //todo 疑惑？controller与Service的职责分配问题。一些业务逻辑，我是写在Controller中呢？还是写在Service中呢？
        UserBean originUserBean = userService.getUserById(userBean.getUserId());
        logger.info("the User found by userId is = " + originUserBean.toString());

        if (username != null && !username.isBlank()) {
            originUserBean.setUsername(username);
        }
        if (password != null && !password.isBlank()) {
            originUserBean.setPassword(password);
        }
        if (introduce != null && !introduce.isBlank()) {
            originUserBean.setIntroduce(introduce);
        }

        String resultMsg = "update successful!";
        int updateResultReturnBySql = userService.updateUserInfo(originUserBean);
        if (updateResultReturnBySql == SqlOperateResult.FAILED) {
            resultMsg = "update failed!";
        }
        logger.info("updateResultReturnBySql = " + updateResultReturnBySql);
        return new BaseBean<>(resultMsg);
    }


}
