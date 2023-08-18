package com.peixoto.todoo.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.peixoto.todoo.services.DBService;

@Configuration
@Profile("test")
public class TodooTestConfig {
	
	@Autowired
	private DBService dbService;
	
	
	public boolean instancia() throws ParseException {
		this.dbService.instanciaBaseDeDados();
		return true;
	}

}
