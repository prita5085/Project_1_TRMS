package com.trms.service;

import java.util.List; 

import com.trms.dao.EmployeeDao;
import com.trms.models.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDao dao;
	
	public EmployeeServiceImpl(EmployeeDao dao) {
		this.dao = dao;
	}


	public Employee addEmployee(Employee employee) {
		return dao.addEmployee(employee);
	}


	public Employee getEmployeeById(int empId) {
		return dao.getEmployeeById(empId);
	}


	public Employee updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}

	
	public Employee deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}


	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}


	@Override
	public Employee getEmployeeByUsernamePassword(String username, String password) {
		return dao.getEmployeeByUsernamePassword(username, password);
	}
	
	
}
