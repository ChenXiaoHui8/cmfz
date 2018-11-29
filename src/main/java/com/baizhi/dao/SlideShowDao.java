package com.baizhi.dao;

import com.baizhi.entity.SlideShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlideShowDao {
    public List<SlideShow> selectAll(@Param("start") int start, @Param("rows") int rows);

    public void insert(SlideShow slideShow);

    public void delete(int id);

    public void update(SlideShow slideShow);

    public int getCount();

}
