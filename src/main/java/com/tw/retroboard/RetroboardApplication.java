package com.tw.retroboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class RetroboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetroboardApplication.class, args);
	}
}
