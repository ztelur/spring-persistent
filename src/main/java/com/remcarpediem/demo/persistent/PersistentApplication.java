package com.remcarpediem.demo.persistent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PersistentApplication {

	/**
	 * https://blog.csdn.net/shijiemozujiejie/article/details/80786231
	 * 读写分离加数据分片
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(PersistentApplication.class, args);
	}

}
