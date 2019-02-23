package com.jack.dao;

import com.jack.annontation.EnableMyDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Executor;

//@Configuration
public class DataSourceConfig implements ImportAware{

	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		Set<String> annotationTypes = importMetadata.getAnnotationTypes();
		Map<String, Object> annotationAttributes =
				importMetadata.getAnnotationAttributes(EnableMyDataSource.class.getName());


	}

}
