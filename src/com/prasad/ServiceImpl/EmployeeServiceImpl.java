package com.prasad.ServiceImpl;

import java.util.HashSet;
import java.util.Set;

import com.prasad.DaoImpl.EmployeeDaoImpl;
import com.prasad.Entity.EmployeeEntity;
import com.prasad.Entity.PhoneEntity;
import com.prasad.Service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDaoImpl empdao = new EmployeeDaoImpl();

	public void saveemp(String fName, String lName) {
		Set<PhoneEntity> obj = new HashSet();
		PhoneEntity phen1 = new PhoneEntity("Androd", "9581502085");
		 PhoneEntity phen2=new PhoneEntity("keypad","9247788446");
		obj.add(phen1);
		obj.add(phen2);

		EmployeeEntity empen = new EmployeeEntity(fName, lName, obj);
		empdao.saveemp(empen);

	}

	public void updateemp(String fName, String lName) {
		// Now i want to update the lName based on the fName
		// so first of all we need to get the details of person
		EmployeeEntity empobj = empdao.getdetails(fName);
		if (empobj != null) {
			String oldfirstname = empobj.getfName();
			empobj.setlName(lName);
	//Here we can only update lName for phone we can write another code 
			//	Set<PhoneEntity> phonenoupdate	= empobj.getSetphonenos();
			
		/*	Set<PhoneEntity> obj = new HashSet();
			PhoneEntity phen1 = new PhoneEntity("samsung", "0000000000");
			 PhoneEntity phen2=new PhoneEntity("nokia","0000000000");
			 obj.add(phen1);
			 obj.add(phen2);
				empobj.setSetphonenos(obj);*/
						boolean recordUpdated = empdao.updateemp(empobj);
				if(recordUpdated) {
					System.out.println("Emp details have been updated for given emp First Name :"+fName+", Emp Last Name :"+lName);
					System.out.println("Emp name has been updated from :"+oldfirstname+" to :"+lName);
				}
		}

	}

	public void deleteemp(String fName) {
	//Here we can delete the emp details by using the fName
		// so first of all we need to get the details of person
		EmployeeEntity empobj = empdao.getdetails(fName);
		if (empobj != null) {
			String firstname = empobj.getfName();
			boolean recordUpdated = empdao.deleteemp(empobj);
		System.out.println("the deatails for the emp "+firstname+"have been deleting sucessfully");
		}
		
	}

}
