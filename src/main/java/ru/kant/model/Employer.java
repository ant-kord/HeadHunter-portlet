package ru.kant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employer")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Employer extends NamedEntity{

	private static final long serialVersionUID = 5462055180356685359L;

	@Column(name = "employer_id", unique = true, nullable = false, length=100)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
