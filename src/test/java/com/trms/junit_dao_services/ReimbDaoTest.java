package com.trms.junit_dao_services;

import java.util.List;  

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.trms.dao.ReimbDao;
import com.trms.dao.ReimbDaoImpl;
import com.trms.models.Reimb;


public class ReimbDaoTest {

	static ReimbDao dao = new ReimbDaoImpl();
	
	static Reimb addReimb1;
	static Reimb addReimb2;
	static Reimb updateReimb; 
	static Reimb getReimb;
	static Reimb deleteReimb;
	static int newId;
	static int updatedNewRbId;
	
	@BeforeAll
	public static void setUp() throws Exception {
		addReimb1 = new Reimb (5, "Mary", 27, "maryland");
	}
	
	
	@Test
	public void E_getAllReimbTest() {
		List<Reimb> allReimbs = dao.getAllReimbs();
		
		Assertions.assertNotNull(allReimbs); //Makes sure that reimbs is not null.
		Assertions.assertNotEquals(0, allReimbs.size());	
	}
	
	@Test
	public void A_addReimbTest() {
		Reimb createdReimb = dao.addReimb(addReimb1); 
		newId = createdReimb.getRbId(); //find Id of newly created req/ob in DB
		
		Reimb r1 = dao.getReimbById(newId);
		int id1 = r1.getRbId(); //find DB and find that req with this Id that was just created
		
		Assertions.assertEquals(newId, id1); //match Id created with Id that is in DB
		System.out.println("this is new Rb Id created" + newId);
		System.out.println("this is r1 that I got after created" + r1);
		
	}
	
	@Test
	public void e_updateReimbTest() {
		System.out.println("Id to update: what is in newId here" + newId);
		updateReimb = new Reimb (newId, 5, "Mary", 3, "LA");
		Reimb updateReimb_Test = dao.updateReimb(updateReimb); //new one was created first then updated
		updatedNewRbId = updateReimb.getRbId();
		System.out.println(updatedNewRbId);
		Reimb r2 = dao.getReimbById(updateReimb_Test.getRbId());
		
		Assertions.assertEquals(updateReimb_Test.getRbId(), r2.getRbId());
		System.out.println("updated" + updateReimb_Test);
		System.out.println("updated" + r2);
	}
	
	@Test
	public void c_getReimbByIdTest() {
		Reimb r3 = dao.getReimbById(32);
		Assertions.assertNotNull(r3);
	}
	
	
	@AfterAll
	public static void tearDown() throws Exception {
		System.out.println("what is newRbId" + newId);
		Reimb getRbWithId = dao.getReimbById(newId);
		Reimb r4 = dao.deleteReimb(newId);
		Reimb r5updated = dao.deleteReimb(updatedNewRbId);
		System.out.println("deleted " + newId);
		System.out.println("deleted" + updatedNewRbId);
	}
	
	
}
