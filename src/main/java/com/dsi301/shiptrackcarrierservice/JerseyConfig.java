package com.dsi301.shiptrackcarrierservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(WebService.class);
    }


//    public JerseyConfig() {
//        packages("com.example.rest");
//    }
//
//    @Bean
//    public ServletRegistrationBean<DispatcherServlet> jerseyServlet() {
//        ServletRegistrationBean<DispatcherServlet> servletRegistrationBean = new ServletRegistrationBean<>(new DispatcherServlet(), "/api/*");
//        servletRegistrationBean.setName("JerseyServlet");
//        return servletRegistrationBean;
//    }
}
