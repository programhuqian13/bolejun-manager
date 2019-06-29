package com.bolejun.manager.bolejunmanager.services;

import com.bolejun.manager.bolejunmanager.base.BaseService;
import com.bolejun.manager.bolejunmanager.entity.UserInfo;

/**
 * Created by tony on 2019/3/9.
 */
public interface UserInfoService extends BaseService<UserInfo, Long> {

    UserInfo selectByUsernameAndPassword(String username, String password);
}
