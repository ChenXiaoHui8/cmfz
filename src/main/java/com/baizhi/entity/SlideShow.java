package com.baizhi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SlideShow {

    private int id;
    private String title;
    private String imgPath;
    private String desc;
    private int status;
    private Date date;
}
