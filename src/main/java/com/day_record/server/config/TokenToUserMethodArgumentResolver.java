package com.day_record.server.config;

import com.day_record.server.bean.UserBean;
import com.day_record.server.bean.UserTokenBean;
import com.day_record.server.config.annotation.TokenToUser;
import com.day_record.server.config.exception.BizException;
import com.day_record.server.mapper.UserMapper;
import com.day_record.server.mapper.UserTokenMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @author JereChen
 */
@Component
public class TokenToUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    public final static int TOKEN_LENGTH = 32;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(TokenToUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        if (parameter.getParameterAnnotation(TokenToUser.class) instanceof TokenToUser) {
            UserBean userBean;
            //获取请求头中的Token
            String token = webRequest.getHeader("token");
            logger.info("token = " + token);
            if (token != null) {
                logger.info("token.length = " + token.length());
            }
            //验证Token值是否存在且有效
            if (null != token && !"".equals(token) && token.length() == TOKEN_LENGTH) {
                //通过Token来查询用户对象
                UserTokenBean userTokenBean = userTokenMapper.selectByToken(token);
                if (userTokenBean == null || userTokenBean.getExpireTime().getTime() <= System.currentTimeMillis()) {
//                    throw new RuntimeException("Token 无效");
                    throw new BizException("Token无效，请重新登入");
                }
                //查找真正的用户对象
                userBean = userMapper.selectUserById(userTokenBean.getUserId());
                if (userBean == null) {
                    throw new BizException("用户不存在，请重新登入");
                }
                //返回真正的用户对象
                return userBean;
            } else {
                throw new BizException("未登入");
            }
        }
        return null;
    }
}
