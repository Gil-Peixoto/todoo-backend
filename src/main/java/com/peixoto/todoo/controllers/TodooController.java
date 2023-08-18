package com.peixoto.todoo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.peixoto.todoo.entities.Todoo;
import com.peixoto.todoo.services.TodooService;

@CrossOrigin("*")
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
	@GetMapping(value = "/open")
	public ResponseEntity<List<Todoo>> listOpen(){
		List<Todoo> list = service.findAllOpen();
		return ResponseEntity.ok().body(list);
		
	}
	@GetMapping(value = "/close")
	public ResponseEntity<List<Todoo>> listClose(){
		List<Todoo> list = service.findAllClose();
		return ResponseEntity.ok().body(list);
		
	}
	@GetMapping
	public ResponseEntity<List<Todoo>> listAll(){
		List<Todoo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Todoo> create(@RequestBody Todoo obj) {
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Todoo> update(@PathVariable Integer id, @RequestBody Todoo obj) {
		Todoo newObj = service.update(id, obj);
		
		return ResponseEntity.ok().body(newObj);
	}
			
}
