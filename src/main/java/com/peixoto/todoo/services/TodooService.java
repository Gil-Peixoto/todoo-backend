package com.peixoto.todoo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peixoto.todoo.entities.Todoo;
import com.peixoto.todoo.repositories.TodooRepository;

@Service
public class TodooService {
	
	@Autowired
	private TodooRepository repository;
	
	public Todoo findById(Integer id) {
		Optional<Todoo> obj = repository.findById(id);
		return obj.orElse(null);
		
	}
	
}