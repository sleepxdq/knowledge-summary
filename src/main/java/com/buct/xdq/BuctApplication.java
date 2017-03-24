package com.buct.xdq;

import com.buct.xdq.utils.MyStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuctApplication {
	private static final Logger log = LoggerFactory.getLogger(BuctApplication.class);

	public static void main(String[] args) {
		log.info("---------====程序正在启动====-----------");
		SpringApplication.run(BuctApplication.class, args);
	}
}
