package com.bolejun.manager.bolejunmanager.base;

import com.bolejun.manager.bolejunmanager.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 公共controller
 * Created by tony on 2018/7/8.
 */
@Controller
public class BaseController {

    public UserInfo initRequest(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute("user");
        if(null == userInfo){
            return null;
        }
        return userInfo;
    }

}
