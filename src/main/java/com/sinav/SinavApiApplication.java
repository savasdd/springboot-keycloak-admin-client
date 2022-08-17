package com.sinav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SinavApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SinavApiApplication.class, args);
	}

}
