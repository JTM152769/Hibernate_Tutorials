package com.amitsa.client;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.amitsa.Entities.Employee;
import com.amitsa.utils.HibernateUtil;



public class Client {

	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	    	
	    	Employee employee = getEmployee();
	    	session.beginTransaction();
	    	
	    	//session.persist(employee);
	    	Integer id =(Integer)session.save(employee);
	    	System.out.println("Employee is created  with Id::"+id);
	    	
	    	session.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }
	
	private static Employee getEmployee(){
		Employee employee= new Employee();
		employee.setEmployeeName("Amit Kumar Sah");
		employee.setEmail("amitsa152769@gmail.com");
		employee.setSalary(80000.00);
		employee.setDoj(new Date());
		return employee;
	}
}
