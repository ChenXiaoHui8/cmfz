package com.baizhi.dao;

import com.baizhi.entity.SlideShow;

import java.util.List;

public interface SlideShowDao {
    public List<SlideShow> selectAll();

    public void insert(SlideShow slideShow);

    public void delete(int id);

    public void update(SlideShow slideShow);

}
