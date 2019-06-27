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

    @Query(value = "select p.*\n" +
            "        from user u\n" +
            "        LEFT JOIN role_user sru on u.id= sru.user_id\n" +
            "        LEFT JOIN role r on sru.role_id=r.id\n" +
            "        LEFT JOIN Sys_permission_role spr on spr.role_id=r.id\n" +
            "        LEFT JOIN Sys_permission p on p.id =spr.permission_id\n" +
            "        where u.id=#{userId}\n"
            ,nativeQuery = true)
    public List<Permission> findByAdminUserId(Long userId);
}
