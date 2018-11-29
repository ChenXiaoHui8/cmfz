package com.baizhi.service.impl;

import com.baizhi.dao.SlideShowDao;
import com.baizhi.entity.SlideShow;
import com.baizhi.service.SlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class SlideShowServiceimpl implements SlideShowService {


    @Autowired
    private SlideShowDao sd;

    @Override
    public Map selectAll(int page, int rows) {

        int start = (page - 1) * rows;
        int count = sd.getCount();
        List<SlideShow> list = sd.selectAll(start, rows);
        Map map = new HashMap();
        map.put("page", count);
        map.put("rows", list);


        return map;

    }

    @Override
    public void insert(SlideShow slideShow) {
        System.out.println("impl" + slideShow);
        sd.insert(slideShow);
    }

    @Override
    public void delete(int id) {
        sd.delete(id);

    }

    @Override
    public void update(SlideShow slideShow) {
        sd.update(slideShow);
    }
}
