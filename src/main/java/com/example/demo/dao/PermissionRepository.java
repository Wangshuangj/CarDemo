package com.example.demo.dao;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/26
 */

import com.example.demo.pojo.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    @Query(value = "SELECT * from Sys_permission ;",nativeQuery = true)
    public List<Permission> findAll();

    @Query(value = "SELECT p.* FROM USER u LEFT JOIN user_role sru ON u.id= sru.user_id LEFT JOIN role r ON sru.role_id=r.id LEFT JOIN Sys_permission_role spr ON spr.role_id=r.id LEFT JOIN Sys_permission p ON p.id =spr.permission_id WHERE u.id=2;",nativeQuery = true)
    public List<Permission> findByAdminUserId(Long userId);
}
