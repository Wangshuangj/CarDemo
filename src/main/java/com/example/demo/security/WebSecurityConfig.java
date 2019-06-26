//package com.example.demo.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
//
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)  //  启用方法级别的权限认证
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private MyUserDetailsService userDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());//passwoldEncoder是对密码的加密处理，如果user中密码没有加密，则可以不加此方法。注意加密请使用security自带的加密方式。
//    }
//
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                // 如果有允许匿名的url，填在下面
//                .antMatchers("/","/index","/getPage","/login","/queryCar","/querydetail").permitAll()
//                .antMatchers("/car/regist","/update").hasAnyRole("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                // 设置登陆页
//                .formLogin().loginPage("/")
//                // 设置登陆成功页
//                .defaultSuccessUrl("/index")
//                .failureUrl("/login/error")
//                .permitAll();
//
//        http.csrf().disable();
//
//
//    }
//
//    /**
//     * 静态资源忽略
//     */
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers( "/css/**","/js/**");
//    }
//}
