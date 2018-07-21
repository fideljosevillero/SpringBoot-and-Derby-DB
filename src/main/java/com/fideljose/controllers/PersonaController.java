package com.fideljose.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fideljose.models.Persona;
import com.fideljose.service.PersonaService;

@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@RequestMapping("/")
	public String home() {
		personaService.savePersona();
		return "Hello Fidel!!!";
	}
	
	@RequestMapping("/lista")
	public List<Persona> getLista(){
		return personaService.listPersonas();
	}
}
