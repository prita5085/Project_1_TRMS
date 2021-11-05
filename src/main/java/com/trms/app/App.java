package com.trms.app;

import com.trms.controller.DeptController;
import com.trms.controller.EmployeeController;
import com.trms.controller.EventController;
import com.trms.controller.ReimbController;
import com.trms.dao.DeptDao;
import com.trms.dao.DeptDaoImpl;
import com.trms.dao.EmployeeDao;
import com.trms.dao.EmployeeDaoImpl;
import com.trms.dao.EventDao;
import com.trms.dao.EventDaoImpl;
import com.trms.dao.ReimbDao;
import com.trms.dao.ReimbDaoImpl;
import com.trms.service.DeptService;
import com.trms.service.DeptServiceImpl;
import com.trms.service.EmployeeService;
import com.trms.service.EmployeeServiceImpl;
import com.trms.service.EventService;
import com.trms.service.EventServiceImpl;
import com.trms.service.ReimbService;
import com.trms.service.ReimbServiceImpl;

import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class App {

	public static void main(String[] args) {
		
        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);

        establishRoutes(app);

        app.start(7000);

	}
	
	private static void establishRoutes(Javalin app) {
		
        //app.get("/hello", (ctx) -> ctx.result("Hello World!"));
        
        app.get("/", (ctx) -> ctx.result("Welcome to TRMS App"));

        addDeptRoutes(app);
        addEmployeeRoutes(app);
        addEventRoutes(app);
        addReimbRoutes(app);

    }
	
	private static void addDeptRoutes(Javalin app) {

		DeptDao dd = new DeptDaoImpl();
		DeptService ds = new DeptServiceImpl(dd);
		DeptController dc = new DeptController(ds);
		
		app.post("/dept", dc.addDept);
		app.get("/dept", dc.getAllDepts);
		app.get("/dept/:id", dc.getDeptById);
		app.put("/dept/:id", dc.updateDept);
		app.delete("/dept/:id", dc.deleteDept);

    }

    private static void addEmployeeRoutes(Javalin app) {
    	
    	EmployeeDao ed = new EmployeeDaoImpl();
    	EmployeeService es = new EmployeeServiceImpl(ed);
    	EmployeeController ec = new EmployeeController(es);
		
		app.post("/employee", ec.addEmployee);
		app.get("/employee", ec.getAllEmployees);
		app.get("/employee/:id", ec.getEmployeeById);
		app.put("/employee/:id", ec.updateEmployee);
		app.delete("/employee/:id", ec.deleteEmployee);
		app.post("/loginInfo", ec.getEmployeeByUsernamePassword);
		
    }

    private static void addEventRoutes(Javalin app) {

    	EventDao evd = new EventDaoImpl();
    	EventService evs = new EventServiceImpl(evd);
    	EventController evc = new EventController(evs);
		
		app.post("/event", evc.addEvent);
		app.get("/event", evc.getAllEvents);
		app.get("/event/:id", evc.getEventById);
		app.put("/event/:id", evc.updateEvent);
		app.delete("/event/:id", evc.deleteEvent);
		

    }
    
    private static void addReimbRoutes(Javalin app) {

    	ReimbDao rd = new ReimbDaoImpl();
    	ReimbService rs = new ReimbServiceImpl(rd);
    	ReimbController rc = new ReimbController(rs);
		
		app.post("/reimb", rc.addReimb);
		app.get("/reimb", rc.getAllReimbs);
		app.get("/reimb/:id", rc.getReimbById);
		app.put("/reimb/:id", rc.updateReimb);
		app.delete("/reimb/:id", rc.deleteReimb);
		
		app.get("/reimb/employee/:empId", rc.getAllReimbByEmpId); //get all of my own reqs
		
		app.get("/reimb/employees/reimbs/:id", rc.getAllRequestsForApproval); //get all that needs my app
		
		app.put("/reimb/:rbId/employee/:empId", rc.updateApprovals); //update app/status based on role
		
		app.get("/reimb/grade/:rbId", rc.upload); //upload final grade
		
		app.get("/reimb/info/:rbId", rc.moreInfo); //more info
		
		app.put("/reimb/uploadFile/:rbId", rc.uploadFile);
		
		app.put("/reimb/confirm/:rbId/benco/:empId", rc.confirm); //2nd approval BenCo/Confirmed/Amount Updated
	
    }


}
