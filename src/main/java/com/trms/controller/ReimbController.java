package com.trms.controller;

import java.util.List;
import com.google.gson.Gson;
import com.trms.models.Reimb;
import com.trms.service.ReimbService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ReimbController {
	ReimbService rs;
	Gson gson = new Gson();

	public ReimbController(ReimbService rs) {
		this.rs = rs;
	}
	
	public Handler addReimb = (context) -> {
		Reimb rb = gson.fromJson(context.body(), Reimb.class);
		rb = rs.addReimb(rb);
		populateResult(context, rb);
	};

	 public Handler getReimbById = (context) -> {

	        int id = Integer.parseInt(context.pathParam("id"));
	        Reimb rb = rs.getReimbById(id);
	        populateResult(context, rb);

	    };

	    public Handler updateReimb = (context) -> {
	    	Reimb rb = gson.fromJson(context.body(), Reimb.class);
	    	rb = rs.updateReimb(rb);
			populateResult(context, rb);
		};
		
		
		public Handler deleteReimb = (context) -> {
	        int id = Integer.parseInt(context.pathParam("id"));
	        Reimb rb = rs.deleteReimb(id);
	        populateResult(context, rb);

	    };
	    
	    public Handler getAllReimbs = (context) -> {
	        List<Reimb> reimbList = rs.getAllReimbs();

	        if(reimbList != null) {
	            context.result(gson.toJson(reimbList));
	        } else {
	            context.result("[]");
	        }
	    };
	    
	    
	    public Handler getAllReimbByEmpId = (context) -> {

	        int empId = Integer.parseInt(context.pathParam("empId"));
	        List<Reimb> rb = rs.getAllReimbByEmpId(empId);
	        if(rb != null) {
	            context.result(gson.toJson(rb));
	        } else {
	            context.result("[]");
	        }
	    };
	    
	    //get all reimbs that needs my approval
	    public Handler getAllRequestsForApproval = (context) -> {

	        int id = Integer.parseInt(context.pathParam("id"));
	        List<Reimb> rb = rs.getAllRequestsForApproval(id);
	        if(rb != null) {
	            context.result(gson.toJson(rb));
	        } else {
	            context.result("[]");
	        }
	    };
	    
	    //update approvals by supervisor/dept head/benCo 1st approval
	    public Handler updateApprovals = (context) -> {
	    	int rbId = Integer.parseInt(context.pathParam("rbId"));
	        int ApproversEmpId = Integer.parseInt(context.pathParam("empId"));
	        Reimb rb = rs.updateApprovals(rbId, ApproversEmpId);
	        populateResult(context, rb);
	    };
	    
	  //update 2nd approval by benCo 2nd approval
	    public Handler confirm = (context) -> {
	    	int rbId = Integer.parseInt(context.pathParam("rbId"));
	        int ApproversEmpId = Integer.parseInt(context.pathParam("empId"));
	        Reimb rb = rs.confirm(rbId, ApproversEmpId);
	        populateResult(context, rb);
	    };
	    
	  //upload final grade
	    public Handler upload = (context) -> {
	    	int rbId = Integer.parseInt(context.pathParam("rbId"));
	        Reimb rb = rs.upload(rbId);
	        populateResult(context, rb);
	    };
	    
	  //more info
	    public Handler moreInfo = (context) -> {
	    	int rbId = Integer.parseInt(context.pathParam("rbId"));
	        Reimb rb = rs.moreInfo(rbId);
	        populateResult(context, rb);
	    };
	    
//	    //upload final grade
//	    public Handler upload = (context) -> {
//	    	int rbId = Integer.parseInt(context.pathParam("rbId"));
//	    	Reimb rb = gson.fromJson(context.body(), Reimb.class);
//	    	String grade = rb.getGrade();
//	        rb = rs.upload(grade, rbId);
//	        populateResult(context, rb);
//	        
//	    };
	    
	  //upload file 
	    public Handler uploadFile = (context) -> {
	    	int rbId = Integer.parseInt(context.pathParam("rbId"));
	    	Reimb rb = gson.fromJson(context.body(), Reimb.class);
	    	String fileName = rb.getFile();
	        rb = rs.uploadFile(rbId, fileName);
	        populateResult(context, rb);
	        
	    };
	    
	
	// Helper Method
	private void populateResult(Context context, Reimb reimb) {

		if (reimb != null) {
			context.result(gson.toJson(reimb));
		} else {
			context.result("{}");
		}

	}
}
