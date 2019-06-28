package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 *@author 王双江
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/19
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public SysUser login(String username, String password) {
        SysUser user = userRepository.login(username,password);
        return user;
    }

    public SysUser selectByName(String s) {
        SysUser user = userRepository.selectByName(s);
        return user;
    }
}
