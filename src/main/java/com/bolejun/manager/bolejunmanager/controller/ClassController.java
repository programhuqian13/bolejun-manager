package com.bolejun.manager.bolejunmanager.controller;

import com.alibaba.fastjson.JSON;
import com.bolejun.manager.bolejunmanager.base.BaseController;
import com.bolejun.manager.bolejunmanager.controller.vo.BaseQueryIndex;
import com.bolejun.manager.bolejunmanager.entity.ClassInfo;
import com.bolejun.manager.bolejunmanager.entity.UserInfo;
import com.bolejun.manager.bolejunmanager.services.ClassInfoService;
import com.bolejun.manager.bolejunmanager.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


/**
 * Created by tony on 2019/3/17.
 */
@Controller
@Slf4j
@RequestMapping("/classInfo/")
public class ClassController extends BaseController{

    @Autowired
    private ClassInfoService classInfoService;

    @RequestMapping("selectAllClass")
    public @ResponseBody BaseQueryIndex<ClassInfo> selectAllClass(HttpServletRequest request,ClassInfo classInfo){
        log.info("------开始查询班级列表----，dataClassInfo:{}",classInfo);
        List<ClassInfo> res = this.classInfoService.selectByParam(classInfo);
        long total = this.classInfoService.countByParam(classInfo);
        BaseQueryIndex<ClassInfo> baseQueryIndex = new BaseQueryIndex<>();
        baseQueryIndex.setRows(res);
        baseQueryIndex.setTotal(total);
        return baseQueryIndex;
    }

    @RequestMapping(value = "addClassInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addClassInfo(HttpServletRequest request,ClassInfo classInfo){
        UserInfo userInfo = initRequest(request);
        log.info("----添加班级信息-----,data:{}", JSON.toJSONString(classInfo));
        if(classInfo.getId() == null){
            classInfo.setCreateTime(new Date());
            classInfo.setCreateById(userInfo.getId());
            classInfo.setUpdateById(userInfo.getId());
            classInfoService.insert(classInfo);
        }else{
            classInfo.setUpdateTime(new Date());
            classInfo.setUpdateById(userInfo.getId());
            classInfoService.update(classInfo);
        }
        return ResponseEntity.isOk();
    }

    @RequestMapping("deleteClassInfo")
    @ResponseBody
    public ResponseEntity deleteClassInfo(){
        return null;
    }

    @RequestMapping("findById")
    @ResponseBody
    public ResponseEntity findById(Long id){
        ClassInfo classInfo = classInfoService.findById(id);
        return ResponseEntity.isOk(classInfo);
    }

}
