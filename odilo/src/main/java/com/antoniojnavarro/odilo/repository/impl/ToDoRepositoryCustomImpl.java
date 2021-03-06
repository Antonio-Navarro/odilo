package com.antoniojnavarro.odilo.repository.impl;

import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;

import com.antoniojnavarro.odilo.repository.ToDoRepositoryCustom;

public class ToDoRepositoryCustomImpl implements ToDoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Map<Boolean, Long> getStats() {
		return em
				.createQuery("SELECT t.completed as completado, count(t) as numero FROM ToDo t group by t.completed",
						Tuple.class)
				.getResultStream().collect(Collectors.toMap(tuple -> ((Boolean) tuple.get("completado")).booleanValue(),
						tuple -> ((Long) tuple.get("numero")).longValue()));
	}

}
