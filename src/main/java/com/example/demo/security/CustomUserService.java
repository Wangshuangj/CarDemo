package com.example.demo.security;

//import com.example.demo.pojo.Role;
//import com.example.demo.pojo.SysUser;
//import com.example.demo.pojo.UserRole;
//import com.example.demo.service.RoleService;
//import com.example.demo.service.UserRoleService;
//import com.example.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//
//@Service
//public class CustomUserService implements UserDetailsService {
//
//    @Autowired
//    private RoleService roleService;
//    @Autowired
//    private UserRoleService userRoleService;
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        SysUser user = userService.selectByName(username);
//        System.out.println(user.toString());
//        // 判断用户是否存在
//        if(user == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        // 添加权限
//        List<UserRole> userRoles = userRoleService.listByUserId(user.getId());
//        for (UserRole userRole : userRoles) {
//            Role role = roleService.queryById(userRole.getRoleId());
//            System.out.println(role.getName());
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//
//        // 返回UserDetails实现类
//        return new User(user.getUsername(), user.getPassword(), authorities);
//    }
//
//}
import com.example.demo.dao.PermissionRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.pojo.Permission;
import com.example.demo.pojo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo on 17/1/18.
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserRepository userRepository;
    @Autowired
    PermissionRepository permissionDao;

    public UserDetails loadUserByUsername(String username) {
        SysUser user = userRepository.selectByName(username);
        if (user != null) {
            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName()!=null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}
