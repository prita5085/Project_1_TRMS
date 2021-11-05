package com.trms.dao;

import java.util.ArrayList; 
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.trms.models.Dept;
import com.trms.models.Employee;
import com.trms.models.Reimb;
import com.trms.service.DeptService;
import com.trms.service.DeptServiceImpl;
import com.trms.service.EmployeeService;
import com.trms.service.EmployeeServiceImpl;
import com.trms.util.HibernateUtil;

public class ReimbDaoImpl implements ReimbDao{
	
	EmployeeDao ed = new EmployeeDaoImpl();
	EmployeeService es = new EmployeeServiceImpl(ed);
	DeptDao dd = new DeptDaoImpl();
	DeptService ds = new DeptServiceImpl(dd);
	

	@Override
	public Reimb addReimb(Reimb reimb) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			session.beginTransaction();
			reimb.setRbId((int)session.save(reimb));
			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			 if(tx != null) 
	         tx.rollback();
			return null;
		} finally {
			session.close();
		}
		return reimb;
	}

	@Override
	public Reimb getReimbById(int id) {
		Session session = HibernateUtil.getSession();
		Reimb reimb = null;
        try {
            reimb = session.get(Reimb.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reimb;
	}

	@Override
	public Reimb updateReimb(Reimb reimb) {
		Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(reimb);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) 
            	tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return reimb;
	}

	@Override
	public Reimb deleteReimb(int id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Reimb reimb = null;
		try {
			tx = session.beginTransaction();
			reimb = session.get(Reimb.class, id);
			session.delete(reimb);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tx != null) 
				tx.rollback();
		} finally {
			session.close();
		}
		return reimb;
	}

	@Override
	public List<Reimb> getAllReimbs() {
		Session session = HibernateUtil.getSession();
        List<Reimb> allReimbs = null;

        try {
            allReimbs = session.createQuery("FROM Reimb").list(); //HQL
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return allReimbs;
	}
	
	//get all of my requests for reimb - all my requests
	@Override
	public List<Reimb> getAllReimbByEmpId(int empId) {
		Session session = HibernateUtil.getSession();
		List<Reimb> reimbsByEmpId = new ArrayList<Reimb>();
        try {
            List<Reimb> allReimbs = session.createQuery("FROM Reimb").list();
            for(Reimb ob : allReimbs) {
            	if(ob.getRbEmpId()==empId) {
            		reimbsByEmpId.add(ob);
            	}
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reimbsByEmpId;
	}
	
	//get all requests of my employees that needs my approval - all the ones I need to take action on
	@Override
	public List<Reimb> getAllRequestsForApproval(int empId) {
			Session session = HibernateUtil.getSession();
			List<Reimb> allReimbOfMyEmps = new ArrayList<Reimb>();
			int deptId = 0;
			List<Employee> allEmps = es.getAllEmployees();
	        try {
	        	deptId = ds.getDeptByDeptHeadId(empId);
	        	List<Integer> allMyEmpsId = new ArrayList<Integer>();
	        	
	        	Employee emp = es.getEmployeeById(empId);
	        	if(emp.isBenCo()==true) {
	        			for(Employee each : allEmps) {
	        				allMyEmpsId.add(each.getEmpId());
	        			}
	        		
	        	}
	        	for(Employee each : allEmps) {
	        		if(each.getSup()!= null) {
	        			if(each.getSup().getEmpId()==empId) {
	        				allMyEmpsId.add(each.getEmpId());
	        			}
	        		}
	        		if(deptId !=0) {
	        			if(each.getDept().getDeptId()==deptId) {
	        				allMyEmpsId.add(each.getEmpId());
	        			}
	        		}
	        		
	        	}
	        	List<Reimb> allReimb = this.getAllReimbs();
	        	
	        	for(Reimb each : allReimb) {
	        		for(int i=0; i<allMyEmpsId.size(); i++) {
	        			if(each.getRbEmpId()==allMyEmpsId.get(i) && each.getRbEmpId() != empId) {
	        				allReimbOfMyEmps.add(each);
	        			}
	        		}
	        	}
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return allReimbOfMyEmps;
		}
	
	//update approval from sup/head/benCo 
	@Override
	public Reimb updateApprovals(int rbId, int ApproversEmpId) {
		Reimb reimbApp = this.getReimbById(rbId);
		Session session = HibernateUtil.getSession();
        Transaction tx = null;
        int requestorsEmpId = 0;
        try {
        	requestorsEmpId = reimbApp.getRbEmpId();
        	Employee reqEmpOb = es.getEmployeeById(requestorsEmpId);
        		if(reqEmpOb.getSup() != null) {
        			if(reqEmpOb.getSup().getEmpId()==ApproversEmpId) {
        				reimbApp.setSupApproval("Approved");
        				reimbApp.setStatus("Pending");
        			}else if (reqEmpOb.getDept().getDeptHead()==ApproversEmpId){
        				reimbApp.setDeptHeadApproval("Approved");
        				reimbApp.setStatus("Pending");
        			} else {
        	    	 reimbApp.setBenCoApproval("Approved");
        	    	 reimbApp.setStatus("Pending for grade / presentation");
        			}
        		}
            tx = session.beginTransaction();
            session.update(reimbApp);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) 
            	tx.rollback();
            return null;
        } finally {
            session.close();
        }
        return reimbApp;
	}
	
	//final approval/confirmation from BenCo
	@Override
	public Reimb confirm(int rbId, int ApproversEmpId) {
		Reimb reimbApp = this.getReimbById(rbId);
		Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
        	Employee appEmpOb = es.getEmployeeById(ApproversEmpId);
        			if(appEmpOb.isBenCo()) {
        				reimbApp.setBenCoConfirm("Approved");
        				reimbApp.setStatus("Confirmed");
        				reimbApp.setAwardedAmount(1000);
        			}
            tx = session.beginTransaction();
            session.update(reimbApp);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) 
            	tx.rollback();
            return null;
        } finally {
            session.close();
        }
        return reimbApp;
	}
	
	
	@Override
	public Reimb upload(int rbId) {
		Reimb reimbUploadGrade = this.getReimbById(rbId);
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			reimbUploadGrade.setGrade("B");
			tx = session.beginTransaction();
			session.update(reimbUploadGrade);
            tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			 if(tx != null) 
	            	tx.rollback();
		} finally {
			session.close();
		}
		return reimbUploadGrade;
	}
	
	@Override
	public Reimb moreInfo(int rbId) {
		Reimb reimb = this.getReimbById(rbId);
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			reimb.setStatus("Additional Info Req");
			tx = session.beginTransaction();
			session.update(reimb);
            tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			 if(tx != null) 
	            	tx.rollback();
		} finally {
			session.close();
		}
		return reimb;
	}
	
	//additional info required
//	@Override
//	public Reimb upload(int rbId) { 
//		Reimb reimbUploadGrade = this.getReimbById(rbId);
//		Session session = HibernateUtil.getSession();
//		Transaction tx = null;
//		try {
//			reimbUploadGrade.setGrade("B");
//			tx = session.beginTransaction();
//			session.update(reimbUploadGrade);
//            tx.commit();
//		}catch(HibernateException e) {
//			e.printStackTrace();
//			 if(tx != null) 
//	            	tx.rollback();
//		} finally {
//			session.close();
//		}
//		return reimbUploadGrade;
//	}
	
	//upload file
	@Override
	public Reimb uploadFile(int rbId, String fileName) {
		Reimb reimb = this.getReimbById(rbId);
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			reimb.setFile(fileName);
			tx = session.beginTransaction();
			session.update(reimb);
            tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			 if(tx != null) 
	            	tx.rollback();
		} finally {
			session.close();
		}
		return reimb;
	}
	
//	@Override
//	public Reimb upload(String grade, int rbId) {
//		Reimb reimbUploadGrade = this.getReimbById(rbId);
//		Session session = HibernateUtil.getSession();
//		Transaction tx = null;
//		try {
//			reimbUploadGrade.setGrade(grade);
//			tx = session.beginTransaction();
//			session.update(reimbUploadGrade);
//			session.commit();
//		}catch(HibernateException e) {
//			e.printStackTrace();
//			 if(tx != null) 
//	            	tx.rollback();
//		} finally {
//			session.close();
//		}
//		return reimbUploadGrade;
//	} 
}
