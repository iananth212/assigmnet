package com.sample.store.driversuggestionservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sample.store.driversuggestionservice.interceptor.DriverSuggestionServiceRequestInterceptor;


@Configuration
@ComponentScan(basePackages = {"com.walmart"})
public class DriverSuggestionConfig implements WebMvcConfigurer {
	
   
    @Autowired
    private DriverSuggestionServiceRequestInterceptor driverSuggestionServiceRequestInterceptor;


    /**
     * @param registry add InterceptorRegistry
     */
    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(driverSuggestionServiceRequestInterceptor);
    }
}
