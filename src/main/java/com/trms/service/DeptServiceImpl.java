package com.trms.service;

import java.util.List; 

import com.trms.dao.DeptDao;
import com.trms.models.Dept;

public class DeptServiceImpl implements DeptService {
	
	DeptDao dao;
	
	public DeptServiceImpl(DeptDao dao) {
		this.dao = dao;
	}

	public Dept addDept(Dept dept) {
		return dao.addDept(dept);
	}

	public Dept getDeptById(int id) {
		return dao.getDeptById(id);
	}

	public Dept updateDept(Dept dept) {
		return dao.updateDept(dept);
	}

	public Dept deleteDept(int id) {
		return dao.deleteDept(id);
	}

	public List<Dept> getAllDepts() {
		return dao.getAllDepts();
	}

	@Override
	public int getDeptByDeptHeadId(int id) {
		return dao.getDeptByDeptHeadId(id);
	}
}
