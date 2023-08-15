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

		Todoo t1 = new Todoo(null, "Estudar", "Estudar API e CRUD", LocalDateTime.parse("23/07/2023 15:12", formatter),false);
		Todoo t2 = new Todoo(null, "Java", "Aprender jpa", LocalDateTime.parse("24/07/2023 16:18", formatter), true);
		Todoo t3 = new Todoo(null, "Ler", "Documentação", LocalDateTime.parse("28/07/2023 15:15", formatter),false);
		Todoo t4 = new Todoo(null, "Exercício", "if e else", LocalDateTime.parse("22/07/2023 16:19", formatter), true);

		todooRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}

}

