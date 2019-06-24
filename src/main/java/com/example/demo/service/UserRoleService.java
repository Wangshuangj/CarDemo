package com.example.demo.service;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/23
 */

import com.example.demo.dao.UserRoleRepository;
import com.example.demo.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;



    public List<UserRole> listByUserId(Long userId) {
        return userRoleRepository.listByUserId(userId);
    }
}
