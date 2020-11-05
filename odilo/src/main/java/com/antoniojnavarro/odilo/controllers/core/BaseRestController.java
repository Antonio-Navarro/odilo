package com.antoniojnavarro.odilo.controllers.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.antoniojnavarro.odilo.models.core.GenericDto;
import com.antoniojnavarro.odilo.models.core.GenericEntity;
import com.antoniojnavarro.odilo.services.exceptions.ServicioException;

public interface BaseRestController<TEntity extends GenericEntity, DTO extends GenericDto> {
	default DTO entityToDto(TEntity entity) throws ServicioException {
		if (entity == null) {
			return null;
		}
		return this.parseEntityToDto(entity);
	}

	default List<DTO> entitiesToDtos(List<TEntity> entities) throws ServicioException {
		return entities == null ? new ArrayList<DTO>()
				: entities.stream().map(this::entityToDto).collect(Collectors.toList());
	}

	default TEntity dtoToEntity(DTO dto) throws RuntimeException {
		if (dto == null) {
			return null;
		}
		return this.parseDtoToEntity(dto);
	}

	default List<TEntity> dtosToEntities(List<DTO> dtos) throws ServicioException {
		return dtos == null ? new ArrayList<TEntity>()
				: dtos.stream().map(this::dtoToEntity).collect(Collectors.toList());
	}

	// Parsers de entitades a DTO y viceversa (Método plantilla),
	DTO parseEntityToDto(TEntity entity) throws ServicioException;

	TEntity parseDtoToEntity(DTO dto) throws ServicioException;
}