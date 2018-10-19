package com.neuedu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1:过滤所有页面“/*”
 * 2:过滤jsp:*.jsp
 */
@WebFilter("/*")
public class CharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init.....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
          ServletContext context= request.getServletContext();
          String charset=context.getInitParameter("charset");
        request.setCharacterEncoding(charset);
        response.setContentType("text/html;charset="+charset);
        response.setCharacterEncoding(charset);


        filterChain.doFilter(servletRequest,servletResponse);//放行

    }

    @Override
    public void destroy() {
        System.out.println("destroy......");
    }
}
