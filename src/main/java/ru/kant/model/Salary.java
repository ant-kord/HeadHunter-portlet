package ru.kant.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Embeddable
@JsonIgnoreProperties(ignoreUnknown=true)
public class Salary implements Serializable{

	private static final long serialVersionUID = -3367465967081416379L;
	
	@Column(name = "unto", unique = false, nullable = true)
	private Integer to;
	
	@Column(name = "after", unique = false, nullable = true)
	private Integer from;

	@Column(name = "currency", unique = false, nullable = true, length = 10)
	private String currency;

	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	public Integer getFrom() {
		return from;
	}

	public void setFrom(Integer from) {
		this.from = from;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}
