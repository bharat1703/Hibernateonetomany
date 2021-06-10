package com.prasad.Dao;

import com.prasad.Entity.EmployeeEntity;

public interface EmployeeDao {
	void saveemp(EmployeeEntity empen); 
	boolean updateemp(EmployeeEntity empobj);
	boolean deleteemp(EmployeeEntity empobj);
	EmployeeEntity getdetails(String fName);
}
