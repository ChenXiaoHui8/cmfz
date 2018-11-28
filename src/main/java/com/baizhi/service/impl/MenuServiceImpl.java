package com.baizhi.service.impl;

import com.baizhi.service.MenuService;
import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao md;

    @Override
    public List<Menu> selectAllMenu() {

        System.out.println(md.selectAllMenu());
        return md.selectAllMenu();
    }
}
