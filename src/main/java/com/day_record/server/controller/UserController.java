package com.day_record.server.controller;

import com.day_record.server.bean.BaseBean;
import com.day_record.server.bean.UserBean;
import com.day_record.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/user/get_user_by_id")
    public BaseBean<UserBean> login(@RequestParam("id") Long id) {
        UserBean userBean = userService.getUserById(id);
        return new BaseBean<>(userBean);
    }


}
