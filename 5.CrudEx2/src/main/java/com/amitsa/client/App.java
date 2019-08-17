package com.amitsa.client;

import java.util.Date;

import com.amitsa.entities.Employee;
import com.amitsa.service.EmployeeService;
import com.amitsa.service.impl.EmployeeServiceImpl;

public class App {
	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		createEmployee(employeeService);
    	//getEmployeebyId(employeeService);
    	//updateEmployeeById(employeeService);
    	//deleteEmployeeById(employeeService);
	  }

	private static void deleteEmployeeById(EmployeeService employeeService) {
		employeeService.deleteEmployeeById(1);
	}

	private static void updateEmployeeById(EmployeeService employeeService) {
		employeeService.updateEmployeeById(1, 60000.00);
	}

	private static void getEmployeebyId(EmployeeService employeeService) {
		Employee employee = employeeService.getEmployeebyId(1);
		System.out.println(employee);
	}

	private static void createEmployee(EmployeeService employeeService) {
		employeeService.createEmployee(getEmployee());
	}
	
	private static Employee getEmployee(){
		Employee employee= new Employee();
		employee.setEmployeeName("Sumit Kumar Sah");
		employee.setEmail("sumit.cs2017@gmail.com");
		employee.setSalary(60000.00);
		employee.setDoj(new Date());
		return employee;
	}

}
