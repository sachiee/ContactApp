package com.datta.project;

import java.io.Serializable;



public class LoginBean implements Serializable {
	private String email,pwd;

	public LoginBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginBean(String email, String pwd) {
		super();
		this.email = email;
		this.pwd = pwd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
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
		LoginBean other = (LoginBean) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "LoginBean [email=" + email + ", pwd=" + pwd + "]";
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

	public String validate() {
		String msg="";
		if(email==null||email.trim().equals(""))
			msg=msg+"Enter the email to login man";
		if(pwd==null||pwd.trim().equals(""))
			msg=msg+"enter your password oly pa";
		if(msg.equals(""))
			return Constants.SUCCESS;
		else
			return msg;
	}
	
	

}
