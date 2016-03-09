package ru.kant.repository;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import ru.kant.model.Job;

@Repository
@Scope("prototype")
public class JobRepositoryImpl implements JobRepository{
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public Collection<?> getJobsAll(int pageNumber, int pageLimit) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Job");
		query.setFirstResult(pageLimit * (pageNumber - 1));
		query.setMaxResults(pageLimit);
		return (Collection<Job>) query.list();
	}

	public Job getJobById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addJob(Job job) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(job);	
	}
	
	@SuppressWarnings("unchecked")
	public Collection<?> getJobsAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("From Job");
		return (Collection<Job>) query.list();
	}

	@Override
	public void delete(Job job) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(job);		
	}


}
