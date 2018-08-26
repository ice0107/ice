package com.huawei.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *@author Ice
 *@date:2016年3月9日 上午9:28:07
 *
 */
public class WebFilter implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        String uri = req.getRequestURI().toLowerCase();

        //所有请求全部放行，请根据需求在此过滤
        // 之后的登陆请求页面拦截器放在这里
        System.out.println("no");
        System.out.println("---如有请求过滤器配置请在com.hitwh.manager.*.filter包中进行配置！配置文件在web.xml---");
        if(true){
            chain.doFilter(request, response);
            return;
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
