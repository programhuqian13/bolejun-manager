package com.bolejun.manager.bolejunmanager.entity;

import com.bolejun.manager.bolejunmanager.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by tony on 2019/3/8.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfo extends BaseModel<Long>{

    private String username;

    private String password;

    private String realName;

    private String sex;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date brithDay;

}
