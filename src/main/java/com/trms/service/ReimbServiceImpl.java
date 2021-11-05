package com.trms.service;

import java.util.List;

import com.trms.dao.ReimbDao;
import com.trms.models.Reimb;

public class ReimbServiceImpl implements ReimbService {
	
	ReimbDao dao;
	
	public ReimbServiceImpl(ReimbDao dao) {
		this.dao = dao;
	}

	@Override
	public Reimb addReimb(Reimb reimb) {
		return dao.addReimb(reimb);
	}

	@Override
	public Reimb getReimbById(int id) {
		return dao.getReimbById(id);
	}

	@Override
	public Reimb updateReimb(Reimb reimb) {
		return dao.updateReimb(reimb);
	}

	@Override
	public Reimb deleteReimb(int id) {
		return dao.deleteReimb(id);
	}

	@Override
	public List<Reimb> getAllReimbs() {
		return dao.getAllReimbs();
	}

	@Override
	public List<Reimb> getAllReimbByEmpId(int empId) {
		return dao.getAllReimbByEmpId(empId);
	}

	@Override
	public List<Reimb> getAllRequestsForApproval(int empId) {
		return dao.getAllRequestsForApproval(empId);
	}

	@Override
	public Reimb updateApprovals(int rbId, int ApproversEmpId) {
		return dao.updateApprovals(rbId, ApproversEmpId);
	}

	@Override
	public Reimb upload(int rbId) {
		return dao.upload(rbId);
		
	}

	@Override
	public Reimb confirm(int rbId, int ApproversEmpId) {
		return dao.confirm(rbId, ApproversEmpId);
	}

	@Override
	public Reimb uploadFile(int rbId, String fileName) {
		return dao.uploadFile(rbId, fileName);
	}

	@Override
	public Reimb moreInfo(int rbId) {
		return dao.moreInfo(rbId);
	}

	
	
}
