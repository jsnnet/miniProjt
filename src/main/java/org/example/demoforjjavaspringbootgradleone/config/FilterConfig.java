package org.example.demoforjjavaspringbootgradleone.config;

import jakarta.servlet.Filter;
import org.example.demoforjjavaspringbootgradleone.flter.ModifyResponseFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<Filter> logFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        //bean.setFilter(new LogFilter());
        //bean.setOrder(1);
        //bean.addUrlPatterns("/*");

        /* 신규 필터 추가 */
        bean.setFilter(new ModifyResponseFilter());
        bean.setOrder(1);
        bean.addUrlPatterns("/*");

        return bean;
    }

}
