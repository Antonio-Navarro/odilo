package com.antoniojnavarro.odilo.services.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.antoniojnavarro.odilo.models.entities.ToDo;
import com.antoniojnavarro.odilo.services.exceptions.ServicioException;
import com.antoniojnavarro.odilo.services.interfaces.ToDoService;

@Service
@Profile({ "url", "default" })
public class ToDoServiceDefaultImpl implements ToDoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	List<ToDo> datosUrl;

	@Override
	public ToDo create(ToDo item) {
		List<Integer> ids = datosUrl.stream().map(t -> t.getId()).collect(Collectors.toList());
		item.setId(Collections.max(ids) + 1);
		datosUrl.add(item);
		return item;
	}

	@Override
	public List<ToDo> getAll() throws ServicioException {
		return datosUrl;
	}

	@Override
	public List<ToDo> getByStatus(boolean isCompleted) throws ServicioException {
		return datosUrl.stream().filter(t -> t.getCompleted() == isCompleted).collect(Collectors.toList());
	}

	@Override
	public List<ToDo> getByUserId(int userId) throws ServicioException {
		return datosUrl.stream().filter(t -> t.getUserId() == userId).collect(Collectors.toList());
	}

	@Override
	public Map<Boolean, Long> getStats() throws ServicioException {
		return datosUrl.stream().collect(Collectors.groupingBy(ToDo::getCompleted, Collectors.counting()));

	}

	@Override
	public List<String> getTitles() throws ServicioException {

		List<String> titulos = datosUrl.stream().map(t -> t.getTitle()).collect(Collectors.toList());

		Comparator<String> c = new Comparator<>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		};

		Collections.sort(titulos, c);
		return titulos;
	}

}
