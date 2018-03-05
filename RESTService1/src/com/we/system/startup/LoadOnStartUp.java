package com.we.system.startup;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class LoadOnStartUp extends HttpServlet
{
    private static com.web.system.monitor.MonitorHeartBeat heartBeatMonitor = null;
    
    private HttpServlet mServlet;

    public void init(ServletConfig servletConfig) throws ServletException
    {
    	System.out.println("In LoadOnStartUp.init()");
        super.init(servletConfig);
        mServlet.init(servletConfig);
        heartBeatMonitor = new com.web.system.monitor.MonitorHeartBeat();// we created Heart beat monitor thread here
    }

    public void destroy()
    {
        mServlet.destroy();
        heartBeatMonitor.destroy();// we are stopping the thread here.
    }
}
