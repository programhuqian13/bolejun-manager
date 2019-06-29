package com.bolejun.manager.bolejunmanager.controller;

import com.bolejun.manager.bolejunmanager.base.BaseController;
import com.bolejun.manager.bolejunmanager.controller.vo.BaseQueryIndex;
import com.bolejun.manager.bolejunmanager.entity.UserInfo;
import com.bolejun.manager.bolejunmanager.services.UserInfoService;
import com.bolejun.manager.bolejunmanager.utils.MD5Util;
import com.bolejun.manager.bolejunmanager.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by tony on 2019/4/12.
 */
@Controller
@RequestMapping("/userInfo/")
@Slf4j
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("index")
    public String index(HttpServletRequest request,Model model){
        UserInfo userInfo = initRequest(request);
        if(userInfo == null){
            return "index";
        }
        model.addAttribute("user",userInfo);
        return "system/home";
    }

    //添加用户信息
    @RequestMapping("save")
    @ResponseBody
    public ResponseEntity save(HttpServletRequest request, UserInfo userInfo){
        UserInfo userInfo1 = initRequest(request);
        if(userInfo1 == null){
            return ResponseEntity.isError("用户已失效，请登录之后操作！");
        }
        try{
            if(userInfo.getId() == null){
                userInfo.setPassword(MD5Util.crypt(userInfo.getPassword()));
                userInfo.setCreateTime(new Date());
                userInfo.setCreateById(userInfo1.getId());
                userInfo.setUpdateById(userInfo1.getId());
                userInfo.setStatus("NOR");
                this.userInfoService.insert(userInfo);
            }else{
                userInfo.setPassword(MD5Util.crypt(userInfo.getPassword()));
                userInfo.setUpdateById(userInfo1.getId());
                userInfo.setUpdateTime(new Date());
                this.userInfoService.update(userInfo);
            }
            return ResponseEntity.isOk();
        }catch (Exception e){
            return ResponseEntity.isError("操作失败！");
        }
    }

    @RequestMapping("findAllUserInfo")
    @ResponseBody
    public BaseQueryIndex<UserInfo> findAllUserInfo(HttpServletRequest request,UserInfo userInfo){
        log.info("------开始查询用户列表----");
        List<UserInfo> res = this.userInfoService.selectByParam(userInfo);
        long total = this.userInfoService.countByParam(userInfo);
        BaseQueryIndex<UserInfo> baseQueryIndex = new BaseQueryIndex<>();
        baseQueryIndex.setRows(res);
        baseQueryIndex.setTotal(total);
        return baseQueryIndex;
    }

    @RequestMapping("findById")
    @ResponseBody
    public ResponseEntity findById(HttpServletRequest request,Long userId){
        log.info("------开始查询用户列表----");
        UserInfo res = this.userInfoService.findById(userId);
        return ResponseEntity.isOk(res);
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public ResponseEntity deleteById(HttpServletRequest request,Long id){
        log.info("------开始查询用户列表----");
        this.userInfoService.deleteById(id);
        return ResponseEntity.isOk();
    }


}
