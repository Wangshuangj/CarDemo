package com.example.demo.controller;
import com.example.demo.pojo.Car;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author 王双江
 * 邮箱：921017769@qq.com
 * 编码时间 ：2019/6/27
 */
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
        String numberplate = car.getNumberPlate();
        //判断numberplate是否已存在
        Car carList = carService.queryByPlate1(numberplate);
        if (null ==carList){
            car.setCreateTime(new Date());
            //从session中获取用户名
            car.setCreator(""+session.getAttribute("username"));
            carService.save(car);
            return "success";
        }else {
            //若返回有数据，说明该插入的数据重复了
            return "fail";
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
        Car car1 = carService.queryDetail(Long.parseLong(id));
        car.setCreator(car1.getCreator());
        car.setCreateTime(car1.getCreateTime());
        car.setCreateTime(new Date());
        car.setUpdator(""+session.getAttribute("username"));
        car.setUpdateTime(new Date());
        car.setId(Long.parseLong(id));
        carService.save(car);
        return "success";
    }

}
