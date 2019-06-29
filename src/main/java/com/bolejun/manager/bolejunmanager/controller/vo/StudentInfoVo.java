package com.bolejun.manager.bolejunmanager.controller.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tony on 2019/6/29.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StudentInfoVo {

    private Long id;

    private String studentName;

    private Date schoolGotime;

    private String schoolGotimeStr;

    private String trainType;

    private String trainTime;

    private String parentName;

    private String tel;

    private String phone;

    private Double price;

    private String priceType;

    private String priceStatus;

    private String trainTimeStr;

    private Long classId;

    private String status;

    public String getSchoolGotimeStr(){
        if(this.schoolGotime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(this.schoolGotime);
        }
        return null;
    }

}
