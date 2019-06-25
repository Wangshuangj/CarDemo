package com.example.demo.controller;
/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/19
 */

import com.example.demo.pojo.Car;
import com.example.demo.pojo.SysUser;
import com.example.demo.service.CarService;
import com.example.demo.service.UserService;
import com.example.demo.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;


    /**
     * 登录页面
     * @return
     */
    @RequestMapping("/")
    public String goIndex(){
        return "login";
    }

    //在ajax进行转发时访问

    /**
     * 主页面
     * @return
     */
    @RequestMapping("/index")
    public String goIndex2(){
        return "index2";
    }


    /**
     * 登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public SysResult login(String username, String password, HttpSession session) {
        SysResult result = new SysResult();
        SysUser user = userService.login(username, password);
        if (null == user) {
            result.setStatus(0);
            result.setMsg("登录失败！！！");
            return result;
        } else {
            result.setStatus(1);
            result.setMsg("登录成功！！！");
            session.setAttribute("username",user.getUsername());
            return result;
        }
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
            carList = carService.queryByPlate(numberplate);
        }
        else{
            carList = carService.queryAll();
        }
        return carList;
    }

    /**
     *注册
     * @param car
     * @return success
     */
    @RequestMapping("/car/regist")
    @ResponseBody
    public String carRegist(Car car,HttpSession session){
//        List<Car> carList = new ArrayList<>();
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

    @RequestMapping("/querydetail")
    @ResponseBody
    public Car carEdit(Long id){
        Car car1 =  carService.queryDetail(id);
//        System.out.println(car1);
        return car1;
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
    public String updateCar(Car car,HttpSession session,HttpServletRequest request){
       String id =  request.getParameter("id");
        car.setCreateTime(new Date());
        car.setCreator(""+session.getAttribute("username"));
        car.setUpdator(""+session.getAttribute("username"));
        car.setUpdateTime(new Date());
        car.setId(Long.parseLong(id));
        carService.save(car);
        return "index2";
    }

}
