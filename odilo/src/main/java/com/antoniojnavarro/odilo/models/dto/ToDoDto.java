package com.antoniojnavarro.odilo.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.antoniojnavarro.odilo.models.core.GenericDto;

public class ToDoDto implements GenericDto {
	
	
	//UTILIZAMOS ESTA CLASE DTO PARA ENCAPSULAR EL MODELO DE DATOS, LO IDEAL SERÍA TENER UN DTO DE ENTRADA Y UN DTO DE RESPUESTA
	/**
	 * 
	 */
	private Integer id;
	private static final long serialVersionUID = 1L;
	@NotNull(message = "El id del usuario no puede ser nulo")
	private Integer userId;
	@NotNull(message = "El titulo no puede ser nulo")
	@NotBlank(message = "El titulo no puede ser vacio")
	@Size( max = 250, message = "El titulo no puede tener más de 250 carácteres")
	private String title;
	
	@NotNull(message = "El estado no puede ser nulo")
	private Boolean completed;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((completed == null) ? 0 : completed.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ToDoDto other = (ToDoDto) obj;
		if (completed == null) {
			if (other.completed != null)
				return false;
		} else if (!completed.equals(other.completed))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	
}