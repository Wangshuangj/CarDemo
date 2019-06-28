package com.example.demo.dao;


import com.example.demo.pojo.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 *@author 王双江
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/26
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    /**
     * 查询所有Sys_permission信息
     * @return
     */
    @Query(value = "SELECT * from Sys_permission ;",nativeQuery = true)
    @Override
    public List<Permission> findAll();

    /**
     * 使用左连接根据user表的id查询Sys_permission所有信息
     * @param userId
     * @return
     */
    @Query(value = "SELECT p.* FROM USER u LEFT JOIN user_role sru ON u.id= sru.user_id LEFT JOIN role r ON sru.role_id=r.id LEFT JOIN Sys_permission_role spr ON spr.role_id=r.id LEFT JOIN Sys_permission p ON p.id =spr.permission_id WHERE u.id=?;",nativeQuery = true)
    public List<Permission> findByAdminUserId(Long userId);
}
