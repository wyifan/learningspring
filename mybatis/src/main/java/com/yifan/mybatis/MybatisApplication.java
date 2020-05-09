package com.yifan.mybatis;

import com.yifan.mybatis.mapper.CityMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}

	private final CityMapper cityMapper;

	public MybatisApplication(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}

	@Override
	@SuppressWarnings("squid:S106")
	public void run(String... args) {
		System.out.println(this.cityMapper.findByState("CA"));
	}

}
