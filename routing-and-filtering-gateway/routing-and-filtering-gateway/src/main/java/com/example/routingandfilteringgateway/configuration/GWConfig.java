package com.example.routingandfilteringgateway.configuration;

import com.example.routingandfilteringgateway.utils.SimpleFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GWConfig {
    @Bean
    public SimpleFilter simpleFilter() {
      return new SimpleFilter();
    }
}