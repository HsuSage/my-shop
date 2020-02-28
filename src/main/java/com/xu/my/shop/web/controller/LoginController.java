package com.xu.my.shop.web.controller;

import com.xu.my.shop.commons.context.SpringContext;
import com.xu.my.shop.entity.User;
import com.xu.my.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        SpringContext springContext = new SpringContext();
        UserService userService = (UserService) springContext.getBean("userService");
        User admin = userService.login(email, password);

        // 登录成功
        if (admin != null) {
            resp.sendRedirect("./main.jsp");
        }
        // 登录失败
        else {
            req.setAttribute("message", "用户名或密码错误");
            req.getRequestDispatcher("./index.jsp").forward(req, resp);
        }
    }
}
