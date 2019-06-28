package com.example.demo.controller;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/27
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping
@RestController
public class TempController {

    @GetMapping("a")
    public Object a() {
        return "a";
    }

    @GetMapping("b")
    public Object b() {
        return "b";
    }

}
