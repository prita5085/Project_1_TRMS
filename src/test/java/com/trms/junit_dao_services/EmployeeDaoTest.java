package com.trms.junit_dao_services;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.trms.dao.EmployeeDao;
import com.trms.dao.EmployeeDaoImpl;
import com.trms.models.Employee;

public class EmployeeDaoTest {

		static EmployeeDao dao = new EmployeeDaoImpl();
		
		static Employee addEmployee;
		static Employee updateEmployee; 
		static Employee getEmployee;
		static Employee deleteEmployee;
		static int newId;
		static int updatedNewEmpId;
		
		@BeforeAll
		public static void setUp() throws Exception {
			addEmployee = new Employee ("Mary", "mary", "mary123", false);
		}
		
		
		@Test
		public void E_getAllEmployeeTest() {
			List<Employee> allEmployees = dao.getAllEmployees();
			
			Assertions.assertNotNull(allEmployees); //Makes sure that Employees is not null.
			Assertions.assertNotEquals(0, allEmployees.size());	
		}
		
		@Test
		public void A_addEmployeeTest() {
			Employee createdEmployee = dao.addEmployee(addEmployee); 
			newId = createdEmployee.getEmpId(); //find Id of newly created req/ob in DB
			
			Employee r1 = dao.getEmployeeById(newId);
			int id1 = r1.getEmpId(); //find DB and find that req with this Id that was just created
			
			Assertions.assertEquals(newId, id1); //match Id created with Id that is in DB
			System.out.println("this is new Rb Id created" + newId);
			System.out.println("this is r1 that I got after created" + r1);
			
		}
		
		@Test
		public void e_updateEmployeeTest() {
			System.out.println(newId);
			updateEmployee = new Employee (newId, "Mari", "mary", "mary123", false);
			Employee updateEmployee_Test = dao.updateEmployee(updateEmployee); //new one was created first then updated
			updatedNewEmpId = updateEmployee.getEmpId();
			System.out.println(updatedNewEmpId);
			Employee r2 = dao.getEmployeeById(updateEmployee_Test.getEmpId());
			
			Assertions.assertEquals(updateEmployee_Test.getEmpId(), r2.getEmpId());
			System.out.println("updated" + updateEmployee_Test);
			System.out.println("updated" + r2);
		}
		
		@Test
		public void c_getEmployeeByIdTest() {
			Employee r3 = dao.getEmployeeById(1);
			Assertions.assertNotNull(r3);
		}
		
		
		@AfterAll
		public static void tearDown() throws Exception {
			System.out.println("what is newEmpId" + newId);
			Employee getEmpWithId = dao.getEmployeeById(newId);
			Employee r4 = dao.deleteEmployee(newId);
			Employee r5updated = dao.deleteEmployee(updatedNewEmpId);
			System.out.println("deleted " + newId);
			System.out.println("deleted" + updatedNewEmpId);
		}

}
