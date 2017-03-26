package com.buct.xdq.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by acer on 2017/3/26.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Map<String, Object> map){
        map.put("name", "xx");
        return "/hello";
    }

}
