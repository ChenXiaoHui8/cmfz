package com.baizhi.controller;

import com.baizhi.entity.SlideShow;
import com.baizhi.service.SlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Controller
public class SlideShowController {

    @Autowired
    private SlideShowService slideShowService;

    @RequestMapping("/selectAll")
    public @ResponseBody
    Map selectAll(int page, int rows) {


        return slideShowService.selectAll(page, rows);
    }

    @RequestMapping("/delete")
    public @ResponseBody
    boolean delete(int id) {
        try {
            slideShowService.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @RequestMapping("/insert")
    public @ResponseBody
    boolean insert(SlideShow slideShow, MultipartFile uploadFile, HttpServletRequest request) {
        try {
            String fileName = uploadFile.getOriginalFilename();

            fileName = new Date().getTime() + "_" + fileName;
            String realPath = request.getRealPath("/img/");
            uploadFile.transferTo(new File(realPath + "\\" + fileName));
            slideShow.setImgPath(fileName);
            slideShowService.insert(slideShow);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("/update")
    public @ResponseBody
    boolean update(SlideShow slideShow) {
        System.out.println("aaaa");
        System.out.println(slideShow);
        try {
            slideShowService.update(slideShow);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}


