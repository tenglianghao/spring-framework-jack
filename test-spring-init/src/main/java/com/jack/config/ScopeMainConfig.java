package com.jack.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.jack.service","com.jack.dao"})
public class ScopeMainConfig {


}
