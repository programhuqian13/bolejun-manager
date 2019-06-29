package com.bolejun.manager.bolejunmanager.controller;

import com.alibaba.fastjson.JSON;
import com.bolejun.manager.bolejunmanager.base.BaseController;
import com.bolejun.manager.bolejunmanager.controller.vo.AddStudentModel;
import com.bolejun.manager.bolejunmanager.controller.vo.BaseQueryIndex;
import com.bolejun.manager.bolejunmanager.controller.vo.StudentInfoVo;
import com.bolejun.manager.bolejunmanager.entity.*;
import com.bolejun.manager.bolejunmanager.services.ClassInfoService;
import com.bolejun.manager.bolejunmanager.services.LessonInfoService;
import com.bolejun.manager.bolejunmanager.services.StudentInfoService;
import com.bolejun.manager.bolejunmanager.services.StudentLessonInfoService;
import com.bolejun.manager.bolejunmanager.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by tony on 2019/3/17.
 */
@Controller
@RequestMapping("/studentInfo/")
@Slf4j
public class StudentInfoController extends BaseController{

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private ClassInfoService classInfoService;

    @Autowired
    private LessonInfoService lessonInfoService;

    @Autowired
    private StudentLessonInfoService studentLessonInfoService;

    @RequestMapping("index")
    public String index(HttpServletRequest request, Model model){
        UserInfo userInfo = initRequest(request);
        if(userInfo == null){
            return "index";
        }
        ClassInfo classInfo = new ClassInfo();
        classInfo.setStatus("NOR");
        LessonInfo lessonInfo = new LessonInfo();
        lessonInfo.setStatus("NOR");
        List<ClassInfo> classInfos = classInfoService.selectByParam(classInfo);
        List<LessonInfo> lessonInfos = lessonInfoService.selectByParam(lessonInfo);
        model.addAttribute("classInfos",classInfos);
        model.addAttribute("user",userInfo);
        return "student/home";
    }

    @RequestMapping("selectAllStudent")
    public @ResponseBody
    BaseQueryIndex<StudentInfo> selectAllClass(HttpServletRequest request,StudentInfo studentInfo){
        log.info("------开始查询班级列表----");
        List<StudentInfo> res = this.studentInfoService.selectByParam(studentInfo);
        if(res == null){
            res = new ArrayList<>();
        }
        //根据学生查询班级信息
        if(!CollectionUtils.isEmpty(res)){
            res.stream().forEach(studentInfo1 -> {
                List<String>  list = new ArrayList<>();
                List<LessonInfo> lessonInfos = lessonInfoService.selectByStudentId(studentInfo1.getId());
                if(!CollectionUtils.isEmpty(lessonInfos)){
                    lessonInfos.stream().forEach(lessonInfo -> {
                        if(lessonInfo != null){
                            list.add(lessonInfo.getLessonName());
                        }
                    });
                }
                studentInfo1.setLessonName(String.join(",",list));
            });
        }
        long total = this.studentInfoService.countByParam(studentInfo);
        BaseQueryIndex<StudentInfo> baseQueryIndex = new BaseQueryIndex<>();
        baseQueryIndex.setRows(res);
        baseQueryIndex.setTotal(total);
        return baseQueryIndex;
    }


    @RequestMapping("addStudentInfo")
    @ResponseBody
    public ResponseEntity addClassInfo(AddStudentModel addStudentModel,HttpServletRequest request){
        UserInfo userInfo = initRequest(request);
        if(userInfo ==null){
            return ResponseEntity.isError("登录已失效！");
        }
        if(addStudentModel.getId() != null){
            this.studentInfoService.edit(addStudentModel,userInfo);
        }else{
            this.studentInfoService.insert(addStudentModel,userInfo);
        }
        return ResponseEntity.isOk();
    }

    @RequestMapping("deleteStudentInfo")
    @ResponseBody
    public ResponseEntity deleteClassInfo(){
        return null;
    }

    @RequestMapping("updateStudentInfo")
    @ResponseBody
    public ResponseEntity updateClassInfo(){
        return null;
    }

    @RequestMapping("linkLesson")
    @ResponseBody
    public ResponseEntity linkLesson(HttpServletRequest request,Long stuId,String lessonIds){
        UserInfo userInfo = initRequest(request);
        if(userInfo == null){
            return ResponseEntity.isError("请重新登陆！");
        }
        log.info("------学生关联课程-----，stuId：{},lessonIds:{}",stuId,lessonIds);
        if (!StringUtils.isEmpty(lessonIds)) {
            String [] ids = lessonIds.split(",");
            for(int i = 0; i < ids.length ;i++){
                StudentLessonInfo studentLessonInfo = new StudentLessonInfo();
                studentLessonInfo.setStudentId(stuId);
                studentLessonInfo.setLessonId(Long.valueOf(ids[i]));
                studentLessonInfoService.insert(studentLessonInfo);
            }
        }
        return ResponseEntity.isOk();
    }

    @RequestMapping("findById")
    @ResponseBody
    public ResponseEntity findById(HttpServletRequest request,Long id){
        UserInfo userInfo = initRequest(request);
        if(userInfo == null){
            return ResponseEntity.isError("请重新登陆！");
        }
        log.info("------根据编号查询学生信息-----，id：{}",id);
        StudentInfoVo studentInfoVo = studentInfoService.findByIdClass(id);
        log.info("--------查询出来的结果，studentVo:{}", JSON.toJSONString(studentInfoVo));
        return ResponseEntity.isOk(studentInfoVo);
    }

}
