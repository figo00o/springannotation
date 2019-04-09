package com.figo;

import com.figo.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(value = "com.figo.controller", excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = {Service.class})})
public class MainConfig {
    @Bean
    public Student student(){
        return new Student("zs",25);
    }
}
