package com.baizhi.service;

import com.baizhi.entity.SlideShow;

import java.util.Map;

public interface SlideShowService {
    public Map selectAll(int page, int rows);

    public void insert(SlideShow slideShow);

    public void delete(int id);

    public void update(SlideShow slideShow);


}
