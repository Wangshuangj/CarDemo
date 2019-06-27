package com.example.demo.dao;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/19
 */


import com.example.demo.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<SysUser, Integer>{


//    @Query(value = "SELECT * FROM user WHERE user_name=?", nativeQuery = true)
//    public SysUser findName(@Param("name") String name);

    @Query(value = "SELECT * FROM user WHERE user_name=? and password=?", nativeQuery = true)
    SysUser login(@Param("username")String  username, @Param("password")String password);

    @Query(value = "SELECT * FROM user WHERE user_name=?", nativeQuery = true)
    SysUser selectByName(String s);

}
