package com.example.demo.service;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/20
 */

import com.example.demo.dao.CarRepository;
import com.example.demo.pojo.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    @Cacheable(value = "carcach",key = "#numberplate")
    public List<Car> queryByPlate(String numberplate) {
        List<Car> list = carRepository.queryByPlate(numberplate);
        return list;
    }

    public List<Car> queryAll() {
        List<Car> list = carRepository.queryAll();
        return list;
    }

    public Object save(Car car) {
        return carRepository.save(car);
    }

    /**
     * 查询详情时，实现Redis的缓存，Redis的key为动态传入的id
     * @param id
     * @return
     */
    @Cacheable(value = "carcach",key = "#id")
    public Car queryDetail(Long id) {
        return carRepository.queryDetail(id);
    }

    public int getCount() {
        return carRepository.getCount();
    }

    public List<Car> queryPageAll(int beginNumber, int pageSize) {
        List<Car> cars = carRepository.queryPageAll(beginNumber,pageSize);
        return cars;
    }

    public Car queryByPlate1(String numberplate) {
        return carRepository.queryByPlate1(numberplate);
    }

//    public void updateCar(Car car) {
//        carRepository.updateCar(car);
//
//    }
}
