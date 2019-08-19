package com.amitsa.client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amitsa.entities.Employee;
import com.amitsa.util.HibernateUtil;

public class App {
	
	private static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	createEmployee(session);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }

	private static void createEmployee(Session session) {
		session.beginTransaction();
		Integer id =(Integer)session.save(getEmployee());
		logger.info("Employee is created  with Id::"+id);
		session.getTransaction().commit();
		
	}
	
	private static Employee getEmployee(){
		Employee employee= new Employee();
		employee.setEmployeeName("sumit Kumar Sah");
		employee.setEmail("sumit.cs2017@gmail.com");
		employee.setSalary(80000.00);
		employee.setDoj(new Date());
		return employee;
	}   
}