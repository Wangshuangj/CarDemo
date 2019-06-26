package com.example.demo.dto;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/26
 */


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 车辆信息的实体对象
 */
@Entity
@Table(name = "car")
public class Car1 implements Serializable{
    private static final long serialVersionUID = -8743385452161262446L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "number_plate",nullable = false)
    private String numberPlate;

    @Column(name = "car_owner",nullable = false)
    private String carOwner;

    @Column(name = "car_color",nullable = false)
    private int carColor;

    @Column(name = "engine_number",nullable = false)
    private String engineNumber;

    @Column(name = "label",nullable = false)
    private int label;

    @Column(name = "frame_number",nullable = false)
    private String frameNumber;

    @Column(name = "car_model",nullable = false)
    private String carModel;

    @Column(name = "household_date",nullable = false)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date householdDate;

    @Column(name = "car_type",nullable = false)
    private int carType;

    @Column(name = "first_registration_date",nullable = false)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date firstRegistrationDate;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "creator",nullable = false)
    private String creator;

    @Column(name = "updator")
    private String updator;

    @Column(name = "create_time",nullable = false)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @Column(name = "update_time")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;



}

