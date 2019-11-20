package com.briup.smarthome.util;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.briup.environment.util.Log;

public class LogImpl implements Log {
	private Logger logger;
	private String path;

	public LogImpl() {
	}

	public LogImpl(Logger logger) {
		this.logger = logger;
	}

	@Override
	public void init(Properties properties) throws Exception {
		path = properties.getProperty("log-properties");
	}

	@Override
	public void debug(String message) {
		logger.debug(message);
	}

	@Override
	public void info(String message) {
		logger.info(message);
	}

	@Override
	public void warn(String message) {
		logger.warn(message);
	}

	@Override
	public void error(String message) {
		logger.error(message);
	}

	@Override
	public void fatal(String message) {
		logger.fatal(message);

	}

}
