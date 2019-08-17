package com.amitsa.service.impl;

import com.amitsa.dao.impl.EmployeeDAOImpl;
import com.amitsa.entities.Employee;
import com.amitsa.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void createEmployee(Employee employee) {
		new EmployeeDAOImpl().addEmployee(employee);
	}

	@Override
	public Employee getEmployeebyId(int employeeId) {
		return new EmployeeDAOImpl().fetchEmployeebyId(employeeId);
	}

	@Override
	public void updateEmployeeById(int employeeId, Double newSal) {
		new EmployeeDAOImpl().updateEmployeeById(employeeId, newSal);
	}

	@Override
	public void deleteEmployeeById(Integer employeeId) {
		new EmployeeDAOImpl().deleteEmployeeById(employeeId);
	}

}