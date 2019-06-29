package com.bolejun.manager.bolejunmanager.controller;

import com.alibaba.fastjson.JSON;
import com.bolejun.manager.bolejunmanager.base.BaseController;
import com.bolejun.manager.bolejunmanager.entity.UserInfo;
import com.bolejun.manager.bolejunmanager.services.UserInfoService;
import com.bolejun.manager.bolejunmanager.utils.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by tony on 2019/3/9.
 */
@Controller
@RequestMapping("/")
@Slf4j
public class IndexController extends BaseController{

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/")
    public String index(HttpServletRequest request,Model model){
        UserInfo userInfoLogin = initRequest(request);
        if(userInfoLogin == null){
            return "index";
        }
        model.addAttribute("user",userInfoLogin);
        return "home";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, UserInfo userInfo, ModelMap modelMap){
        log.info("------用户：{}正在登陆----", JSON.toJSONString(userInfo));
        if(StringUtils.isNotBlank(userInfo.getPassword())){
            userInfo.setPassword(MD5Util.crypt(userInfo.getPassword()));
        }
        UserInfo userInfoLogin = userInfoService.selectByUsernameAndPassword(userInfo.getUsername(),userInfo.getPassword());
        if(userInfoLogin == null){
            return "index";
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",userInfoLogin);

        modelMap.addAttribute("user",userInfoLogin);
        return "home";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, UserInfo userInfo, ModelMap modelMap){
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }
}
