package com.trms.dao;

import java.util.List;

import com.trms.models.Dept;

public interface DeptDao {
	
	public Dept addDept(Dept dept);
	public Dept getDeptById(int id);
	public Dept updateDept(Dept dept);
	public Dept deleteDept(int id);
	public List<Dept> getAllDepts(); 
	public int getDeptByDeptHeadId(int id);
    
}
