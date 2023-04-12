package com.travlej.backend.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.travlej.backend")
@EnableJpaRepositories(basePackages = "com.travlej.backend")
public class JPAConfiguration {
}
