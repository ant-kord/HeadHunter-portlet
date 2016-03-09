package ru.kant.repository;

import java.util.Collection;

import org.hibernate.exception.DataException;

import ru.kant.model.Job;

public interface JobRepository {
	
//	Collection<?> getJobsAll(int pageNumber, int pageLimit);
	
	Collection<?> getJobsAll() throws DataException;
	
	Job getJobById(Integer id) throws DataException;
	
	void addJob(Job job) throws DataException;
	
	void delete(Job job) throws DataException;
}
