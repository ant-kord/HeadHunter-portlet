package ru.kant.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

@MappedSuperclass
public class NamedEntity extends BaseEntity{

	private static final long serialVersionUID = -5249745048125213957L;
	
	@Column(name = "name", unique = false, nullable = false, length = 100)
	@JsonProperty("name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
