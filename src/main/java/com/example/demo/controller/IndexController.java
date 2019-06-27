package com.example.demo.controller;
/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/19
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/")
    public String goIndex(){
        return "login";
    }

    /**
     * 主页面
     * @return
     */
    @RequestMapping("/index")
    public String goIndex2(){
        return "index2";
    }
}
