package com.example.demo.controller;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/27
 */

import com.example.demo.pojo.Car;
import com.example.demo.pojo.SysUser;
import com.example.demo.security.CustomUserService;
import com.example.demo.service.CarService;
import com.example.demo.service.UserService;
import com.example.demo.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
//@RequestMapping("/car")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomUserService customUserService;

    /**
     * 登录
     * @param username
     * @param password
     * @param session
     * @return
     */
//    @PostMapping("/userlogin")
//    @ResponseBody
//    public String login(String username, String password, HttpSession session) {
//        customUserService.loadUserByUsername(username);
//        return "index2";
//    }


}
