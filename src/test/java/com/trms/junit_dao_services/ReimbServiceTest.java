package com.trms.junit_dao_services;

import java.util.List;  

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.trms.dao.ReimbDao;
import com.trms.dao.ReimbDaoImpl;
import com.trms.models.Reimb;
import com.trms.service.ReimbService;
import com.trms.service.ReimbServiceImpl;


public class ReimbServiceTest {

		static ReimbDao dao = new ReimbDaoImpl();
		static ReimbService rs = new ReimbServiceImpl(dao);
		
		static Reimb createReimb;
		static Reimb updateReimb; 
		static Reimb getReimb;
		Reimb deleteReimb;
		static int newId;
		static int updatedNewRbId;


		@BeforeAll
		public static void setUp() throws Exception {
			createReimb = new Reimb (5, "Mary", 27, "maryland");
			updateReimb = new Reimb (5, "Mary", 27, "maryland");
		}

		@Test
		public void getAllReimbsTest() {
			List<Reimb> Reimbs = rs.getAllReimbs();
			
			Assertions.assertNotNull(Reimbs); //Makes sure that Reimbs is not null.
			Assertions.assertNotEquals(0, Reimbs.size());	
		}
		
		@Test
		public void A_createReimbTest() {
			
			Reimb createdReimb = rs.addReimb(createReimb);
			newId = createdReimb.getRbId();
			
			Reimb c1 = rs.getReimbById(newId);
			int id1 = c1.getRbId();
			
			Assertions.assertEquals(createdReimb.getRbId(), id1);
//			System.out.println(newId);
//			System.out.println(c1);
		}
		
		@Test
		public void C_getReimbByIdTest() {
			Reimb c3 = rs.getReimbById(32);
			Assertions.assertNotNull(c3);
		}
		
		
		@Test
		public void B_updateReimbTest() {
			Reimb ur_Test = rs.updateReimb(updateReimb);
			Reimb r2 = rs.getReimbById(ur_Test.getRbId());
			updatedNewRbId = ur_Test.getRbId();
			Assertions.assertEquals(ur_Test.getRbId(), r2.getRbId());
//			System.out.println(uc_Test);
//			System.out.println(c2);
		}

		@AfterAll
		public static void tearDown() throws Exception {
			System.out.println("newId" + newId);
			Reimb getRbWithId = rs.getReimbById(newId);
			Reimb r4 = rs.deleteReimb(newId);
			Reimb r5updated = rs.deleteReimb(updatedNewRbId);
			System.out.println("deleted " + newId);
			System.out.println("deleted" + updatedNewRbId);
		}

}
