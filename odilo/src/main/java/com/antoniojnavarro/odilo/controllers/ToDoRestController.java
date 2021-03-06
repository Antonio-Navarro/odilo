package com.antoniojnavarro.odilo.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antoniojnavarro.odilo.controllers.core.BaseRestController;
import com.antoniojnavarro.odilo.models.dto.ToDoDto;
import com.antoniojnavarro.odilo.models.entities.ToDo;
import com.antoniojnavarro.odilo.services.exceptions.ServicioException;
import com.antoniojnavarro.odilo.services.interfaces.ToDoService;

//PARA PODER RECIBIR LAS LLAMADAS DESDE EL CLIENTE DE ANGULAR CREADO
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/odilo/tests/2")
public class ToDoRestController implements BaseRestController<ToDo, ToDoDto> {

	@Autowired
	private ToDoService toDoService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping(value = "")
	public ResponseEntity<ToDoDto> create(@RequestBody @Valid ToDoDto item) {
		return new ResponseEntity<>(parseEntityToDto(toDoService.create(parseDtoToEntity(item))), HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<ToDoDto>> getAll(@RequestParam(required = false) Boolean estado) {

		if (estado != null) {
			return new ResponseEntity<>(entitiesToDtos(toDoService.getByStatus(estado)), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(entitiesToDtos(toDoService.getAll()), HttpStatus.OK);
		}
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<ToDoDto>> getToDoByUserId(@PathVariable("userId") Integer userId) {
		return new ResponseEntity<>(entitiesToDtos(toDoService.getByUserId(userId)), HttpStatus.OK);
	}

	@GetMapping("/stats")
	public ResponseEntity<Map<Boolean, Long>> getStats() {
		return new ResponseEntity<>(toDoService.getStats(), HttpStatus.OK);
	}

	@GetMapping("/titles")
	public ResponseEntity<List<String>> getTitles() {
		return new ResponseEntity<>(toDoService.getTitles(), HttpStatus.OK);
	}

	// PARA ENCAMPUSULAR Y OCULTAR EL MODEL DE DATOS A LOS QUE CONSUMEN EL ENDPOINT,
	// LO MEJOR SERÍA HACERLO A NIVEL DE SERVICIO, PERO IMPLICARIA TENER DOS
	// SERVICIOS UNO PARA DEVOLER DTOS Y OTRO ENTITIES
	@Override
	public ToDoDto parseEntityToDto(ToDo entity) throws ServicioException {
		return modelMapper.map(entity, ToDoDto.class);
	}

	@Override
	public ToDo parseDtoToEntity(ToDoDto dto) throws ServicioException {
		return modelMapper.map(dto, ToDo.class);
	}

}
