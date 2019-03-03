package com.momenton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.momenton"})
public class EmpepApplication {
    protected final Logger       logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		SpringApplication.run(EmpepApplication.class, args);
	}

}
