package com.example.demo.controller;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/21
 */

import com.example.demo.pojo.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于分页逻辑
 */
@Controller
public class PageController {
    @Autowired
    private CarService carService;

    @RequestMapping(value="/getPage")
    @ResponseBody
    public Map<String,Object> getAllByBeginNumber(HttpServletRequest req){
        // 查看全部数据执行后端分页查询
//        String numberplate = req.getParameter("numberplate");
//        if (numberplate==null||"".equals(numberplate)){
//
//        }
        int pageSize = Integer.parseInt(req.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(req.getParameter("pageNumber"));

        if (pageNumber <= 1){
            pageNumber = 1;
        }
        int beginNumber = (pageNumber - 1)* pageSize;
        List<Car> list = carService.queryPageAll(beginNumber,pageSize);
        int total = carService.getCount();
        Map<String,Object> responseMap = new HashMap<String,Object>();

        //key需要与js中 dataField对应，bootStrap默认值为rows
        responseMap.put("rows", list);

        // 需要返回到前台，用于计算分页导航栏
        responseMap.put("total", total);
        return responseMap;
    }
}
