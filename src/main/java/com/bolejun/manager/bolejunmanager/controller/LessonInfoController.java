package com.bolejun.manager.bolejunmanager.controller;

import com.alibaba.fastjson.JSON;
import com.bolejun.manager.bolejunmanager.base.BaseController;
import com.bolejun.manager.bolejunmanager.controller.vo.BaseQueryIndex;
import com.bolejun.manager.bolejunmanager.entity.ClassInfo;
import com.bolejun.manager.bolejunmanager.entity.LessonInfo;
import com.bolejun.manager.bolejunmanager.entity.UserInfo;
import com.bolejun.manager.bolejunmanager.services.LessonInfoService;
import com.bolejun.manager.bolejunmanager.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by tony on 2019/3/17.
 */
@Controller
@RequestMapping("/lessonInfo/")
@Slf4j
public class LessonInfoController extends BaseController{

    @Autowired
    private LessonInfoService lessonInfoService;

    @RequestMapping("index")
    public String index(HttpServletRequest request,Model model){
        UserInfo userInfo = initRequest(request);
        if(userInfo == null){
            return "index";
        }
        model.addAttribute("user",userInfo);
        return "lesson/home";
    }

    @RequestMapping("selectAllLesson")
    public @ResponseBody
    BaseQueryIndex<LessonInfo> selectAllLesson(HttpServletRequest request,LessonInfo lessonInfo){
        log.info("------开始查询班级列表----,dataLessonInfo:{}",lessonInfo);
        List<LessonInfo> res = this.lessonInfoService.selectByParam(lessonInfo);
        long total = this.lessonInfoService.countByParam(lessonInfo);
        BaseQueryIndex<LessonInfo> baseQueryIndex = new BaseQueryIndex<>();
        baseQueryIndex.setRows(res);
        baseQueryIndex.setTotal(total);
        return baseQueryIndex;
    }

    @RequestMapping(value = "addLesson",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addLesson(HttpServletRequest request, LessonInfo lessonInfo){
        UserInfo userInfo = initRequest(request);
        log.info("----添加班级信息-----,data:{}", JSON.toJSONString(lessonInfo));
        if(lessonInfo.getId() == null){
            lessonInfo.setCreateTime(new Date());
            lessonInfo.setCreateById(userInfo.getId());
            lessonInfo.setUpdateById(userInfo.getId());
            lessonInfoService.insert(lessonInfo);
        }else{
            lessonInfo.setUpdateTime(new Date());
            lessonInfo.setUpdateById(userInfo.getId());
            lessonInfoService.update(lessonInfo);
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
        LessonInfo lessonInfo = lessonInfoService.findById(id);
        return ResponseEntity.isOk(lessonInfo);
    }

}
