package com.jack.config;

import com.jack.annontation.EnableMyDataSource;
import com.jack.dao.DataSourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@EnableMyDataSource(username = "root", password = "root", ip = "", port = 3308)
@Import(DataSourceConfig.class)
public class AutoAwareMainConfig {

}
