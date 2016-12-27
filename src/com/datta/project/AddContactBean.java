package com.datta.project;

public class AddContactBean {
	private String conname,email,ph,tag,dob,gender;

	public AddContactBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddContactBean(String conname, String email, String ph, String tag,
			String dob, String gender) {
		super();
		this.conname = conname;
		this.email = email;
		this.ph = ph;
		this.tag = tag;
		this.dob = dob;
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conname == null) ? 0 : conname.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((ph == null) ? 0 : ph.hashCode());
		result = prime * result + ((tag == null) ? 0 : tag.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddContactBean other = (AddContactBean) obj;
		if (conname == null) {
			if (other.conname != null)
				return false;
		} else if (!conname.equals(other.conname))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (ph == null) {
			if (other.ph != null)
				return false;
		} else if (!ph.equals(other.ph))
			return false;
		if (tag == null) {
			if (other.tag != null)
				return false;
		} else if (!tag.equals(other.tag))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AddContactBean [conname=" + conname + ", email=" + email
				+ ", ph=" + ph + ", tag=" + tag + ", dob=" + dob + ", gender="
				+ gender + "]";
	}

	public String getConname() {
		return conname;
	}

	public void setConname(String conname) {
		this.conname = conname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	// validation here...

	public String validate() {
		String msg="";
		if(conname==null||conname.trim().equals(""))
			msg=msg+" Contact name should not be null or blank boss ";
		if(email==null||email.trim().equals(""))
			msg=msg+" email kotra register madtiv pa ";
		if(ph==null||ph.trim().equals(""))
			msg=msg+" phone number kodu boss ";
		if(tag==null||tag.trim().equals(""))
			msg=msg+" Enter the tag ";
		if(dob==null||dob.trim().equals(""))
			msg=msg+" Give Your DateOfBirth ";
		if(gender==null||gender.trim().equals(""))
			msg=msg+" Select Yor GenderDude ";
		if(msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;
	}
	
	

}
