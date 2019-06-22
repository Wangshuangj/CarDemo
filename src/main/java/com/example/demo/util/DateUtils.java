package com.example.demo.util;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/19
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public Date getDate(String date1) {
//        String date1 = car.getFirstRegistrationDate().toString();
        Date time = new Date(date1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String timeFormat = sdf.format(time);
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format1.parse(timeFormat);
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    }

