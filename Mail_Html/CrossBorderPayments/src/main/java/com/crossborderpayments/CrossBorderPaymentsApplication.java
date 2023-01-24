package com.crossborderpayments;

import com.crossborderpayments.mapper.UserDetailsMapper;
import com.crossborderpayments.mapper.UserDetailsMapperImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class CrossBorderPaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrossBorderPaymentsApplication.class, args);
	}

	@Bean
	public UserDetailsMapper getMapper(){
		return  new UserDetailsMapperImpl();
	}

}
