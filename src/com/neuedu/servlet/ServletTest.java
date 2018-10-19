package com.neuedu.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="test1",
        value = {"/servlettest","/test"},
        loadOnStartup = 1,
        initParams={@WebInitParam(name="url",value="jdbc:mysql://127.0.0.1:3306/pms")})
public class ServletTest extends HttpServlet {
    ServletConfig config;
    @Override
    public void init() throws ServletException {

        System.out.println("test 创建对象，并初始化。。。。。。");
    }
   /* public void init(ServletConfig config) throws ServletException {
        this.config=config;
        System.out.println("test 创建对象，并初始化。。。。。。");
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("test 调用servlet中的方法 doGet或者doPost()");
        config=this.getServletConfig();
        System.out.println(config.getInitParameter("url"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println(" test 销毁。。。。。。");
    }
}
