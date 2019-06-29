package com.bolejun.manager.bolejunmanager.dao;

import com.bolejun.manager.bolejunmanager.base.BaseDao;
import com.bolejun.manager.bolejunmanager.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by tony on 2019/3/9.
 */
@Repository
@Mapper
public interface UserInfoDao extends BaseDao<UserInfo, Long> {

    UserInfo selectByUsernameAndPassword(@Param(value = "username") String username,@Param(value = "password") String password);
}
