package com.trms.service;

import java.util.List;

import com.trms.models.Reimb;

public interface ReimbService {
	
	public Reimb addReimb(Reimb reimb);
	public Reimb getReimbById(int id);
	public Reimb updateReimb(Reimb reimb);
	public Reimb deleteReimb(int id);
	public List<Reimb> getAllReimbs();
	
	public List<Reimb> getAllReimbByEmpId(int empId);
	
	public List<Reimb> getAllRequestsForApproval(int empId);
	
	public Reimb updateApprovals(int rbId, int ApproversEmpId);
	
	public Reimb upload(int rbId);
	
	public Reimb confirm(int rbId, int ApproversEmpId);
	
	public Reimb uploadFile(int rbId, String fileName);
	public Reimb moreInfo(int rbId);
}
