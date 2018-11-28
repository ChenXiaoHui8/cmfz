package com.baizhi;

import com.baizhi.dao.AdminDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {
    @Autowired
    private AdminDao adminDao;

    /*@Test
    public void contextLoads() {
        List<Admin> admins = adminDao.selectAll();
        for (Admin a : admins
        ) {
            System.out.println(a);
        }
    }*/

}
