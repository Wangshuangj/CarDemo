package com.example.demo.controller;/*
 *
 *用户 DELL
 *邮箱：921017769@qq.com
 * 编码时间 ：2019/6/24
 */


import com.example.demo.dao.CarRepository;
import com.example.demo.vo.SysResult;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class PicController {
    @Autowired
    private CarRepository carRepository;

    @RequestMapping(value = "/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        SysResult result = new SysResult();
        //保存图片到服务器
        String path = "C://Pic/idCards/";
        File filePath = new File(path);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        String fileNameA = "";
        if (file.isEmpty()) {
            return "fail";
        }
        //获取后缀
        String suf = file.getOriginalFilename()
                .substring(file.getOriginalFilename().indexOf(".") + 1);
        fileNameA = "upload" +  "." + suf;
        //将路径存入数据库
        String upload_path = path+fileNameA;
//        carRepository.savePath(upload_path);

        try {
            FileUtils.writeByteArrayToFile(new File(upload_path),
                    file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        return upload_path;
    }
}
