package com.bolejun.manager.bolejunmanager.entity;

import com.bolejun.manager.bolejunmanager.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tony on 2019/3/8.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class StudentInfo extends BaseModel<Long>{

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

    private String className;

    private String lessonName;

    public String getSchoolGotimeStr(){
        if(this.schoolGotime != null){
            return new SimpleDateFormat("yyyy-MM-dd").format(this.schoolGotime);
        }
        return null;
    }



}
