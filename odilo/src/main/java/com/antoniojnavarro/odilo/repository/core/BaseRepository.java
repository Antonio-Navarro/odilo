package com.antoniojnavarro.odilo.repository.core;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.antoniojnavarro.odilo.models.core.GenericEntity;

@NoRepositoryBean
public interface BaseRepository<T extends GenericEntity, ID extends Serializable> extends JpaRepository<T, ID> {

}
