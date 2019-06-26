package com.example.demo.security;

import com.example.demo.pojo.Role;
import com.example.demo.pojo.SysUser;
import com.example.demo.pojo.UserRole;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SysUser user = userService.selectByName(username);

        System.out.println(user.toString());

        // 判断用户是否存在
        if(user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        // 添加权限
        List<UserRole> userRoles = userRoleService.listByUserId(user.getId());
        for (UserRole userRole : userRoles) {
            Role role = roleService.queryById(userRole.getRoleId());
            System.out.println(role.getName());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        // 返回UserDetails实现类
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

}
