package com.day_record.server.mapper;

import com.day_record.server.bean.UserTokenBean;

/**
 * @author JereChen
 */
public interface UserTokenMapper {
    /**
     * 通过userId查询相对应的 UserToken信息
     *
     * @param userId
     * @return
     */
    UserTokenBean selectByUserId(Long userId);

    /**
     * 通过Token查询相对应的 UserToken信息
     *
     * @param token
     * @return
     */
    UserTokenBean selectByToken(String token);

    /**
     * 插入Token信息
     *
     * @param userTokenBean 带Token的用户对象
     * @return
     */
    int insertUserToken(UserTokenBean userTokenBean);

    /**
     * 更新UserToken
     *
     * @param userTokenBean
     * @return
     */
    int updateByUserToken(UserTokenBean userTokenBean);

    /**
     * 通过userId主键来删除
     *
     * @param userId 主键
     * @return
     */
    int deleteById(Long userId);
}
