package com.peixoto.todoo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodooApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TodooApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}
