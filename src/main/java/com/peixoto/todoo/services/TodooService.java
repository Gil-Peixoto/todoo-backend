package com.peixoto.todoo.services;

import java.util.List;
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

	public List<Todoo> findAllOpen() {
		List<Todoo> list = repository.findAllOpen();
		return list;
	}

	public List<Todoo> findAllClose() {
		List<Todoo> list = repository.findAllClose();
		return list;
	}

	public List<Todoo> findAll() {
		List<Todoo> list = repository.findAll();
		return list;
	}

	public Todoo create(Todoo obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
		
	}
	
}