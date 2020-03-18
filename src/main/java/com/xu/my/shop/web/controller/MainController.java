package com.xu.my.shop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    /**
     * 跳转到首页
     * @param
     * @return java.lang.String
     * @author Xu
     * @date 2020/3/10 19:26
     */
    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }
}
