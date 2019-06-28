package com.example.demo.dao;

import com.example.demo.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 *@author 王双江
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/23
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    /**
     * 根据角色表的id查询角色信息
     * @param roleId
     * @return
     */
    @Query(value = "SELECT * FROM role WHERE id = ?" ,nativeQuery = true)
    Role queryById(Long roleId);
}
