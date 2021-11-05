package com.trms.controller;

import java.util.List;

import com.google.gson.Gson;
import com.trms.models.Dept;
import com.trms.service.DeptService;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class DeptController {

	DeptService ds;
	Gson gson = new Gson();

	public DeptController(DeptService ds) {
		this.ds = ds;
	}
	
	public Handler addDept = (context) -> {
		Dept d = gson.fromJson(context.body(), Dept.class);
		d = ds.addDept(d);
		populateResult(context, d);
	};

	 public Handler getDeptById = (context) -> {

	        int id = Integer.parseInt(context.pathParam("id"));
	        Dept d = ds.getDeptById(id);
	        populateResult(context, d);

	    };

	    public Handler updateDept = (context) -> {
			Dept d = gson.fromJson(context.body(), Dept.class);
			d = ds.updateDept(d);
			populateResult(context, d);
		};
		
		
		public Handler deleteDept = (context) -> {
	        int id = Integer.parseInt(context.pathParam("id"));
	        Dept d = ds.deleteDept(id);
	        populateResult(context, d);

	    };
	    
	    public Handler getAllDepts = (context) -> {
	        List<Dept> deptList = ds.getAllDepts();

	        if(deptList != null) {
	            context.result(gson.toJson(deptList));
	        } else {
	            context.result("[]");
	        }
	    };

	
	// Helper Method
	private void populateResult(Context context, Dept dept) {

		if (dept != null) {
			context.result(gson.toJson(dept));
		} else {
			context.result("{}");
		}

	}

}
