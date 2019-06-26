package com.example.demo.pojo;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/19
 */


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 车辆信息的实体对象
 */
@Entity
@Table(name = "car")
public class Car implements Serializable{
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public int getCarColor() {
        return carColor;
    }

    public void setCarColor(int carColor) {
        this.carColor = carColor;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public String getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(String frameNumber) {
        this.frameNumber = frameNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Date getHouseholdDate() {
        return householdDate;
    }

    public void setHouseholdDate(Date householdDate) {
        this.householdDate = householdDate;
    }

    public int getCarType() {
        return carType;
    }

    public void setCarType(int carType) {
        this.carType = carType;
    }

    public Date getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(Date firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", numberPlate='" + numberPlate + '\'' +
                ", carOwner='" + carOwner + '\'' +
                ", carColor=" + carColor +
                ", engineNumber='" + engineNumber + '\'' +
                ", label=" + label +
                ", frameNumber='" + frameNumber + '\'' +
                ", carModel='" + carModel + '\'' +
                ", householdDate=" + householdDate +
                ", carType=" + carType +
                ", firstRegistrationDate=" + firstRegistrationDate +
                ", imgUrl='" + imgUrl + '\'' +
                ", creator='" + creator + '\'' +
                ", updator='" + updator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
