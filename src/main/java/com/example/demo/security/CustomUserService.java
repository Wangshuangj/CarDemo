package com.example.demo.security;

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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    UserRepository userRepository;
    @Autowired
    PermissionRepository permissionDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.
                        getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();//创建session对象
        session.setAttribute("username",username);
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
