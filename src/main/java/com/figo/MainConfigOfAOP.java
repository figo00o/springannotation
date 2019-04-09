package com.figo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = "com.figo.aop")
@EnableAspectJAutoProxy
public class MainConfigOfAOP {
}
