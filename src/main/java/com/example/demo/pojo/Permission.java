package com.example.demo.pojo;
import javax.persistence.*;
/**
 *
 *@author 王双江
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/26
 */
@Entity
@Table(name = "Sys_permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "url",nullable = false)
    private String url;

    @Column(name = "pid",nullable = false)
    private Long pid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
