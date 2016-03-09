package ru.kant.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.kant.model.Job;
import ru.kant.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	private JobRepository jobsRepository;

	public JobRepository getJobsRepository() {
		return jobsRepository;
	}

	public void setJobsRepository(JobRepository jobsRepository) {
		this.jobsRepository = jobsRepository;
	}

//	@Transactional
//	public Collection<?> getJobsAll(int pageNumber, int pageLimit) {return jobsRepository.getJobsAll(pageNumber, pageLimit);}

	@Transactional
	public Job getJobById(Integer id) {return jobsRepository.getJobById(id);}

	@Transactional
	public void addJob(Job job) {jobsRepository.addJob(job);}

	@Transactional
	public Collection<?> getJobsAll() {return jobsRepository.getJobsAll();}

	@Transactional
	public void delete(Job job) {jobsRepository.delete(job);}

}
