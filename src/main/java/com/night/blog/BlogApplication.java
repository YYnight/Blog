package com.night.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@MapperScan("com.night.blog.dao")
public class BlogApplication {

	@RequestMapping("/hello")
	public String sayHello(){
		return "hello";
	}
	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
}
