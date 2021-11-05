package com.trms.models;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Reimb {
	
	@Id
	@GeneratedValue
	@Column(name="rb_id")
	private int rbId;
	
	@Column(name="rb_emp_id")
	private int rbEmpId;
	
	@Column(name="rb_name")
	private String rbName;
	
	@Column(name="rb_date")
	private int rbDate;
	
	@Column(name="rb_time")
	private int rbTime;
	
	@Column(name="rb_loc")
	private String rbLoc;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="rb_event_id")
	private Event rbEventId;
	
	@Column(name="rb_grd_for")
	private String rbGrdFor;
	
	@Column(name="rb_cost")
	private int rbCost;
	
	@Column(name="rb_desc")
	private String rbDesc;
	
	@Column(name="rb_wrj")
	private String rbWRJ;
	
	@Column(name="status")
	private String status = "Submitted";
	
	@Column(name="sup_approval")
	private String supApproval = "Req";
	
	@Column(name="dept_head_approval")
	private String deptHeadApproval = "Req";
	
	@Column(name="ben_co_approval")
	private String benCoApproval = "Req";
	
	@Column(name="ben_co_confirm")
	private String benCoConfirm = "Req";
	
	@Column(name="awarded_amount")
	private int awardedAmount;
	
	@Column(name = "grade")
	private String grade;
	
	@Column(name = "file")
	private String file;
	
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Reimb() { }
	
	public Reimb(int rbEmpId, String rbName, int rbDate, int rbTime, String rbLoc, Event rbEventId,
			String rbGrdFor, int rbCost, String rbDesc, String rbWRJ, String status, String supApproval,
			String deptHeadApproval, String benCoApproval, String benCoConfirm, int awardedAmount) {
		super();
		this.rbEmpId = rbEmpId;
		this.rbName = rbName;
		this.rbDate = rbDate;
		this.rbTime = rbTime;
		this.rbLoc = rbLoc;
		this.rbEventId = rbEventId;
		this.rbGrdFor = rbGrdFor;
		this.rbCost = rbCost;
		this.rbDesc = rbDesc;
		this.rbWRJ = rbWRJ;
		this.status = status;
		this.supApproval = supApproval;
		this.deptHeadApproval = deptHeadApproval;
		this.benCoApproval = benCoApproval;
		this.benCoConfirm = benCoConfirm;
		this.awardedAmount = awardedAmount;
	}
	
	public Reimb(int rbId, int rbEmpId, String rbName, int rbDate, int rbTime, String rbLoc, Event rbEventId,
			String rbGrdFor, int rbCost, String rbDesc, String rbWRJ, String status, String supApproval,
			String deptHeadApproval, String benCoApproval, String benCoConfirm, int awardedAmount) {
		super();
		this.rbId = rbId;
		this.rbEmpId = rbEmpId;
		this.rbName = rbName;
		this.rbDate = rbDate;
		this.rbTime = rbTime;
		this.rbLoc = rbLoc;
		this.rbEventId = rbEventId;
		this.rbGrdFor = rbGrdFor;
		this.rbCost = rbCost;
		this.rbDesc = rbDesc;
		this.rbWRJ = rbWRJ;
		this.status = status;
		this.supApproval = supApproval;
		this.deptHeadApproval = deptHeadApproval;
		this.benCoApproval = benCoApproval;
		this.benCoConfirm = benCoConfirm;
		this.awardedAmount = awardedAmount;
	}


	public Reimb(int rbEmpId, String rbName, int rbDate, String rbLoc) {
		super();
		this.rbEmpId = rbEmpId;
		this.rbName = rbName;
		this.rbDate = rbDate;
		this.rbLoc = rbLoc;
	}
	
	public Reimb(int rbId, int rbEmpId, String rbName, int rbDate, String rbLoc) {
		super();
		this.rbId = rbId;
		this.rbEmpId = rbEmpId;
		this.rbName = rbName;
		this.rbDate = rbDate;
		this.rbLoc = rbLoc;
	}


	public Reimb(int rbEmpId, String rbName, int rbDate, int rbTime, String rbLoc, Event rbEventId,
			String rbGrdFor, int rbCost, String rbDesc, String rbWRJ) {
		super();
		this.rbEmpId = rbEmpId;
		this.rbName = rbName;
		this.rbDate = rbDate;
		this.rbTime = rbTime;
		this.rbLoc = rbLoc;
		this.rbEventId = rbEventId;
		this.rbGrdFor = rbGrdFor;
		this.rbCost = rbCost;
		this.rbDesc = rbDesc;
		this.rbWRJ = rbWRJ;
		this.status = status;
		this.supApproval = supApproval;
		this.deptHeadApproval = deptHeadApproval;
		this.benCoApproval = benCoApproval;
		this.awardedAmount = awardedAmount;
	}
	

	public Reimb(int rbEmpId, String rbName, int rbDate, int rbTime, String rbLoc, Event rbEventId, String rbGrdFor,
			int rbCost, String rbDesc, String rbWRJ, String status, String supApproval, String deptHeadApproval,
			String benCoApproval, String benCoConfirm, int awardedAmount, String grade) {
		super();
		this.rbEmpId = rbEmpId;
		this.rbName = rbName;
		this.rbDate = rbDate;
		this.rbTime = rbTime;
		this.rbLoc = rbLoc;
		this.rbEventId = rbEventId;
		this.rbGrdFor = rbGrdFor;
		this.rbCost = rbCost;
		this.rbDesc = rbDesc;
		this.rbWRJ = rbWRJ;
		this.status = status;
		this.supApproval = supApproval;
		this.deptHeadApproval = deptHeadApproval;
		this.benCoApproval = benCoApproval;
		this.benCoConfirm = benCoConfirm;
		this.awardedAmount = awardedAmount;
		this.grade = grade;
	}
	
	public Reimb(int rbEmpId, String rbName, int rbDate, int rbTime, String rbLoc, Event rbEventId,
			String rbGrdFor, int rbCost, String rbDesc, String rbWRJ, String status, String supApproval,
			String deptHeadApproval, String benCoApproval, int awardedAmount) {
		this.rbEmpId = rbEmpId;
		this.rbName = rbName;
		this.rbDate = rbDate;
		this.rbTime = rbTime;
		this.rbLoc = rbLoc;
		this.rbEventId = rbEventId;
		this.rbGrdFor = rbGrdFor;
		this.rbCost = rbCost;
		this.rbDesc = rbDesc;
		this.rbWRJ = rbWRJ;
		this.status = status;
		this.supApproval = supApproval;
		this.deptHeadApproval = deptHeadApproval;
		this.benCoApproval = benCoApproval;
		this.awardedAmount = awardedAmount;
	}

	public int getRbId() {
		return rbId;
	}

	public void setRbId(int rbId) {
		this.rbId = rbId;
	}

	public int getRbEmpId() {
		return rbEmpId;
	}

	public void setRbEmpId(int rbEmpId) {
		this.rbEmpId = rbEmpId;
	}

	public String getRbName() {
		return rbName;
	}

	public void setRbName(String rbName) {
		this.rbName = rbName;
	}

	public int getRbDate() {
		return rbDate;
	}

	public void setRbDate(int rbDate) {
		this.rbDate = rbDate;
	}

	public int getRbTime() {
		return rbTime;
	}

	public void setRbTime(int rbTime) {
		this.rbTime = rbTime;
	}

	public String getRbLoc() {
		return rbLoc;
	}

	public void setRbLoc(String rbLoc) {
		this.rbLoc = rbLoc;
	}

	public Event getRbEventId() {
		return rbEventId;
	}

	public void setRbEventId(Event rbEventId) {
		this.rbEventId = rbEventId;
	}

	public String getRbGrdFor() {
		return rbGrdFor;
	}

	public void setRbGrdFor(String rbGrdFor) {
		this.rbGrdFor = rbGrdFor;
	}

	public int getRbCost() {
		return rbCost;
	}

	public void setRbCost(int rbCost) {
		this.rbCost = rbCost;
	}

	public String getRbDesc() {
		return rbDesc;
	}

	public void setRbDesc(String rbDesc) {
		this.rbDesc = rbDesc;
	}

	public String getRbWRJ() {
		return rbWRJ;
	}

	public void setRbWRJ(String rbWRJ) {
		this.rbWRJ = rbWRJ;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSupApproval() {
		return supApproval;
	}

	public void setSupApproval(String supApproval) {
		this.supApproval = supApproval;
	}

	public String getDeptHeadApproval() {
		return deptHeadApproval;
	}

	public void setDeptHeadApproval(String deptHeadApproval) {
		this.deptHeadApproval = deptHeadApproval;
	}

	public String getBenCoApproval() {
		return benCoApproval;
	}

	public void setBenCoApproval(String benCoApproval) {
		this.benCoApproval = benCoApproval;
	}

	
	public String getBenCoConfirm() {
		return benCoConfirm;
	}
	public void setBenCoConfirm(String benCoConfirm) {
		this.benCoConfirm = benCoConfirm;
	}
	public int getAwardedAmount() {
		return awardedAmount;
	}

	public void setAwardedAmount(int awardedAmount) {
		this.awardedAmount = awardedAmount;
	}
	
	@Override
	public String toString() {
		return "Reimb [rbId=" + rbId + ", rbEmpId=" + rbEmpId + ", rbName=" + rbName + ", rbDate=" + rbDate
				+ ", rbTime=" + rbTime + ", rbLoc=" + rbLoc + ", rbEventId=" + rbEventId + ", rbGrdFor=" + rbGrdFor
				+ ", rbCost=" + rbCost + ", rbDesc=" + rbDesc + ", rbWRJ=" + rbWRJ + ", status=" + status
				+ ", supApproval=" + supApproval + ", deptHeadApproval=" + deptHeadApproval + ", benCoApproval="
				+ benCoApproval + ", benCoConfirm=" + benCoConfirm + ", awardedAmount=" + awardedAmount + ", grade="
				+ grade + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(awardedAmount, benCoApproval, benCoConfirm, deptHeadApproval, grade, rbCost, rbDate, rbDesc,
				rbEmpId, rbEventId, rbGrdFor, rbId, rbLoc, rbName, rbTime, rbWRJ, status, supApproval);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimb other = (Reimb) obj;
		return awardedAmount == other.awardedAmount && Objects.equals(benCoApproval, other.benCoApproval)
				&& Objects.equals(benCoConfirm, other.benCoConfirm)
				&& Objects.equals(deptHeadApproval, other.deptHeadApproval) && Objects.equals(grade, other.grade)
				&& rbCost == other.rbCost && rbDate == other.rbDate && Objects.equals(rbDesc, other.rbDesc)
				&& rbEmpId == other.rbEmpId && Objects.equals(rbEventId, other.rbEventId)
				&& Objects.equals(rbGrdFor, other.rbGrdFor) && rbId == other.rbId && Objects.equals(rbLoc, other.rbLoc)
				&& Objects.equals(rbName, other.rbName) && rbTime == other.rbTime && Objects.equals(rbWRJ, other.rbWRJ)
				&& Objects.equals(status, other.status) && Objects.equals(supApproval, other.supApproval);
	}

	




	
	
	
}
