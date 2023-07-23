package com.peixoto.todoo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peixoto.todoo.entities.Todoo;
import com.peixoto.todoo.repositories.TodooRepository;

@Service
public class DBService {

	@Autowired
	private TodooRepository todooRepository;

	public void instanciaBaseDeDados() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Todoo t1 = new Todoo(null, "estudar", "Estudar API e CRUD", LocalDateTime.parse("23/07/2023 15:12", formatter),false);
		Todoo t2 = new Todoo(null, "Java", "Estudar OO", LocalDateTime.parse("24/07/2023 16:18", formatter), false);

		todooRepository.saveAll(Arrays.asList(t1, t2));
	}

}

