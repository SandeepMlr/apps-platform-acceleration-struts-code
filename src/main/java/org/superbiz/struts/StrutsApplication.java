package org.superbiz.struts;

import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.Filter;
import java.util.Collections;

@SpringBootApplication
public class StrutsApplication {
    public static void main(String... args) {
        SpringApplication.run(StrutsApplication.class, args);
    }

    @Bean
    FilterRegistrationBean filterDispatcher() {
        return buildFilterRegistration(1, new FilterDispatcher());
    }

    @Bean
    FilterRegistrationBean actionContextCleanUp() {
        return buildFilterRegistration(1, new ActionContextCleanUp());
    }

    @Bean
    FilterRegistrationBean pageFilter() {
        return buildFilterRegistration(1, new PageFilter());
    }

    private FilterRegistrationBean buildFilterRegistration(int order, Filter filter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(filter);
        filterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        filterRegistrationBean.setOrder(order);
        return filterRegistrationBean;
    }
}
