package com.buct.xdq.ui;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by acer on 2017/3/26.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String submitLogin(String username, String password){
//        Subject subject = SecurityUtils.getSubject();
        return "home/index";
    }

}
