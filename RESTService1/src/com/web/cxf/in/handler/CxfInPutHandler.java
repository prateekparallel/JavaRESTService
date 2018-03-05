package com.web.cxf.in.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

/*
 * This handler class is just like a Filter
 */

public class CxfInPutHandler extends AbstractPhaseInterceptor<Message> {

	public CxfInPutHandler(){
		super(Phase.PRE_STREAM);
	}

	@Override
	public void handleMessage(final Message message) throws Fault {
		try {
			System.out.println("In in handleMessage() ");
			String user = "";//header param
			String pid = "";//header param
			String pathInfo = "";
			if (message.getExchange().getInMessage() != null) {
				if (message.getExchange().getInMessage().get(AbstractHTTPDestination.HTTP_REQUEST) != null) {
					HttpServletRequest req = (HttpServletRequest) message.getExchange().getInMessage().get(AbstractHTTPDestination.HTTP_REQUEST);
					user = req.getHeader("user");
					pid = req.getHeader("pid");
					pathInfo = req.getPathInfo();
				}
			} else {
				System.out.println("Fail to get the http request ");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
