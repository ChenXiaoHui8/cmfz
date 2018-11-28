package com.baizhi.controller;

import com.baizhi.service.MenuService;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    MenuService ms;

    @RequestMapping("/selectAllMenu")
    @ResponseBody
    public List<Menu> selectAllMenu() {

        return ms.selectAllMenu();


    }
}
