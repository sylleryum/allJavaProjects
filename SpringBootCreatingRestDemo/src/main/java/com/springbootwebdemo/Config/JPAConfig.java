package com.springbootwebdemo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.springbootwebdemo.DAO")
public class JPAConfig {
}
