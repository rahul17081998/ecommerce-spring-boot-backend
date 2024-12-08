package com.luv2code.ecommerce.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;



@WebFilter("/*") // Applies to all requests
public class GlobalRequestLoggingFilter  implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(GlobalRequestLoggingFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String httpMethod = httpRequest.getMethod();
        String requestUri = httpRequest.getRequestURI();

        logger.info("HttpMethod: {} :: Path: {}", httpMethod, requestUri);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
