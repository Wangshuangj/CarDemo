package com.example.demo.dao;

import com.example.demo.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 *
 *@author 王双江
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/23
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    /**
     * 通过user_id查询用户和角色关联表（user_role）的信息
     * @param userId
     * @return
     */
    @Query(value = "SELECT * FROM user_role WHERE user_id = ?" ,nativeQuery = true)
    List<UserRole> listByUserId(Long userId);
}
