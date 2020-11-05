package com.antoniojnavarro.odilo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.antoniojnavarro.odilo.models.entities.ToDo;
import com.antoniojnavarro.odilo.repository.core.BaseRepository;

public interface ToDoRepository extends BaseRepository<ToDo, Integer>, ToDoRepositoryCustom {
	
	List<ToDo> findByCompleted(Boolean completed);

	List<ToDo> findByUserId(Integer userId);
	
	@Query("select t.title from ToDo t order by length(t.title) asc")
	List<String> getTitles();
}