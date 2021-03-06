package com.antoniojnavarro.odilo.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.antoniojnavarro.odilo.tasks.TareasProgramadas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//PARA PERMITIR ACCEDER DESDE EL CLIENTE DE ANGULAR CREADO
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/odilo/tests/1")
//NO IMPLEMENTA BaseRestController por que es muy simple y no hemos creado una entity y dto para ella
public class JobRestController {

	@Value("${initial.delay}")
	String delay;

	@Autowired
	TareasProgramadas tareasProgramadas;

	@Autowired
	private ScheduledAnnotationBeanPostProcessor postProcessor;

	@Autowired
	ObjectMapper objectMapper;

	@GetMapping("/mensaje")
	public String index() throws InterruptedException {
		Thread.sleep(10000L);

		return "hola es una prueba" + delay;
	}

	@GetMapping(value = "")
	public ResponseEntity<String> listarJobsEjecucion() throws JsonProcessingException {
		Set<ScheduledTask> setTasks = postProcessor.getScheduledTasks();
		if (!setTasks.isEmpty()) {
			return new ResponseEntity<>(objectMapper.writeValueAsString(setTasks), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("!Actualmente no hay tareas en ejecución!", HttpStatus.OK);
		}
	}

	@PostMapping("")
	public ResponseEntity<String> pararJobs() {
		postProcessor.postProcessBeforeDestruction(tareasProgramadas, "tareasProgramadas");
		return new ResponseEntity<>("Tareas paradas con exito", HttpStatus.OK);

	}

	@PostMapping(value = "/arrancarTareas")
	public ResponseEntity<String> startSchedule() {
		postProcessor.postProcessAfterInitialization(tareasProgramadas, "tareasProgramadas");
		return new ResponseEntity<>("Tareas arrancadas con exito", HttpStatus.OK);
	}

}
