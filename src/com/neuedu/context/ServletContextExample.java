package com.neuedu.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")
public class ServletContextExample  extends HttpServlet {
    /**
     *全局的参数，项目参数
     *  值作为的全局参数，那么在整个网站中，任何的页面（serlvet和jsp）都可以浏览和使用此参数，
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=this.getServletContext();
       context.setAttribute("character","utf-8");
       /* System.out.println(context.getInitParameter("character"));*/
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
