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
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于分页逻辑
 */
@Controller
@RequestMapping("/car")
public class PageController {
    @Autowired
    private CarService carService;

    /**
     * 分页查询
     * @param req
     * @return
     */
    @RequestMapping(value="/getPage")
    @ResponseBody
    public Map<String,Object> getAllByBeginNumber(HttpServletRequest req){
        // 查看全部数据执行后端分页查询
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


    /**
     * 查询所有和根据车牌号查询数据
     * @param request
     * @return carList  数据的List集合
     */
    @RequestMapping("/queryCar")
    @ResponseBody
    public List<Car> carQueryAll(HttpServletRequest request){
        String numberplate = request.getParameter("numberplate").toString();
        List<Car> carList = new ArrayList<>();
        if(null != numberplate && !"".equals(numberplate)){
            System.out.println(numberplate);
            carList = carService.queryByPlate(numberplate);
        }
        else{
            carList = carService.queryAll();
        }
        return carList;
    }

    /**
     * 查询详情
     * @param id
     * @return
     */
    @RequestMapping("/querydetail")
    @ResponseBody
    public Car carEdit(Long id){
        Car car1 =  carService.queryDetail(id);
        return car1;
    }

}
