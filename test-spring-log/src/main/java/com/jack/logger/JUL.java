package com.jack.logger;

import java.util.logging.Logger;

/**
 * jul 是jdk提供的日志记录的一个实现类
 */
public class JUL {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("JUL");
		logger.info("jul...");
	}
}
