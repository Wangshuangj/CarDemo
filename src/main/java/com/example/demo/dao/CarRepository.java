package com.example.demo.dao;


import com.example.demo.pojo.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 *@author 王双江
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/19
 */
@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    /**
     * 查询所有车辆信息
     * @return
     */
    @Query(value = "SELECT * FROM car;", nativeQuery = true)
    List<Car> queryAll();

    /**
     * 根据车牌号查询车辆信息
     * @param numberplate
     * @return
     */
    @Query(value = "SELECT * FROM car WHERE number_plate LIKE %?1%",nativeQuery = true)
    List<Car> queryByPlate(String numberplate);

    /**
     * 根据id查询车辆信息
     * @param id
     * @return
     */
    @Query(value = "select * from car where id=?",nativeQuery = true)
    Car queryDetail(Long id);

    /**
     * 分页时查询总条数
     * @return
     */
    @Query(value = "select count(id) from car",nativeQuery = true)
    int getCount();

    /**
     * 分页查询
     * @param beginNumber
     * @param pageSize
     * @return
     */
    @Query(value = "select * from car limit ?,?",nativeQuery = true)
    List<Car> queryPageAll(@Param("beginNumber")int  beginNumber, @Param("pageSize")int pageSize);

    /**
     * 根据车牌号查询单个车辆信息（封装成一个Car对象）
     * @param numberplate
     * @return
     */
    @Query(value = "select * from car where number_plate=?",nativeQuery = true)
    Car queryByPlate1(String numberplate);

}
