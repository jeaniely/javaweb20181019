package com.neuedu.character;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*@WebServlet("/chartest")*/
public class CharacterSetExample01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post-输入中文出现乱码
        //解决：在request中设置字符编码
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        System.out.println(username);

        //输出到html页面出乱码
        //解决:setContentType和setCharacterEncoding
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();
        out.print("<h1>"+username+"</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
