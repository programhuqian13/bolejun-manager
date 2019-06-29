package com.bolejun.manager.bolejunmanager.entity;

import com.bolejun.manager.bolejunmanager.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by tony on 2019/3/8.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ClassInfo extends BaseModel<Long>{

    private String className;

    private String classCode;

}
