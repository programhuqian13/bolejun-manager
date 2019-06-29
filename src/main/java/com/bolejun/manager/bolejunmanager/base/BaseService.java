package com.bolejun.manager.bolejunmanager.base;

import java.util.List;

/**
 * 服务操作公共接口
 * Created by tony on 2018/7/6.
 */
public interface BaseService<T, ID> {

    /***
     * 添加数据
     * @param model 添加的数据
     */
    void insert(T model);

    /***
     * 通过编号删除数据
     * @param id 删除数据的编号
     */
    void deleteById(ID id);

    /***
     * 根据编号获得数据
     * @param id 获得数据的编号
     * @return
     */
    T findById(ID id);

    /***
     * 修改相应的数据
     * @param model 修改的数据
     */
    void update(T model);

    /***
     * 查询所有的数据
     * @param model 查询条件
     * @return
     */
    List<T> selectByParam(T model);

    long countByParam(T model);

}
