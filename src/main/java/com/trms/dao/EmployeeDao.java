package com.trms.dao;

import java.util.List;

import com.trms.models.Employee;

public interface EmployeeDao {
	
	public Employee addEmployee(Employee employee);
	public Employee getEmployeeById(int empId);
	public Employee updateEmployee(Employee employee);
	public Employee deleteEmployee(int id);
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeByUsernamePassword(String username, String password);
}
