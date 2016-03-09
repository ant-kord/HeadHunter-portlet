package ru.kant.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ru.kant.model.Job;
import ru.kant.service.JobService;

@ManagedBean
@ViewScoped
public class ManagedJob implements Serializable{

	private static final long serialVersionUID = -7919297213656627931L;
	
	@ManagedProperty("#{jobServiceImpl}")
	private JobService jobService;
	
	private Collection<Job> listJobs;
	
	private String text;

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	
	public Collection<Job> getListJobs() {
		return listJobs;
	}

	public void setListJobs(Collection<Job> listJobs) {
		this.listJobs = listJobs;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init(){
		listJobs = (Collection<Job>) jobService.getJobsAll();
	}

	public void search(){
		Collection<Job> tmp = new ArrayList<Job>();
		for(Job job : listJobs){
			if(job.getName().equalsIgnoreCase(text))
				tmp.add(job);
		}
		setListJobs(tmp);
	}
	
	public void sortedByName(){
		Collections.sort((ArrayList<Job>)listJobs, new Comparator<Job>(){
			@Override
			public int compare(Job job1, Job job2) {
				return job1.getName().compareTo(job2.getName());
			}
			
		});
	}
	
	public void sortedByDate(){
		Collections.sort((ArrayList<Job>)listJobs, new Comparator<Job>(){
			@Override
			public int compare(Job job1, Job job2) {
				return job1.getCreated_at().compareTo(job2.getCreated_at());
			}
			
		});
	}

}
