package com.sample.store.driversuggestionservice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * The type request interceptor.
 */
@Component
public class DriverSuggestionServiceRequestInterceptor extends HandlerInterceptorAdapter {

    /**
     * Logger Instantiated.
     */
    private final Logger logger
            = LoggerFactory.getLogger(DriverSuggestionServiceRequestInterceptor.class);

    private static final String START = "start";
    /**
     * @param request  HttpServletRequest request
     * @param response HttpServletResponse response
     * @param handler  Object handler
     * @return boolean boolean result tell preHandle
     */
    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object handler) {
        request.setAttribute(START, System.currentTimeMillis());
           return true;
    }

    /**
     * @param request      HttpServletRequest request
     * @param response     HttpServletResponse respons
     * @param handler      Object handler
     * @param modelAndView rendering ModelAndView
     * @throws Exception ** Exception **
     */
    @Override
    public void postHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler,
                           final ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    	if(request.getAttribute(START) != null)
        logger.info("[ {} ] [rt] : {} ms" ,request.getRequestURI(), (System.currentTimeMillis() - (long)request.getAttribute(START)) );

    }
}
