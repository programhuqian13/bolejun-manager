package com.bolejun.manager.bolejunmanager.dao;

import com.bolejun.manager.bolejunmanager.base.BaseDao;
import com.bolejun.manager.bolejunmanager.entity.ClassInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by tony on 2019/3/9.
 */
@Repository
@Mapper
public interface ClassInfoDao extends BaseDao<ClassInfo, Long> {

}
