package com.example.demo.dao;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/23
 */

import com.example.demo.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Query(value = "SELECT * FROM user_role WHERE user_id = ?" ,nativeQuery = true)
    List<UserRole> listByUserId(Long userId);
}
