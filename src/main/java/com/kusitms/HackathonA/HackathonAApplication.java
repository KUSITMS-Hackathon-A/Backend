package com.kusitms.HackathonA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HackathonAApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackathonAApplication.class, args);
	}

}
