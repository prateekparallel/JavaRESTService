package com.web.filter;

/*
 * A filter is typically used to perform a particular piece of functionality 
either before or after the primary functionality of a web application is 
performed. As an example, if a request is made for a particular resource such 
as a servlet and a filter is used, the filter code may execute and then pass 
the user on to the servlet. As a further example, the filter might determine 
that the user does not have permissions to access a particular servlet, and it might 
send the user to an error page rather than to the requested resource.
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


public class UserFilter implements Filter{
	
    @Override
    public void destroy() {

    }
/*
 * Here I am just setting a header field before control goes to the servlet. 
 * We can also authenticate a user here before re-directing to a servlet
 */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
       System.out.println("Im in UserFilter"); 
    	HttpServletRequest req = (HttpServletRequest) request;
        HeaderRequestWrapper requestWrapper = new HeaderRequestWrapper(req);
        requestWrapper.addHeader("user", "Test1234");
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public class HeaderRequestWrapper extends HttpServletRequestWrapper {
        
        public HeaderRequestWrapper(HttpServletRequest request) {
            super(request);
        }

        private Map<String, String> headerMap = new HashMap<String, String>();

        public void addHeader(String name, String value) {
            headerMap.put(name, value);
        }

        @Override
        public String getHeader(String name) {
            String headerValue = super.getHeader(name);
            if (headerMap.containsKey(name)) {
                headerValue = headerMap.get(name);
            }
            return headerValue;
        }       

    }

}

