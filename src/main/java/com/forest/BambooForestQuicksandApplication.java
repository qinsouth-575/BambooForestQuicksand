package com.forest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.forest.mapper")
public class BambooForestQuicksandApplication {

	public static void main(String[] args) {
		//两种方式
		//1.本类添加MapperScan注解
		//2.每个dao接口添加元注释 - 这个简单
		
		SpringApplication.run(BambooForestQuicksandApplication.class, args);
	}

}
