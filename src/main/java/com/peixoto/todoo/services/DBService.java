package com.peixoto.todoo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peixoto.todoo.entities.Todoo;
import com.peixoto.todoo.repositories.TodooRepository;

@Service
public class DBService {

	@Autowired
	private TodooRepository todooRepository;

	public List<Todoo> instanciaBaseDeDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Todoo t1 = new Todoo(null, "Estudar", "Estudar API e CRUD", sdf.parse("23/07/2023"),false);
		Todoo t2 = new Todoo(null, "Java", "Aprender jpa", sdf.parse("24/07/2023"), true);
		Todoo t3 = new Todoo(null, "Ler", "Documentação", sdf.parse("28/07/2023"),false);
		Todoo t4 = new Todoo(null, "Exercício", "if e else", sdf.parse("22/07/2023"), true);

		return todooRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}

}

