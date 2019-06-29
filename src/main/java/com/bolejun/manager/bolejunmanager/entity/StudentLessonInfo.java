package com.bolejun.manager.bolejunmanager.entity;

import com.bolejun.manager.bolejunmanager.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by tony on 2019/3/8.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StudentLessonInfo extends BaseModel<Long>{

    private Long lessonId;

    private Long studentId;

}
