package com.baizhi.adminservice;

import com.baizhi.entity.Admin;

public interface AdminService {

    public Admin selectAdmin(String name, String password);
}
