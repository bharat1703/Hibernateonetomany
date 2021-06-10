package com.prasad.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "PHONE_ENTITY")
public class PhoneEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String phonetype;
	private String phoneno;

	public String getPhonetype() {
		return phonetype;
	}

	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public PhoneEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PhoneEntity(String phonetype, String phoneno) {
		super();
		this.phonetype = phonetype;
		this.phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "PhoneEntity [id=" + id + ", phonetype=" + phonetype + ", phoneno=" + phoneno + "]";
	}


}
