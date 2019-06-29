package com.bolejun.manager.bolejunmanager.controller.vo;

import com.bolejun.manager.bolejunmanager.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by tony on 2019/4/14.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AddStudentModel extends BaseModel<Long> {

    private String studentName;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date schoolGotime;

    private String trainType;

    private String trainTime;

    private String parentName;

    private String motherName;

    private String tel;

    private String phone;

    private Double price;

    private String priceType;

    private String priceStatus;

    private Long classId;

    private Long lessonId;
}
