package com.trms.service;

import java.util.List; 

import com.trms.models.Dept;

public interface DeptService {
	
	public Dept addDept(Dept dept);
	public Dept getDeptById(int id);
	public Dept updateDept(Dept dept);
	public Dept deleteDept(int id);
	public List<Dept> getAllDepts();
	public int getDeptByDeptHeadId(int id);
}
