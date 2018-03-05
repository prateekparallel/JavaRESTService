package com.web.cxf.out.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

public class CxfOutPutHandler extends AbstractPhaseInterceptor<Message> {
	
	 public CxfOutPutHandler() {
	        super(Phase.PRE_STREAM);
	    }

	    @Override
	    public void handleMessage(final Message message) throws Fault {

	        System.out.println("In out handleMessage() ");
	        if (message.getExchange().getInMessage() != null) {
	            if (message.getExchange().getInMessage().get(AbstractHTTPDestination.HTTP_REQUEST) != null) {
	                HttpServletRequest req = (HttpServletRequest) message.getExchange().getInMessage().get(AbstractHTTPDestination.HTTP_REQUEST);
	                //origin = req.getHeader("Origin");
	            }
	        } else {
	            System.out.println("Fail to get the http request ");
	        }

     }
	    
}

