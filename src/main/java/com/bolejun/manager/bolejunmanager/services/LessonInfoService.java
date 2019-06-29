package com.bolejun.manager.bolejunmanager.services;

import com.bolejun.manager.bolejunmanager.base.BaseService;
import com.bolejun.manager.bolejunmanager.entity.LessonInfo;

import java.util.List;

/**
 * Created by tony on 2019/3/9.
 */
public interface LessonInfoService extends BaseService<LessonInfo, Long> {
    /**
     * 根据学生编号查询所报课程
     * @param id
     * @return
     */
    List<LessonInfo> selectByStudentId(Long id);
}
