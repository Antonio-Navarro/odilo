package com.antoniojnavarro.odilo.services.interfaces;

import java.util.List;
import java.util.Map;

import com.antoniojnavarro.odilo.models.entities.ToDo;
import com.antoniojnavarro.odilo.services.core.ServicioCrud;
import com.antoniojnavarro.odilo.services.exceptions.ServicioException;

public interface ToDoService extends ServicioCrud<ToDo, Integer> {

	List<ToDo> getByStatus(boolean isCompleted) throws ServicioException;

	List<ToDo> getByUserId(int userId) throws ServicioException;

	Map<Boolean, Long> getStats() throws ServicioException;

	List<String> getTitles() throws ServicioException;
}
