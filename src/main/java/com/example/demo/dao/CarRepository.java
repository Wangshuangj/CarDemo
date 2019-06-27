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

    //查询所有车辆信息
    @Query(value = "SELECT * FROM car;", nativeQuery = true)
    List<Car> queryAll();

    //根据车牌号查询车辆信息
    @Query(value = "SELECT * FROM car WHERE number_plate LIKE '%?%';",nativeQuery = true)
    List<Car> queryByPlate(String numberplate);

    //根据id查询车辆信息
    @Query(value = "select * from car where id=?",nativeQuery = true)
    Car queryDetail(Long id);

    //分页时查询总条数
    @Query(value = "select count(id) from car",nativeQuery = true)
    int getCount();

    //分页查询
    @Query(value = "select * from car limit ?,?",nativeQuery = true)
    List<Car> queryPageAll(@Param("beginNumber")int  beginNumber, @Param("pageSize")int pageSize);

    @Query(value = "select * from car where number_plate=?",nativeQuery = true)
    Car queryByPlate1(String numberplate);

}
