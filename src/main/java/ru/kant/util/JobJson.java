package ru.kant.util;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import ru.kant.model.Job;

@JsonIgnoreProperties(ignoreUnknown=true)
public class JobJson {

	@JsonProperty("items")
	private Collection<Job> collection;

	public Collection<Job> getCollection() {
		return collection;
	}

	public void setCollection(Collection<Job> collection) {
		this.collection = collection;
	}
}
