package com.day_record.server.controller;

import com.day_record.server.bean.BaseBean;
import com.day_record.server.bean.UserBean;
import com.day_record.server.common.SqlOperateResult;
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
        if (username.isBlank() || password.isBlank()) {
            return new BaseBean<>(403, null, "params error, please check params again.");
        }
        UserBean userBean = userService.login(username, password);
        return new BaseBean<>(userBean);
    }

    @GetMapping("/user/get_all_users")
    public BaseBean<List<UserBean>> getAllUsers() {
        logger.debug("test debug log info, get_all_users");
        return new BaseBean<>(userService.getAllUsers());
    }

    @GetMapping("/user/get_user_by_id")
    public BaseBean<UserBean> getUserById(@RequestParam("id") Long id) {
        UserBean userBean = userService.getUserById(id);
        return new BaseBean<>(userBean);
    }

    @PostMapping("/user/update_user_info")
    public BaseBean<String> updateUserInfo(@RequestParam("id") Long id,
                                           String username,
                                           String password,
                                           String introduce) {
        logger.info("id = " + id + ", username = " + username + ", password = " + password + ", introduce = " + introduce);

        //todo 疑惑？controller与Service的职责分配问题。一些业务逻辑，我是写在Controller中呢？还是写在Service中呢？
        UserBean userBean = userService.getUserById(id);
        logger.info("the User found by id is = " + userBean.toString());

        if (username != null && !username.isBlank()) {
            userBean.setUsername(username);
        }
        if (password != null && !password.isBlank()) {
            userBean.setPassword(password);
        }
        if (introduce != null && !introduce.isBlank()) {
            userBean.setIntroduce(introduce);
        }

        logger.info("after set new user info, the new UserInfo = " + userBean.toString());

        String resultMsg = "update successful!";
        int updateResultReturnBySql = userService.updateUserInfo(userBean);
        if (updateResultReturnBySql == SqlOperateResult.FAILED) {
            resultMsg = "update failed!";
        }
        logger.info("updateResultReturnBySql = " + updateResultReturnBySql);
        return new BaseBean<>(resultMsg);
    }


}
