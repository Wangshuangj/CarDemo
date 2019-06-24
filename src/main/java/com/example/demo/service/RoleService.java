package com.example.demo.service;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/23
 */

import com.example.demo.dao.RoleRepository;
import com.example.demo.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Role queryById(Long roleId) {
        return roleRepository.queryById(roleId);

    }
}
