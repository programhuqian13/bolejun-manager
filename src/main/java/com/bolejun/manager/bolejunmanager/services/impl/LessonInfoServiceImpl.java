package com.bolejun.manager.bolejunmanager.services.impl;

import com.bolejun.manager.bolejunmanager.base.BaseServiceImpl;
import com.bolejun.manager.bolejunmanager.dao.LessonInfoDao;
import com.bolejun.manager.bolejunmanager.entity.LessonInfo;
import com.bolejun.manager.bolejunmanager.services.LessonInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tony on 2019/3/9.
 */
@Service
@Slf4j
public class LessonInfoServiceImpl extends BaseServiceImpl<LessonInfo, Long> implements LessonInfoService {

    @Autowired
    private LessonInfoDao lessonInfoDao;

    @Override
    public List<LessonInfo> selectByStudentId(Long id) {
        return lessonInfoDao.selectByStudentId(id);
    }
}
