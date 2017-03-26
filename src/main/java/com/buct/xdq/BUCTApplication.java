package com.buct.xdq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BUCTApplication {
	private static final Logger log = LoggerFactory.getLogger(BUCTApplication.class);

	public static void main(String[] args) {
		log.info("---------====程序正在启动====-----------");
		SpringApplication.run(BUCTApplication.class, args);
		log.info("---------====程序启动成功====-----------");
	}
}
