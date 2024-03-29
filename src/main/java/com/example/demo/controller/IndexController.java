package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *@author 王双江
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/19
 */


@Controller
public class IndexController {


    /**
     * 登录页面
     * @return
     */
    @GetMapping("/login")
    public String goIndex(){
        return "login";
    }

    /**
     * 主页面
     * @return
     */
    @RequestMapping("/")
    public String goIndex2(){
        return "index";
    }
}
