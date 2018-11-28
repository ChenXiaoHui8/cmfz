package com.baizhi.controller;

import com.baizhi.adminservice.AdminService;
import com.baizhi.entity.Admin;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class AdminController {

    @Autowired
    private AdminService as;

    @Autowired
    private Producer producer;

    @RequestMapping("/loginAdmin")
    public String loginAdmin(String name, String password, String Kaptcha, HttpSession session) {
        System.out.println(name + "---------" + password);
        String sessionKaptcha = (String) session.getAttribute("Kaptcha");
        if (sessionKaptcha.equalsIgnoreCase(Kaptcha)) {
            Admin admin = as.selectAdmin(name, password);
            if (admin != null) {
                session.setAttribute("admin", admin);

                return "redirect:/main/main.jsp";
            }
        }

        return "login";
    }

    @RequestMapping("/getKaptcha")
    public void getKaptcha(HttpSession session, HttpServletResponse response) throws IOException {

        String text = producer.createText();
        session.setAttribute("Kaptcha", text);
        BufferedImage image = producer.createImage(text);
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    @RequestMapping("/loginout")
    public String loginout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        session.removeAttribute("admin");
        return "login";

    }

}
