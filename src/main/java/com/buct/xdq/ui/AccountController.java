package com.buct.xdq.ui;


import com.buct.xdq.account.beans.SysUser;
import com.buct.xdq.account.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


/**
 * Created by acer on 2017/3/26.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    private final SysUserService userService;

    @Autowired
    public AccountController(SysUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String submitLogin(String username, String password, Map<String, Object> map){
//        Subject subject = SecurityUtils.getSubject();
        SysUser user = new SysUser(username, password);
        userService.create(user);
        SysUser showUser = userService.findUser(username, password);
        System.out.println(showUser);
        map.put("user", showUser);
        return "home/index";
    }

}
