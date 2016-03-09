package ru.kant.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

@MappedSuperclass
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = 7963695721693373180L;
	@Id
    @Column(name = "id", unique = false, nullable = true)
	@JsonProperty("id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
    

}
