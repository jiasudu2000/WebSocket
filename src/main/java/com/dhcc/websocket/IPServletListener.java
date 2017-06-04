package com.dhcc.websocket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * 用来监听ServletRequest事件，发生在创建WebSocket的session之前
 * @author Alexander
 *
 */

@WebListener
public class IPServletListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest request=(HttpServletRequest) sre.getServletRequest();
        HttpSession session=request.getSession();
        
        System.out.println("******"+sre.getServletRequest().getRemoteAddr());
        
        //把HttpServletRequest中的IP地址放入HttpSession中，关键字可任取，此处为ClientIP
        session.setAttribute("ClientIP", sre.getServletRequest().getRemoteAddr());
        System.out.println("time 1");
    
    }

}
