package com.bolejun.manager.bolejunmanager.dao;

import com.bolejun.manager.bolejunmanager.base.BaseDao;
import com.bolejun.manager.bolejunmanager.entity.LessonInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tony on 2019/3/9.
 */
@Repository
@Mapper
public interface LessonInfoDao extends BaseDao<LessonInfo, Long> {

    List<LessonInfo> selectByStudentId(Long id);
}
