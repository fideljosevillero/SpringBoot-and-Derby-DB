package com.fideljose.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fideljose.models.ErrorJson;


//import com.fideljose.models.Persona;
//import com.fideljose.service.PersonaService;

@RestController
//@Controller
public class PersonaController implements ErrorController {
	
	@Autowired
	private ErrorAttributes errorAttribute;
	
	private final static String ERROR = "/error";
	
//	@Autowired
//	private PersonaService personaService;
	
	@Value("${valueFromConfigFile}")
	private Integer value;
	
	@RequestMapping("/")
	public String home() {
		System.out.println("valor => " + value);
		//personaService.savePersona();
		return "Hello Fidel!!!";
	}
	
//	@RequestMapping("/lista")
//	public List<Persona> getLista(){
//		return personaService.listPersonas();
//	}
	
	//*** custom error
	@GetMapping(value="/error")
	//public String errorHandler() {
	ErrorJson errorHandler(HttpServletRequest request, HttpServletResponse response) {
		return new ErrorJson(response.getStatus(), getErrorAttributes(request, true));
	}

	public String getErrorPath() {
		return "";
		//return ERROR;
	}
	
	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace){
		RequestAttributes requestAttribute = new ServletRequestAttributes(request);
		return errorAttribute.getErrorAttributes(requestAttribute, includeStackTrace);
	}
	
	@GetMapping("/run-error")
	public String malo() {
		throw new RuntimeException();
	}
	
}
