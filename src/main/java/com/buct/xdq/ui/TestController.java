package com.buct.xdq.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by acer on 2017/3/26.
 */
@Controller
public class TestController {

    @RequestMapping("/say")
    public String say(){
        return "say";
    }

}