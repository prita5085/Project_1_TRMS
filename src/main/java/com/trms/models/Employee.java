package com.trms.models;

import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Employee {  

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="username")
	private String username;
	
	@Column(name="pwd")
	private String pwd;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sup")
	private Employee sup;
	
	@Column(name="ben_co")
	private boolean benCo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dept_id")
	private Dept dept;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "rb_emp_id")
	private List<Reimb> reimbs;

	public Employee() {
		super();
	}
	
	
	public Employee(int empId, String empName, String username, String pwd, Employee sup, boolean benCo, Dept dept,
			List<Reimb> reimbs) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.username = username;
		this.pwd = pwd;
		this.sup = sup;
		this.benCo = benCo;
		this.dept = dept;
		this.reimbs = reimbs;
	}

	
	public Employee(String empName, String username, String pwd, boolean benCo) {
		super();
		this.empName = empName;
		this.username = username;
		this.pwd = pwd;
		this.benCo = benCo;
	}

	public Employee(int empId, String empName, String username, String pwd, boolean benCo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.username = username;
		this.pwd = pwd;
		this.benCo = benCo;
	}
	
	
	public Employee(String empName, String username, String pwd, Employee sup, boolean benCo, Dept dept) {
		super();
		this.empName = empName;
		this.username = username;
		this.pwd = pwd;
		this.sup = sup;
		this.benCo = benCo;
		this.dept = dept;
	}

	public Employee(String empName, String username, String pwd, Dept dept) {
		super();
		this.empName = empName;
		this.username = username;
		this.pwd = pwd;
		this.dept = dept;
	}
	
	

	public Employee(int empId, String empName, String username, String pwd, Employee sup, boolean benCo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.username = username;
		this.pwd = pwd;
		this.sup = sup;
		this.benCo = benCo;
	}
	
	

	public Employee(int empId, String empName, String username, String pwd, Employee sup, boolean benCo, Dept dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.username = username;
		this.pwd = pwd;
		this.sup = sup;
		this.benCo = benCo;
		this.dept = dept;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Employee getSup() {
		return sup;
	}

	public void setSup(Employee sup) {
		this.sup = sup;
	}

	public List<Reimb> getReimbs() {
		return reimbs;
	}

	public void setReimbs(List<Reimb> reimbs) {
		this.reimbs = reimbs;
	}

	public boolean isBenCo() {
		return benCo;
	}

	public void setBenCo(boolean benCo) {
		this.benCo = benCo;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", username=" + username + ", pwd=" + pwd
				+ ", sup=" + sup + ", benCo=" + benCo + ", dept=" + dept + ", reimbs=" + reimbs + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(benCo, dept, empId, empName, pwd, reimbs, sup, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return benCo == other.benCo && Objects.equals(dept, other.dept) && empId == other.empId
				&& Objects.equals(empName, other.empName) && Objects.equals(pwd, other.pwd)
				&& Objects.equals(reimbs, other.reimbs) && Objects.equals(sup, other.sup)
				&& Objects.equals(username, other.username);
	}


	
	


}