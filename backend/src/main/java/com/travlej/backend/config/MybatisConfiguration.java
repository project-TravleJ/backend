package com.travlej.backend.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.travlej.backend", annotationClass = Mapper.class)
public class MybatisConfiguration {
}
