package com.example.demo.dao;

import com.example.demo.pojo.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 *@author 王双江
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/19
 */
@Repository
public interface UserRepository extends JpaRepository<SysUser, Integer>{


    /**
     * 根据用户名密码查询用户信息
     * @param username
     * @param password
     * @return
     */
    @Query(value = "SELECT * FROM user WHERE user_name=? and password=?", nativeQuery = true)
    SysUser login(@Param("username")String  username, @Param("password")String password);

    /**
     * 根据传入的用户名查询用户信息
     * @param s
     * @return
     */
    @Query(value = "SELECT * FROM user WHERE user_name=?", nativeQuery = true)
    SysUser selectByName(String s);

}
