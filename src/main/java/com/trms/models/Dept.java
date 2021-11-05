package com.trms.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import net.bytebuddy.build.ToStringPlugin.Exclude;

@Entity
public class Dept {
	
	@Id
	@Column(name="dept_id")
	private int deptId;
	
	@Column(name="dept_name")
	private String deptName;
	
	@Column(name = "dept_head_id")
	private int deptHead;
	
	public Dept() {}

	public Dept(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}
	
	public Dept(int deptId, int deptHead) {
		super();
		this.deptId = deptId;
		this.deptHead = deptHead;
	}

	public Dept(int deptId, String deptName, int deptHead) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptHead = deptHead;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public int getDeptHead() {
		return deptHead;
	}

	public void setDeptHead(int deptHead) {
		this.deptHead = deptHead;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(deptHead, deptId, deptName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dept other = (Dept) obj;
		return Objects.equals(deptHead, other.deptHead) && deptId == other.deptId
				&& Objects.equals(deptName, other.deptName);
	}
	
}
	