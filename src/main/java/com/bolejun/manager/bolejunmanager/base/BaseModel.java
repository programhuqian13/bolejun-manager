package com.bolejun.manager.bolejunmanager.base;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tony on 2018/7/6.
 */
public class BaseModel<ID> implements Serializable{

    protected ID id;

    protected String status;

    protected Date createTime;

    protected Date updateTime;

    protected  String updateTimeStr;

    protected  String createTimeStr;

    public String getUpdateTimeStr() {
        if(this.updateTime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(this.updateTime);
        }
        return null;
    }

    public void setUpdateTimeStr(String updateTimeStr) {
        this.updateTimeStr = updateTimeStr;
    }

    public String getCreateTimeStr() {
        if(this.createTime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(this.createTime);
        }
        return null;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Long getUpdateById() {
        return updateById;
    }

    public void setUpdateById(Long updateById) {
        this.updateById = updateById;
    }

    public Long getCreateById() {
        return createById;
    }

    public void setCreateById(Long createById) {
        this.createById = createById;
    }

    protected Long updateById;

    protected Long createById;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
