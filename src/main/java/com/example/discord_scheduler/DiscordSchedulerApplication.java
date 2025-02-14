package com.example.discord_scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DiscordSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscordSchedulerApplication.class, args);
	}

}
