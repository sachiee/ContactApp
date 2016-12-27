package com.datta.project;

import java.io.Serializable;

public class RegBean implements Serializable{
	private String uname,email,pwd,rpwd;

	public RegBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegBean(String uname, String email, String pwd, String rpwd) {
		super();
		this.uname = uname;
		this.email = email;
		this.pwd = pwd;
		this.rpwd = rpwd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((rpwd == null) ? 0 : rpwd.hashCode());
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
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
		RegBean other = (RegBean) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (rpwd == null) {
			if (other.rpwd != null)
				return false;
		} else if (!rpwd.equals(other.rpwd))
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegBean [uname=" + uname + ", email=" + email + ", pwd=" + pwd
				+ ", rpwd=" + rpwd + "]";
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRpwd() {
		return rpwd;
	}

	public void setRpwd(String rpwd) {
		this.rpwd = rpwd;
	}

	public String validate() {
		String msg="";
		if(uname==null||uname.trim().equals(""))
			msg=msg+"name should not be null or blank boss";
		if(email==null||email.trim().equals(""))
			msg=msg+"email kotra register madtiv pa";
		if(pwd==null||pwd.trim().equals(""))
			msg=msg+"don,t you want to be secure huh?";
		if(!pwd.equalsIgnoreCase(rpwd))
			msg=msg+"retype same password";
		if(msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;
	}
	

}
