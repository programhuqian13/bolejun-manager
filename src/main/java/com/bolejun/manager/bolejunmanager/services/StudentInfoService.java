package com.bolejun.manager.bolejunmanager.services;

import com.bolejun.manager.bolejunmanager.base.BaseService;
import com.bolejun.manager.bolejunmanager.controller.vo.AddStudentModel;
import com.bolejun.manager.bolejunmanager.entity.StudentInfo;
import com.bolejun.manager.bolejunmanager.entity.UserInfo;

/**
 * Created by tony on 2019/3/9.
 */
public interface StudentInfoService extends BaseService<StudentInfo, Long> {

    void insert(AddStudentModel addStudentModel, UserInfo userInfo);
}
