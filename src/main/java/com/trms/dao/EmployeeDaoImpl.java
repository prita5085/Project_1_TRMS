package com.trms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.trms.models.Employee;
import com.trms.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public Employee addEmployee(Employee employee) {
		Session session = HibernateUtil.getSession();
		try {
			session.beginTransaction();
			employee.setEmpId((int)session.save(employee));
			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return employee;
	}

	@Override
	public Employee getEmployeeById(int empId) {
			Session session = HibernateUtil.getSession();
	        Employee employee = null;
	        try {
	            employee = session.get(Employee.class, empId);
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	        return employee;
		}

	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(employee);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) 
            	tx.rollback();
            return null;
        } finally {
            session.close();
        }
		return employee;
	}

	@Override
	public Employee deleteEmployee(int id) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Employee employee = null;
		try {
			tx = session.beginTransaction();
			employee = session.get(Employee.class, id);
			session.delete(employee);
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			if(tx != null) 
				tx.rollback();
		} finally {
			session.close();
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = HibernateUtil.getSession();
        List<Employee> allEmployees = null;

        try {
            allEmployees = session.createQuery("FROM Employee").list(); //HQL
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return allEmployees;
	}

	@Override
	public Employee getEmployeeByUsernamePassword(String username, String password) {
		Session session = HibernateUtil.getSession();
		Employee employee = null;
	        try  {
	            Criteria crit = session.createCriteria(Employee.class);
	            crit.add(Restrictions.eq("username", username));
	            crit.add(Restrictions.eq("pwd", password));

	            employee = (Employee) crit.uniqueResult();
	            return employee;
	        } catch (HibernateException e) {
	            e.printStackTrace();
	        }
	        return null;
	}

	
	
}
