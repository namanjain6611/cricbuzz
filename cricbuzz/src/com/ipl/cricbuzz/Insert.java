package com.ipl.cricbuzz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.Hikaricp;
import connection.connection;


public class Insert {
  public void insertdata(Pidset pidd) throws SQLException
  {
	    System.out.println("inner");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "";
		connection conn=null;
		Connection con=null;
		 try
		 { 
			 conn=new connection();
			con=conn.connection1();
		    query = "insert into pid(pid,teamname,playername) values('"+pidd.getPid()+"','in','"+pidd.getPlayername()+"')";
		    ps = con.prepareStatement(query);
		   int i=ps.executeUpdate();
		   if(i>=0)
		   {
			   System.out.println("insert");
		   }
		   else
		   {
			   System.out.println("error");
		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  finally
	  {
		  ps.clearBatch();
	  }
  }
  public void playerdata(Playerdetailsset set) throws SQLException
  {
	   connection conn=null;
	    System.out.println("inner");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con=null;
		String query = "";
		 try
		 { 
			  conn=new connection();
			 con=conn.connection1();
		    query = "insert into playerdetail(pid,imageurl,name,playingrole,country) values('"+set.getPid()+"','"+set.getImageurl()+"','"+set.getName()+"','"+set.getRole()+"','"+set.getCountry()+"')";
		    ps = con.prepareStatement(query);
		   int i=ps.executeUpdate();
		   if(i>=0)
		   {
			   System.out.println("insert");
		   }
		   else
		   {
			   System.out.println("error");
		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  finally
	  {
		  ps.clearBatch();
	  }
  }
  }