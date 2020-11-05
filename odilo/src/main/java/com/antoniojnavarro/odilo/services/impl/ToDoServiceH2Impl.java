package com.antoniojnavarro.odilo.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.antoniojnavarro.odilo.models.entities.ToDo;
import com.antoniojnavarro.odilo.repository.ToDoRepository;
import com.antoniojnavarro.odilo.services.exceptions.ServicioException;
import com.antoniojnavarro.odilo.services.interfaces.ToDoService;

@Service
@Profile("h2")
public class ToDoServiceH2Impl implements ToDoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ToDoRepository toDoRepository;

	@Override
	public ToDo create(ToDo item) throws ServicioException {
		return toDoRepository.save(item);
	}

	@Override
	public List<ToDo> getAll() throws ServicioException {
		return toDoRepository.findAll();
	}

	@Override
	public List<ToDo> getByStatus(boolean isCompleted) throws ServicioException {
		return toDoRepository.findByCompleted(isCompleted);
	}

	@Override
	public List<ToDo> getByUserId(int userId) throws ServicioException {
		return toDoRepository.findByUserId(userId);
	}

	@Override
	public Map<Boolean, Long> getStats() throws ServicioException {
		return toDoRepository.getStats();
	}

	@Override
	public List<String> getTitles() throws ServicioException {
		return toDoRepository.getTitles();
	}

}
