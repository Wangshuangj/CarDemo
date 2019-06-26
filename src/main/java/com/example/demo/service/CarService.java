package com.example.demo.service;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/20
 */

import com.example.demo.dao.CarRepository;
import com.example.demo.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;



    public List<Car> queryByPlate(String numberplate) {
        List<Car> list = carRepository.queryByPlate(numberplate);
        return list;
    }


    /**
     * 点击查询，在无条件时的查询
     * @return
     */
    public List<Car> queryAll() {
        List<Car> list = carRepository.queryAll();
        return list;
    }

    /**
     * 在注册和更新时进行Redis缓存操作
     * @param car
     * @return
     */
    @CachePut(value = "carcach",key = "#car.id")
    public Object save(Car car) {
        return carRepository.save(car);
    }

    /**
     * 查询详情
     * @param id
     * @return
     */
    @Cacheable(value = "carcach",key = "#id")
    public Car queryDetail(Long id) {
        return carRepository.queryDetail(id);
    }

    /**
     * 分页时，获取数据总条数
     * @return
     */
    public int getCount() {
        return carRepository.getCount();
    }

    /**
     * 分页时，获取从beginNumber条数据（每页的数据）
     * @param beginNumber
     * @param pageSize
     * @return
     */
    public List<Car> queryPageAll(int beginNumber, int pageSize) {
        List<Car> cars = carRepository.queryPageAll(beginNumber,pageSize);
        return cars;
    }

    /**
     * 注册时根据车牌号查询该条数据是否已存在
     * @param numberplate
     * @return
     */
    public Car queryByPlate1(String numberplate) {
        return carRepository.queryByPlate1(numberplate);
    }


}
