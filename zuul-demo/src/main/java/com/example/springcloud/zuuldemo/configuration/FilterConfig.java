package com.example.springcloud.zuuldemo.configuration;

import com.example.springcloud.zuuldemo.filter.IPFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author lixiaofeng
 * @date 2019/11/21
 */
@Configuration
public class FilterConfig {
    @Bean
    public IPFilter ipFilter(){
        return new IPFilter();
    }
}
