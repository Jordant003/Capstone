package com.capstone.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.Capstone.entity")
@EnableJpaRepositories(basePackages = "com.Capstone.repo")
public class ApplicationConfig {
    
}
