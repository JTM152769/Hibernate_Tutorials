package com.amitsa.client;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.amitsa.utils.HibernateUtil;

public class Client {
	
	public static void main(String[] args) {
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			// Query to Check MySQL database version
			String sql = "select version()";
			String result = (String) session.createNativeQuery(sql).getSingleResult();
			System.out.println("MySql Database Version is:::");
			System.out.println(result);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	  }

}


