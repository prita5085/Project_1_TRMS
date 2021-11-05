package com.trms.dao;

import java.util.List; 

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.trms.models.Dept;
import com.trms.util.HibernateUtil;

public class DeptDaoImpl implements DeptDao{

	@Override
	public Dept addDept(Dept dept) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			session.beginTransaction();
			dept.setDeptId((int)session.save(dept));
			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			 if(tx != null) 
	            	tx.rollback();
			return null;
		} finally {
			session.close();
		}
		return dept;
	}

	@Override
	public Dept getDeptById(int id) {
		Session session = HibernateUtil.getSession();
        Dept dept = null;
        try {
            dept = session.get(Dept.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return dept;
	}

	
	@Override
	public Dept updateDept(Dept dept) {
		Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(dept);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) 
            	tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return dept;
    }


	@Override
	public Dept deleteDept(int id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Dept d = null;
		try {
			tx = session.beginTransaction();
			d = session.get(Dept.class, id);
			session.delete(d);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tx != null) 
				tx.rollback();
		} finally {
			session.close();
		}
		return d;
	}

	@Override
	public List<Dept> getAllDepts() {
		Session session = HibernateUtil.getSession();
        List<Dept> actors = null;

        try {
            actors = session.createQuery("FROM Dept").list(); //HQL
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return actors;
	}
	
	//get deptId by dept head's id
	@Override
	public int getDeptByDeptHeadId(int id) {
		Session session = HibernateUtil.getSession();
         int deptId = 0;
        try {
            List<Dept> allDept = this.getAllDepts();
            for(Dept each : allDept) {
            	if(each.getDeptHead()==id) {
            		deptId = each.getDeptId();
            	}
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return deptId;
	}

	//SELECT * FROM actors
    //HQL - Hibernate Query Language - Hibernate wants to simplify any SQL you have to write by:
    // 1) Only having to reference you Java Classes
    // 2) Not having to adjust this code per each RDBMS.

}
