package com.example.demo.controller;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/27
 */

import com.example.demo.pojo.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/caroperate")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     *注册
     * @param car
     * @return success
     */
    @RequestMapping("/regist")
    @ResponseBody
    public String carRegist(Car car, HttpSession session){
        System.out.println(car.getHouseholdDate());
        System.out.println(car.getImgUrl());
        String numberplate = car.getNumberPlate();
        Car carList = carService.queryByPlate1(numberplate);//判断numberplate是否已存在
        if (null ==carList){
            car.setCreateTime(new Date());
            car.setCreator(""+session.getAttribute("username"));//从session中获取用户名
            carService.save(car);
            return "success";
        }else {
            return "fail";//若返回有数据，说明该插入的数据重复了
        }
    }

    /**
     * 数据编辑后的更新操作
     * @param car
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String updateCar(Car car, HttpSession session, HttpServletRequest request){
        String id =  request.getParameter("id");
        car.setCreateTime(new Date());
        car.setCreator(""+session.getAttribute("username"));
        car.setUpdator(""+session.getAttribute("username"));
        car.setUpdateTime(new Date());
        car.setId(Long.parseLong(id));
        carService.save(car);
        return "success";
    }

}
