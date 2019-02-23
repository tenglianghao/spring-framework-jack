package com.jack.config;

import com.jack.annontation.EnabledJackTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//@Scope(value = "singleton")
@Configuration
@ComponentScan(basePackages = {"com.jack.postproecssor"})
//@EnabledJackTest
public class MainConfig {
}
