package com.trms.controller;

import java.util.List;

import com.google.gson.Gson;
import com.trms.models.Employee;
import com.trms.service.EmployeeService;
import com.trms.util.LoginInfo;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class EmployeeController {
	
	EmployeeService es;
	Gson gson = new Gson();

	public EmployeeController(EmployeeService es) {
		this.es = es;
	}
	
	public Handler addEmployee = (context) -> {
		Employee e = gson.fromJson(context.body(), Employee.class);
		e = es.addEmployee(e);
		populateResult(context, e);
	};

	 public Handler getEmployeeById = (context) -> {

	        int id = Integer.parseInt(context.pathParam("id"));
	        Employee e = es.getEmployeeById(id);
	        populateResult(context, e);

	    };

	    public Handler updateEmployee = (context) -> {
	    	Employee e = gson.fromJson(context.body(), Employee.class);
			e = es.updateEmployee(e);
			populateResult(context, e);
		};
		
		
		public Handler deleteEmployee = (context) -> {
	        int id = Integer.parseInt(context.pathParam("id"));
	        Employee e = es.deleteEmployee(id);
	        populateResult(context, e);

	    };
	    
	    public Handler getAllEmployees = (context) -> {
	        List<Employee> empList = es.getAllEmployees();

	        if(empList != null) {
	            context.result(gson.toJson(empList));
	        } else {
	            context.result("[]");
	        }
	    };

	    
	    public Handler getEmployeeByUsernamePassword = (context) -> {
	    	LoginInfo loginInfo = gson.fromJson(context.body(), LoginInfo.class);
	    	String username = loginInfo.getUsername();
	    	String password = loginInfo.getPassword();
	    	Employee e = es.getEmployeeByUsernamePassword(username, password);
	    	populateResult(context, e);
	    };
	
	// Helper Method
	private void populateResult(Context context, Employee emp) {

		if (emp != null) {
			context.result(gson.toJson(emp));
		} else {
			context.result("{}");
		}

	}
}
