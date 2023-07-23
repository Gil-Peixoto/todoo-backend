package com.peixoto.todoo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peixoto.todoo.entities.Todoo;
import com.peixoto.todoo.services.TodooService;

@RestController
@RequestMapping(value = "/todoos")
public class TodooController {
	
	@Autowired
	private TodooService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Todoo> findById(@PathVariable Integer id) {
		Todoo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	

}
