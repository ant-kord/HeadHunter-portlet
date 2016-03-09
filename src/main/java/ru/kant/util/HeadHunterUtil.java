package ru.kant.util;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;

import ru.kant.model.Job;
import ru.kant.model.Page;
import ru.kant.service.JobService;

@Service
public class HeadHunterUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(HeadHunterUtil.class);
	
	@Autowired
	private JobService jobService;
	

	public JobService getJobService() {
		return jobService;
	}

	public void setJobService(JobService jobService) {
		this.jobService = jobService;
	}
	

	@Scheduled(cron = "${job.cron}")
	public void run(){
		RestTemplate restTemplate = new RestTemplate();
		Page page = restTemplate.getForObject("https://api.hh.ru/vacancies?area=4&specialization=15.93", Page.class);
		for(int i = page.getPage(); i < page.getPages(); i++){
			Collection<Job> collection = restTemplate.getForObject("https://api.hh.ru/vacancies?area=4&specialization=15.93&page="+i, JobJson.class).getCollection();
			@SuppressWarnings("unchecked")
			Collection<Job> collectionOld = (Collection<Job>) jobService.getJobsAll();
			if(!collection.containsAll(collectionOld)){
				for(Job job : collection){
					for(Job jobOld : collectionOld){
						if(job.getId().equals(jobOld)){
							jobService.delete(jobOld);
							logger.info("Delete entity jobs: " + job.getId());
						}
					}
				}
			}
			for(Job job : collection){
				jobService.addJob(job);
				logger.info("Update entity jobs: " + job.getId());
			}
		}
		
	}

}
