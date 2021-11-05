package com.trms.service;

import java.util.List;

import com.trms.models.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	public Employee getEmployeeById(int empId);
	public Employee updateEmployee(Employee employee);
	public Employee deleteEmployee(int id);
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeByUsernamePassword(String username, String password);

}
