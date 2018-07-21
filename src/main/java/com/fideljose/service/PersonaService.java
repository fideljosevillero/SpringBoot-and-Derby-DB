package com.fideljose.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fideljose.models.Persona;

@Service
public class PersonaService {

	@Autowired
	private IPersonaService iPersonaService;
	
	@Autowired
	private Persona persona;
	
	public void savePersona() {
		//persona.setAddress("aaaaa");
		//persona.setId(122);
		//persona.setName("name");
		iPersonaService.save(new Persona("fidel jose", "home"));
		//iPersonaService.save(persona);
	}
	
	public List<Persona> listPersonas(){
		List<Persona> list = new ArrayList<>();
		for(Persona e: iPersonaService.findAll()) {
	        list.add(e);
	      }
		return list;
	}
	
}
