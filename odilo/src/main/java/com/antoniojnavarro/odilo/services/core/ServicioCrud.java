package com.antoniojnavarro.odilo.services.core;

import java.io.Serializable;
import java.util.List;

import com.antoniojnavarro.odilo.models.core.GenericEntity;
import com.antoniojnavarro.odilo.models.entities.ToDo;

public interface ServicioCrud<T extends GenericEntity, ID extends Serializable> extends Serializable {

	
	// AQUÍ AÑADIRIAMOS TODAS LAS ESPECIFICACIONES DE LOS METODOS COMUNES PARA TODOS
	// LOS SERVICIOS COMO findById, findAll, save, delete, exists
	// pero por no perder tiempo no se han añadido para no tener que implementarlos.
	

	//ESTOS 2 SE PODRÍA DECIR QUE SI PODEMOS HACERLOS GENERICOS
	ToDo create(ToDo item);

	List<ToDo> getAll();
}
