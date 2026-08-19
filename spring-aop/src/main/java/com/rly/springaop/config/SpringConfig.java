package com.rly.springaop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.rly.springaop.annoaop")
@EnableAspectJAutoProxy
public class SpringConfig {
}
