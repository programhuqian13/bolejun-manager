package com.bolejun.manager.bolejunmanager.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 服务操作公共接口实现
 * Created by tony on 2018/7/6.
 */
@Slf4j
public class BaseServiceImpl<T,ID> implements BaseService<T,ID> {

    private  BaseDao<T,ID> baseDao;

    @Autowired
    public void setBaseDao(BaseDao<T,ID> baseDao){
        this.baseDao = baseDao;
    }

    /***
     * 添加数据
     * @param model 添加的数据
     */
    @Override
    public void insert(T model) {
        log.info("公共接口添加数据---");
        baseDao.insert(model);
    }

    /***
     * 通过编号删除数据
     * @param id 删除数据的编号
     */
    @Override
    public void deleteById(ID id) {
        log.info("公共接口通过编号删除数据---");
        baseDao.deleteById(id);
    }

    /***
     * 根据编号获得数据
     * @param id 获得数据的编号
     * @return
     */
    @Override
    public T findById(ID id) {
        log.info("公共接口根据编号获得数据----");
        return baseDao.findById(id);
    }

    /***
     * 修改相应的数据
     * @param model 修改的数据
     */
    @Override
    public void update(T model) {
        log.info("公共接口修改相应的数据----");
        baseDao.update(model);
    }

    /***
     * 查询所有的数据
     * @param model 查询条件
     * @return
     */
    @Override
    public List<T> selectByParam(T model) {
        log.info("公共接口查询所有的数据----");
        return baseDao.selectByParam(model);
    }

    @Override
    public long countByParam(T model) {
        return baseDao.countByParam(model);
    }
}
