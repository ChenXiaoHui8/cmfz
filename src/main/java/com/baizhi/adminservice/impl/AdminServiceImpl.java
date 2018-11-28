package com.baizhi.adminservice.impl;

import com.baizhi.adminservice.AdminService;
import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao ad;

    @Override
    public Admin selectAdmin(String name, String password) {

        return ad.selectAll(name, password);
    }
}
