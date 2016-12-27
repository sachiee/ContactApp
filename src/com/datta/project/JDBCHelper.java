package com.datta.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCHelper {
   public static Connection getConnection()
   {
	   Connection con=null;
	   try
	   {
		   Class.forName(Constants.DRIVERNAME);
		   con=DriverManager.getConnection(Constants.URL,Constants.UID,Constants.PWD);
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	return con;
   }
   
   
   
   
   
   // closing purpose..
   public static void close(Connection x)
   {
	   try
	   {
		   if(x!=null)
			   x.close();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
   
  // closing result set..
   
   
   public static void close(ResultSet x)
   {
	   try
	   {
		   if(x!=null)
			   x.close();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }
   
   /// closing statements
   
   
   public static void close(Statement x)
   {
	   try
	   {
		   if(x!=null)
			   x.close();
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
   }

}
