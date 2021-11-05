package com.trms.app;

import java.util.List;

import com.trms.dao.DeptDao; 
import com.trms.dao.DeptDaoImpl;
import com.trms.dao.EmployeeDao;
import com.trms.dao.EmployeeDaoImpl;
import com.trms.dao.ReimbDao;
import com.trms.dao.ReimbDaoImpl;
import com.trms.models.Dept;
import com.trms.models.Employee;
import com.trms.models.Reimb;



public class Test {

	public static void main(String[] args) {
		
		DeptDao dd = new DeptDaoImpl();
		EmployeeDao ed = new EmployeeDaoImpl();
		ReimbDao rd = new ReimbDaoImpl();
		
		//Dept d1 = new Dept(404, "Arts");
		//Dept d2 = new Dept(202, "Pharmacy");
		//dd.addDept(d1);
		//dd.addDept(d2);
		//System.out.println(dd.getDeptById(404));
		//Employee e1 = new Employee("Emma","emma","emma123", d1);
		//ed.addEmployee(e1);
//		Employee e2 = ed.getEmployeeById(3); 
//		Employee e3 = ed.getEmployeeById(1);
//		System.out.println(e3);
//		e3.setSup(e2);
//		System.out.println(ed.updateEmployee(e3));
		
//		Dept d3 = dd.getDeptById(404);
//		System.out.println(d3);
//		Employee e = ed.getEmployeeById(1);
//		System.out.println(e);
//		d3.setDeptHeadEmpId(e);
//		System.out.println(dd.updateDept(d3));
//		
		//System.out.println(dd.getAllDepts());
		//System.out.println(dd.deleteDept(202));
		
		//Employee e2 = new Employee(2, "Emily", "emily", "emily123", false, d2);
		//e2 = ed.addEmployee(e2);
		//Employee e3 = ed.getEmployeeById(2);
		
//		System.out.println(e3);
//		e3.setDept(d2);
//		ed.updateEmployee(e3);
		
		//System.out.println(dd.getAllDepts());
		
		//System.out.println(d1);
		
		//System.out.println(ed.getAllEmployees());
		
		//System.out.println(ed.getEmployeeById(1));
		
		//Employee emp = ed.getEmployeeByUsernamePassword(1);
		//System.out.println(emp);
		
		//Employee emp = ed.deleteEmployee(4);
		//System.out.println(emp);
		
		//System.out.println(ed.deleteEmployee(4));
		
//		Reimb rb = new Reimb(2,"nameRb333", 12, "Loc");
//		System.out.println(rd.addReimb(rb));
		
		//System.out.println(rd.getAllReimbs());
		
		//System.out.println(ed.getEmployeeByUsernamePassword("emma", "emma123"));
		
//		List<Reimb> allRs = rd.getAllReimbByEmpId(4);
//		
//		for(Reimb ob : allRs) {
//			System.out.println(ob);
//		}
		
//		List<Reimb> allRs = rd.getAllRequestsForApproval(1);
//		for(Reimb ob : allRs) {
//			System.out.println(ob);
//	}
//		Reimb rb1 =  rd.updateApprovals(39, 1);
//		System.out.println(rb1);
		
		Reimb rbDel = rd.deleteReimb(77);
		System.out.println(rbDel);
		
		
	}
	
	

}
