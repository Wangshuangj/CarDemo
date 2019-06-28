package com.example.demo.service;

import com.example.demo.dao.RoleRepository;
import com.example.demo.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 *@author 王双江
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/23
 */
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Role queryById(Long roleId) {
        return roleRepository.queryById(roleId);

    }
}
