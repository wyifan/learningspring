package com.yifan.mybatis;

import com.yifan.mybatis.mapper.CityMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Parameter 0 of constructor in com.yifan.mybatis.MybatisApplication required a bean of type
// 'com.yifan.mybatis.mapper.CityMapper' that could not be found.
//
//
//Action:
//
//Consider defining a bean of type 'com.yifan.mybatis.mapper.CityMapper' in your configuration.
// fixed by add @MapperScan
@SpringBootApplication
//@MapperScan("com.yifan.mybatis.mapper.CityMapper")
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
