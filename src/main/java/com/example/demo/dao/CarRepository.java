package com.example.demo.dao;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/19
 */

import com.example.demo.pojo.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query(value = "SELECT * FROM car;", nativeQuery = true)
    List<Car> queryAll();

    @Query(value = "select * from car where number_plate=?",nativeQuery = true)
    List<Car> queryByPlate(String numberplate);

    @Query(value = "select * from car where id=?",nativeQuery = true)
    Car queryDetail(Long id);

    @Query(value = "select count(id) from car",nativeQuery = true)
    int getCount();

    @Query(value = "select * from car limit ?,?",nativeQuery = true)
    List<Car> queryPageAll(@Param("beginNumber")int  beginNumber, @Param("pageSize")int pageSize);

    @Query(value = "select * from car where number_plate=?",nativeQuery = true)
    Car queryByPlate1(String numberplate);

//    @Query(value = "",nativeQuery = true)
//    void updateCar(Car car);
}
