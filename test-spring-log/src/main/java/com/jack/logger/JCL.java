package com.jack.logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * org.apache.commons.logging.Log:jck是一个日志门面类
 */
public class JCL {

	public static void main(String[] args) {
		Log cjl = LogFactory.getLog("cjl");
		cjl.info("jcl...");
	}
}
