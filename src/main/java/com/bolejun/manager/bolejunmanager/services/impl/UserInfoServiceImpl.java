package com.bolejun.manager.bolejunmanager.services.impl;

import com.bolejun.manager.bolejunmanager.base.BaseServiceImpl;
import com.bolejun.manager.bolejunmanager.dao.UserInfoDao;
import com.bolejun.manager.bolejunmanager.entity.UserInfo;
import com.bolejun.manager.bolejunmanager.services.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tony on 2019/3/9.
 */
@Service
@Slf4j
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, Long> implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo selectByUsernameAndPassword(String username, String password) {
        return userInfoDao.selectByUsernameAndPassword(username,password);
    }
}
