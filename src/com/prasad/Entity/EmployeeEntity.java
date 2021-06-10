package com.prasad.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "EMPLOYEE_ENTITY")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empid;
	private String fName;
	private String lName;
	
	 @OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EMPLOYEE_PHONE", joinColumns = { @JoinColumn(name = "empid") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	private Set<PhoneEntity> setphonenos = new HashSet();

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Set<PhoneEntity> getSetphonenos() {
		return setphonenos;
	}

	public void setSetphonenos(Set<PhoneEntity> setphonenos) {
		this.setphonenos = setphonenos;
	}

	public EmployeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeEntity(String fName, String lName, Set<PhoneEntity> setphonenos) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.setphonenos = setphonenos;
	}

}
