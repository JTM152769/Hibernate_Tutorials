package com.amitsa.client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.amitsa.Entities.Employee;
import com.amitsa.utils.HibernateUtil;



public class Client {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	session.beginTransaction();
	    	/*
	    	 persist() -> This method is used to save an entity/object into database and return a void.
	    	  It will throw an exception if an entity already exists in the database.
	    	 */
	    	  session.persist(getEmployee1());
	    	
	    	/*
	    	 save() -> This method is used to save an entity/object into database and return generated primarykey.
	    	  It will throw an exception if an entity already exists in the database.
	    	 */
	    	Integer id =(Integer)session.save(getEmployee2());
	    	System.out.println("Employee is created  with Id::"+id);
	    	
	    	
	    	//saveOrUpdate()->This method is used to either save or update an entity in the database.
	    	session.saveOrUpdate(getEmployee3());
	    	
	    	session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
	
	private static Employee getEmployee3(){
		Employee employee= new Employee();
		employee.setEmployeeName("Amit Kumar Sah");
		employee.setEmail("amitsa.cs2019@gmail.com");
		employee.setSalary(80000.00);
		employee.setDoj(new Date());
		return employee;
	}
	
	private static Employee getEmployee1(){
		Employee employee= new Employee();
		employee.setEmployeeName("Sumit Kumar Sah");
		employee.setEmail("sumitsa.cs2019@gmail.com");
		employee.setSalary(30000.00);
		employee.setDoj(new Date());
		return employee;
	}
	
	private static Employee getEmployee2(){
		Employee employee= new Employee();
		employee.setEmployeeName("Swati Singh");
		employee.setEmail("swatu.cs2017@gmail.com");
		employee.setSalary(60000.00);
		employee.setDoj(new Date());
		return employee;
	}
}
