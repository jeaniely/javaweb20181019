package com.neuedu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/servlettest1",loadOnStartup = 0)
public class ServletTest01 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("test1创建对象，并初始化。。。。。。");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      /*  System.out.println("test1 调用servlet中的方法 doGet或者doPost()");;*/
        ServletContext context=this.getServletConfig().getServletContext();
        System.out.println(context.getAttribute("character"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }

    @Override
    public void destroy() {
        System.out.println(" test1 销毁。。。。。。");
    }
}
