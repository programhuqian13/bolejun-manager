package com.bolejun.manager.bolejunmanager.utils;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 请求相应的结果
 * Created by tony on 2018/6/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResponseEntity {

    private static final String SUCCESS_MESSAGE = "操作成功！";
    private static final String ERROR_MESSAGE = "请求失败！";
    private static final String LOGIN_TOKEN_EXPIRES = "登陆失效！";
    public static final String VALIDATE_EXPIRE = "验证码已失效！";
    public static final String VALIDATE_CODE_NOT = "验证码不存在";

    private int code;

    private Boolean success;

    private String message;

    private Object data;

    public ResponseEntity(int code, String message){
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(Object data){
        ResponseEntity responseEntity = new ResponseEntity(200,ResponseEntity.SUCCESS_MESSAGE);
        responseEntity.setData(data);
        responseEntity.setSuccess(true);
    }

    public ResponseEntity(){

    }

    public static ResponseEntity isOk(){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(200);
        responseEntity.setSuccess(true);
        responseEntity.setMessage(SUCCESS_MESSAGE);
        return responseEntity;
    }

    public static ResponseEntity isOk(Object data){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode(200);
        responseEntity.setSuccess(true);
        responseEntity.setData(data);
        responseEntity.setMessage(SUCCESS_MESSAGE);
        return responseEntity;
    }

    public static ResponseEntity isError(){
        ResponseEntity responseEntity =  new ResponseEntity(500,ResponseEntity.ERROR_MESSAGE);
        responseEntity.setSuccess(false);
        return responseEntity;
    }

    public static ResponseEntity isError(String message){
        ResponseEntity responseEntity =  new ResponseEntity(500, message);
        responseEntity.setSuccess(false);
        return responseEntity;
    }

    public static ResponseEntity loginExprise(){
        ResponseEntity responseEntity =  new ResponseEntity(1001,ResponseEntity.LOGIN_TOKEN_EXPIRES);
        responseEntity.setSuccess(false);
        return responseEntity;
    }

}
