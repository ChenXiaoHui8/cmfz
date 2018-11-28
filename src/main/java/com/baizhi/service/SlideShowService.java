package com.baizhi.service;

import com.baizhi.entity.SlideShow;

import java.util.List;

public interface SlideShowService {
    public List<SlideShow> selectAll();

    public void insert(SlideShow slideShow);

    public void delete(int id);

    public void update(SlideShow slideShow);

}
