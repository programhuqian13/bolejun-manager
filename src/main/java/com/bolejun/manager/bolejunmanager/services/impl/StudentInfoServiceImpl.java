package com.bolejun.manager.bolejunmanager.services.impl;

import com.bolejun.manager.bolejunmanager.base.BaseServiceImpl;
import com.bolejun.manager.bolejunmanager.controller.vo.AddStudentModel;
import com.bolejun.manager.bolejunmanager.dao.StudentClassInfoDao;
import com.bolejun.manager.bolejunmanager.dao.StudentInfoDao;
import com.bolejun.manager.bolejunmanager.dao.StudentLessonInfoDao;
import com.bolejun.manager.bolejunmanager.entity.StudentClassInfo;
import com.bolejun.manager.bolejunmanager.entity.StudentInfo;
import com.bolejun.manager.bolejunmanager.entity.StudentLessonInfo;
import com.bolejun.manager.bolejunmanager.entity.UserInfo;
import com.bolejun.manager.bolejunmanager.services.StudentInfoService;
import com.bolejun.manager.bolejunmanager.utils.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by tony on 2019/3/9.
 */
@Service
@Slf4j
@Transactional
public class StudentInfoServiceImpl extends BaseServiceImpl<StudentInfo, Long> implements StudentInfoService {

    @Autowired
    private StudentInfoDao studentInfoDao;

    @Autowired
    private StudentLessonInfoDao studentLessonInfoDao;

    @Autowired
    private StudentClassInfoDao studentClassInfoDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(AddStudentModel addStudentModel, UserInfo userInfo) {
        StudentInfo studentInfo = BeanUtil.objConvert(addStudentModel,StudentInfo.class);
        studentInfo.setCreateById(userInfo.getId());
        studentInfo.setCreateTime(new Date());
        studentInfo.setUpdateTime(new Date());
        studentInfo.setUpdateById(userInfo.getId());
        studentInfoDao.insert(studentInfo);
        StudentClassInfo studentClassInfo = new StudentClassInfo();
        studentClassInfo.setClassId(addStudentModel.getClassId());
        studentClassInfo.setStudentId(studentInfo.getId());
        studentClassInfoDao.insert(studentClassInfo);
    }
}
