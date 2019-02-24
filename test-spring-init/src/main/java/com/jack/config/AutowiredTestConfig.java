package com.jack.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.jack.dao","com.jack.service"})
public class AutowiredTestConfig {
}
