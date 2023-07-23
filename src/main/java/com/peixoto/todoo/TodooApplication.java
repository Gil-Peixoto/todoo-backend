package com.peixoto.todoo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.peixoto.todoo.entities.Todoo;
import com.peixoto.todoo.repositories.TodooRepository;

@SpringBootApplication
public class TodooApplication implements CommandLineRunner{
	
	@Autowired
	private TodooRepository todooRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TodooApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		Todoo t1 = new Todoo(null, "estudar", "Estudar API e CRUD", LocalDateTime.parse("23/07/2023 15:12", formatter), false);
		Todoo t2 = new Todoo(null, "Java", "Estudar OO", LocalDateTime.parse("24/07/2023 16:18",formatter), false);
	
		todooRepository.saveAll(Arrays.asList(t1, t2));
	}
	

}
