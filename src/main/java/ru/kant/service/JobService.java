package ru.kant.service;

import java.util.Collection;

import ru.kant.model.Job;

public interface JobService {

//    Collection<?> getJobsAll(int pageNumber, int pageLimit);
    
    Collection<?> getJobsAll();
	
	Job getJobById(Integer id);
	
	void addJob(Job job);
	
	void delete(Job job);
}
