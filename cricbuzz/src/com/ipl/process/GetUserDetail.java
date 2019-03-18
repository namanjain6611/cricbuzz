package com.ipl.process;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.JSONObject;

import com.ipl.bean.Newusers;

import connection.Hikaricp;

public class GetUserDetail {
	JSONObject jsonobject=null;
	Connection con=null;
	ResultSet rs=null;
	Newusers newuser=new Newusers();
   public Newusers getuser() throws SQLException
   {
	   con=Hikaricp.getConn();
	   String sql ="select amount,phoneno,name from user";
	   Statement stmt=con.createStatement();
	    rs=stmt.executeQuery(sql);
	    while(rs.next())
	    {
	    	newuser.setAmount(rs.getInt(1));
	    	newuser.setPhoneno(rs.getInt(2));
	    	newuser.setUsername(rs.getString(3));
	    }
	   
	   return newuser;
	   
   }  
}
