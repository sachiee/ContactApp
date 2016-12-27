package com.datta.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Model {
	
	
	

	public String register(RegBean rb) {
		System.out.println("in model register()");
		String result=rb.validate();
		if(result.equals(Constants.SUCCESS))
		{
			// i/p validations successed...
			//perform businesss validation...
			Connection con=null;
			PreparedStatement ps_sel=null;
			PreparedStatement ps_ins=null;
			ResultSet rs=null;
			try
			{
				con=JDBCHelper.getConnection();
				if(con==null)
				{
					return "Oops Connection not established";
				}
				else
				{
					// now do business logic...
					String sql="select * from register where email=?";
					ps_sel=con.prepareStatement(sql);
					ps_sel.setString(1,rb.getEmail());
					ps_sel.execute();
					rs=ps_sel.getResultSet();
					if(rs.next())
					{
						System.out.println("email is duplicate...");
						return "you are alredy registered .";
					}
					else
					{
					 sql="insert into register(name,email,password)values(?,?,?)";
					 ps_ins=con.prepareStatement(sql);
					 ps_ins.setString(1,rb.getUname());
					 ps_ins.setString(2,rb.getEmail());
					 ps_ins.setString(3,rb.getPwd());
					 ps_ins.execute();
					 return Constants.SUCCESS;
			
					}
						
					
					
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return "OOPs very big problem";
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(ps_ins);
				JDBCHelper.close(con);
				
			}
			
		}
		else
		return result;
	
	}
	
	
	// login purpose...

	public String authenticate(LoginBean lb) {
		String result=lb.validate();  // i/p validations..
		if(result.equals(Constants.SUCCESS))
		{
			Connection con=null;
			PreparedStatement ps_sel=null;
			ResultSet rs=null;
			try
			{
				con=JDBCHelper.getConnection();
				if(con==null)
				{                                                // u can skip this step..
					return "Oops Connection not established";
				}
				else
				{
					String sql="select * from register where email=? and password=?";
					ps_sel=con.prepareStatement(sql);
					ps_sel.setString(1,lb.getEmail());
					ps_sel.setString(2, lb.getPwd());
					ps_sel.execute();
					rs=ps_sel.getResultSet();
					if(rs.next())
					{
						return Constants.SUCCESS;
					}
					else
						return "Ur email or passwords are not correct";
				}
			
		        }
			catch(Exception e)
			{
				e.printStackTrace();
				return "oops big problem..";
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
				
			}
		}
		else
		return result;
		
	}
	
	// getting account detail...


	public RegBean getAccDetail(String email) {
		RegBean rb=null;
		Connection con=null;
		PreparedStatement ps_sel=null;
		ResultSet rs=null;
		try
		{
			Class.forName(Constants.DRIVERNAME);
			con=JDBCHelper.getConnection();
			String sql="select * from register where email=?";
			ps_sel=con.prepareStatement(sql);
			ps_sel.setString(1, email);
			ps_sel.execute();
			rs=ps_sel.getResultSet();
			while(rs.next())
			{
			    rb=new RegBean();
				rb.setUname(rs.getString("name"));
				rb.setEmail(rs.getString("email"));
				rb.setPwd(rs.getString("password"));
			
				
			}
		
		}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
				
			}
		return rb;
		
	}
	
	// filling information to database..


	public String update(RegBean rb) {
	
		Connection con=null;
		PreparedStatement ps_update=null;
		try
		{
			Class.forName(Constants.DRIVERNAME);
			con=JDBCHelper.getConnection();
			String sql="update register set name=?, password=? where email=?";
			ps_update=con.prepareStatement(sql);
			ps_update.setString(1, rb.getUname());
			ps_update.setString(2, rb.getPwd());
			ps_update.setString(3, rb.getEmail());
			ps_update.execute();
			
		
		}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{
				JDBCHelper.close(ps_update);
				JDBCHelper.close(con);
				
			}
	return Constants.SUCCESS;
		
		
	}
	
	
	// contact adding here


	public String contactAddMadu(AddContactBean acb,String email) {
		// converting String format date to sql date fprmat..
		
		String temp=acb.getDob();
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      Date dt=new Date();
		java.sql.Date dinanka=null;
      try {
    	  
		dt=sdf.parse(temp);
       dinanka=new java.sql.Date(dt.getTime());
	    } 
      catch (ParseException e1) {
		
		e1.printStackTrace();
	     }
      // date conversion complted successfully..
      
      
      // taking sl_no s from register table..
        Connection con=null;
		PreparedStatement ps_sel=null;
		PreparedStatement ps_sel2=null;
		PreparedStatement ps_ins=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		int sl_no=0;
		String res=acb.validate();
		if(res.equals(Constants.SUCCESS))
		{
		try{
			con=JDBCHelper.getConnection();
			if(con==null)
			{
				return "OOPS Connection not Established ";
			}
			else
			{
			 ps_sel2=con.prepareStatement("select sl_no from register where email=?");
			 ps_sel2.setString(1, email);
			 ps_sel2.execute();
			 rs2=ps_sel2.getResultSet();
			 if(rs2.next())
			 {
				 sl_no=rs2.getInt("sl_no");
			 }
			 ps_sel=con.prepareStatement("select * from addcontact where phonenum=?");
			 ps_sel.setString(1, acb.getPh());
			 ps_sel.execute();
			 rs=ps_sel.getResultSet();
			 if(rs.next())
			 {
				 return "Already dis Phonenumber is saved";
				 
			 }
			 else
			 {
				 String sql="insert into addcontact(name,email,phonenum,tags,gender,date,regdep_slno)values(?,?,?,?,?,?,?)";
				 System.out.println(acb+".....hi hero"+dinanka);
				 
			ps_ins=con.prepareStatement(sql);
			ps_ins.setString(1, acb.getConname());
			ps_ins.setString(2,acb.getEmail());
			ps_ins.setString(3,acb.getPh());
			ps_ins.setString(4,acb.getTag());
			ps_ins.setString(5, acb.getGender());
			ps_ins.setDate(6, dinanka);
			ps_ins.setInt(7, sl_no);
		     ps_ins.execute();
			return Constants.SUCCESS;
			 }
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "something bad happened";
		}
		finally
		{
			JDBCHelper.close(rs2);
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_ins);
			JDBCHelper.close(ps_sel2);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
			
		}
		
	}
	else
		return res;
	
}
				 
			 
      
      
      
      
		
		
		
			
	
	// list of contacts..


	@SuppressWarnings("resource")
	public List<AddContactBean> listMadu(String opt,String email) {
		
		List<AddContactBean> lacb= new ArrayList<AddContactBean>();
		
		Connection con=null;
		PreparedStatement ps_sel=null;
		ResultSet rs=null;
	    int sl_no=0;
		
		
		// getting sl_no from register table..
		try
		{
			con=JDBCHelper.getConnection();
		ps_sel=con.prepareStatement("select sl_no from register where email=?");
		 ps_sel.setString(1, email);
		 ps_sel.execute();
		 rs=ps_sel.getResultSet();
		 if(rs.next())
		 {
			 sl_no=rs.getInt("sl_no");
		 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
	
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
			
		}
		
		// got sl_no from register table..
		
		
		if(opt.equals("name"))  // for name
		{
			con=JDBCHelper.getConnection();
			try {
				ps_sel=con.prepareStatement("select * from  addcontact where regdep_slno=? order by name ");
				ps_sel.setInt(1, sl_no);
				ps_sel.execute();
				rs=ps_sel.getResultSet();
				SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-yyyy");
				
				
				while(rs.next())
				{
					AddContactBean  acb=new AddContactBean();
					acb.setConname(rs.getString("name"));
					acb.setEmail(rs.getString("email"));
					acb.setPh(rs.getString("phonenum"));
					acb.setTag(rs.getString("tags"));
					acb.setGender(rs.getString("gender"));
			         acb.setDob(sdf.format(rs.getDate("date")));
					lacb.add(acb);
					
				}
				
			    } 
			catch (SQLException e) {
				e.printStackTrace();
			    }
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
			}
		
		
			
		}
		else if(opt.equals("email")) // for email.
		{
			
			try {
				con=JDBCHelper.getConnection();
				ps_sel=con.prepareStatement("select * from  addcontact where regdep_slno=? order by email ");
				ps_sel.setInt(1, sl_no);
				ps_sel.execute();
				rs=ps_sel.getResultSet();
				SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
				while(rs.next())
				{
					AddContactBean  acb=new AddContactBean();
					acb.setConname(rs.getString("name"));
					acb.setEmail(rs.getString("email"));
					acb.setPh(rs.getString("phonenum"));
					acb.setTag(rs.getString("tags"));
					acb.setGender(rs.getString("gender"));
					  acb.setDob(sdf.format(rs.getDate("date")));
					lacb.add(acb);
					
				}
				
			    } 
			catch (SQLException e) {
				e.printStackTrace();
			    }
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
			}
	
			
		}
		else if(opt.equals("tag")) // for tags..
		{
			con=JDBCHelper.getConnection();
			try  {
				ps_sel=con.prepareStatement("select * from  addcontact where regdep_slno=? order by tags ");
				ps_sel.setInt(1, sl_no);
				ps_sel.execute();
				rs=ps_sel.getResultSet();
				SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
				while(rs.next())
				{
					AddContactBean acb=new AddContactBean();
					acb.setConname(rs.getString("name"));
					acb.setEmail(rs.getString("email"));
					acb.setPh(rs.getString("phonenum"));
					acb.setTag(rs.getString("tags"));
					acb.setGender(rs.getString("gender"));
					  acb.setDob(sdf.format(rs.getDate("date")));
					lacb.add(acb);
					
				}
				
			    } 
			catch (SQLException e) {
				e.printStackTrace();
			    }
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
			}
	
			
		}
		else if(opt.equals("din")) // for date....
		{
			con=JDBCHelper.getConnection();
			try  {
				ps_sel=con.prepareStatement("select * from  addcontact where regdep_slno=? order by date ");
				ps_sel.setInt(1, sl_no);
				ps_sel.execute();
				rs=ps_sel.getResultSet();
				SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
				while(rs.next())
				{
					AddContactBean acb=new AddContactBean();
					acb.setConname(rs.getString("name"));
					acb.setEmail(rs.getString("email"));
					acb.setPh(rs.getString("phonenum"));
					acb.setTag(rs.getString("tags"));
					acb.setGender(rs.getString("gender"));
					  acb.setDob(sdf.format(rs.getDate("date")));
					lacb.add(acb);
					
				}
				
			    } 
			catch (SQLException e) {
				e.printStackTrace();
			    }
			finally
			{
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(con);
			}
	
			
		}
		return lacb;
	}

	// editing of contactcs..

	public List<AddContactBean> editMadu(String email) {
		
		Connection con=null;
		PreparedStatement ps_sel=null;
		ResultSet rs=null;
		int sl_no=0;
		PreparedStatement ps_sel2=null;
		ResultSet rs2=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 List<AddContactBean> lacb=new ArrayList<AddContactBean>();
		
		try
		{
			con=JDBCHelper.getConnection();
			ps_sel=con.prepareStatement("select sl_no from register where email=?");
			ps_sel.setString(1, email);
			ps_sel.execute();
			rs=ps_sel.getResultSet();
			if(rs.next())
			{
				sl_no=rs.getInt("sl_no");
			}
			System.out.println("got serial num is"+sl_no);
			ps_sel2=con.prepareStatement("select * from addcontact where regdep_slno=?");
			ps_sel2.setInt(1, sl_no);
			ps_sel2.execute();
			rs2=ps_sel2.getResultSet();
			while(rs2.next())
			{
				AddContactBean acb=new AddContactBean();
				acb.setConname(rs2.getString("name"));
				acb.setEmail(rs2.getString("email"));
				acb.setPh(rs2.getString("phonenum"));
				acb.setTag(rs2.getString("tags"));
				acb.setGender(rs2.getString("gender"));
				  acb.setDob(sdf.format(rs2.getDate("date")));
				  lacb.add(acb);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCHelper.close(rs2);
			JDBCHelper.close(ps_sel2);
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
			
		}
		return lacb;
		
	}
	
	//taking bean for editing contact..


	public AddContactBean editMadu2(String email, String ph) {
		Connection con=null;
		PreparedStatement ps_sel=null;
		ResultSet rs=null;
		int sl_no=0;
		PreparedStatement ps_sel2=null;
		ResultSet rs2=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		 AddContactBean acb=new AddContactBean();
		
		try
		{
			con=JDBCHelper.getConnection();
			ps_sel=con.prepareStatement("select sl_no from register where email=?");
			ps_sel.setString(1, email);
			ps_sel.execute();
			rs=ps_sel.getResultSet();
			if(rs.next())
			{
				sl_no=rs.getInt("sl_no");
			}
			System.out.println("got serial num is"+sl_no);
			ps_sel2=con.prepareStatement("select * from addcontact where regdep_slno=? and phonenum=?");
			ps_sel2.setInt(1, sl_no);
			ps_sel2.setString(2, ph);
			ps_sel2.execute();
			rs2=ps_sel2.getResultSet();
			while(rs2.next())
			{
				
				acb.setConname(rs2.getString("name"));
				acb.setEmail(rs2.getString("email"));
				acb.setPh(rs2.getString("phonenum"));
				acb.setTag(rs2.getString("tags"));
				acb.setGender(rs2.getString("gender"));
				  acb.setDob(sdf.format(rs2.getDate("date")));
			
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCHelper.close(rs2);
			JDBCHelper.close(ps_sel2);
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
			
		}
		return acb;
		
	}

	// filling edited contact information to database..

	public String fillContactUpdate(AddContactBean acb) {
		System.out.println(acb+"in model");
		Connection con=null;
		PreparedStatement ps_upd=null;
		try
		{
			con=JDBCHelper.getConnection();
			ps_upd=con.prepareStatement("update addcontact set name=?,email=?,tags=? ,date=? where phonenum=?");
			ps_upd.setString(1, acb.getConname());
			ps_upd.setString(2, acb.getEmail());
			ps_upd.setString(3, acb.getTag());
			ps_upd.setString(4, acb.getDob());
			ps_upd.setString(5, acb.getPh());
			ps_upd.execute();
			return Constants.SUCCESS;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "oops update to db is failed";
		}
		finally
		{
			JDBCHelper.close(ps_upd);
			JDBCHelper.close(con);
			
		}
	}
	
	// for getting list for Searched key word...


	public List<AddContactBean> searchedList(String k,String email) {
		
		
		
		Connection con2=null;
		PreparedStatement ps_sel2=null;
		ResultSet rs2=null;
	    int sl_no=0;
		
		
		// getting sl_no from register table..
		try
		{
			con2=JDBCHelper.getConnection();
		ps_sel2=con2.prepareStatement("select sl_no from register where email=?");
		 ps_sel2.setString(1, email);
		 ps_sel2.execute();
		 rs2=ps_sel2.getResultSet();
		 if(rs2.next())
		 {
			 sl_no=rs2.getInt("sl_no");
		 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
	
		}
		finally
		{
			JDBCHelper.close(rs2);
			JDBCHelper.close(ps_sel2);
			JDBCHelper.close(con2);
			
		}
		System.out.println("sl_no came inside of getting search results methd "+sl_no);
		
		// selecting of list for particular edited string inside getting list
		Connection con=null;
		PreparedStatement ps_sel=null;
		ResultSet rs=null;
		List<AddContactBean> lacb=new ArrayList<AddContactBean>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String hold="%"+k+"%";
		
		try
		{
			con=JDBCHelper.getConnection();
			ps_sel=con.prepareStatement("select * from addcontact  where (name like ? or email like ? or tags like ?) and regdep_slno=?");
			ps_sel.setString(1, hold);
			ps_sel.setString(2, hold);
			ps_sel.setString(3, hold);
			ps_sel.setInt(4, sl_no);
			ps_sel.execute();
			rs=ps_sel.getResultSet();
			while(rs.next())
			{
				 AddContactBean acb=new AddContactBean();
				acb.setConname(rs.getString("name"));
				acb.setEmail(rs.getString("email"));
				acb.setPh(rs.getString("phonenum"));
				acb.setTag(rs.getString("tags"));
				acb.setGender(rs.getString("gender"));
				  acb.setDob(sdf.format(rs.getDate("date")));
				  lacb.add(acb);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_sel);
			JDBCHelper.close(con);
			
		}
		return lacb;
	}
	
	// for deleting contact...


	public String deleteMadu(String ph) {
		Connection con=null;
		PreparedStatement ps_remove=null;
		ResultSet rs=null;
		try
		{
		con=JDBCHelper.getConnection();
		ps_remove=con.prepareStatement("delete from addcontact where phonenum=?");
		ps_remove.setString(1,ph);
		ps_remove.execute();
			return Constants.SUCCESS;
		}
		catch(Exception e)
             	{
			e.printStackTrace();
			return "oops something bad happened";
	         }
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_remove);
			JDBCHelper.close(con);
		}
		
	}
  
	
	

}
