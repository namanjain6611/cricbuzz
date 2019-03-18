package com.ipl.process;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;



import connection.Hikaricp;

public class Getteam {
     
	public JSONObject getteam()
     {
    	 Connection con=null;
    	 JSONObject jsonobject=null;
    	 JSONArray jsonarray=null;
    	  ResultSet rs=null;
    	  PreparedStatement stmt=null;
    	 try
    	 {
    		 jsonobject=new JSONObject();
    		 jsonarray=new JSONArray();
    		 con=Hikaricp.getConn();
    		 String query="select team1,team2,date from upcomingmatchs where type=?";
    		 stmt=(PreparedStatement) con.prepareStatement(query);
    		 stmt.setString(1, "Twenty20");
    		 rs=stmt.executeQuery();
    		 while(rs.next())
    		 {
    			 JSONObject obj=new JSONObject();
    			 System.out.println("ggggggg"+rs.getString(1));
    			 obj.put("team1", rs.getString(1));
    			 obj.put("team2", rs.getString(2));
    			 obj.put("date", rs.getString(3));
    			 jsonarray.put(obj);
    		 }
    		 jsonobject.put("data",jsonarray);
    		 jsonobject.put("status", "200");
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    	 }
    	 finally
    	 {
    		 try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 System.out.println(jsonobject);
		 return jsonobject;
    	 
     }
	
	public JSONObject newuser(String username,int phoneno,int amount) 
	{
		 Connection con=null;
    	 JSONObject jsonobject=null;
    	 PreparedStatement stmt=null;
    	 PreparedStatement stmt1=null;
    	 PreparedStatement stmt2=null;
    	 String query1="";
    	 String query2="";
    	 try
    	 {
    		 jsonobject=new JSONObject();
    		 con=Hikaricp.getConn();
    		 String query=" create table "+username+" (id int(255) AUTO_INCREMENT PRIMARY KEY,username varchar(50),phoneno int(10),amount int(7));";
             query1="insert into user(name,phoneno,amount) values(?,?,?)";
             query2="insert into '"+username+"'(username,phoneno,amount) values(?,?,?)";
             stmt=(PreparedStatement) con.prepareStatement(query);
    		 int i=stmt.executeUpdate();
    		if(i>=0)
    		{
    			System.out.println("table created");
    			stmt1=con.prepareStatement(query1);
    			stmt1.setString(1,username);
    			stmt1.setInt(2, phoneno);
    			stmt1.setInt(3, amount);
    			int j=stmt1.executeUpdate();
    			con.commit();
    			if(j>=0)
    			{
    			stmt2=con.prepareStatement(query2);
    			stmt2.setString(1,username);
    			stmt2.setInt(2, phoneno);
    			stmt2.setInt(3, amount);
    			int k=stmt2.executeUpdate();
    			con.commit();
    			  if(k>=0)
    			  {
    			jsonobject.put("status", "200");
    			System.out.println("value of j is"+j);
    			System.out.println("data inserted");
    		}
    			  else
      			{
      				System.out.println("data not inserted in '"+username+"'");
      				jsonobject.put("status","400");
      			}
    			}
    			else
    			{
    				System.out.println("data not inserted in user  tale");
    				jsonobject.put("status","400");
    			}
    		}
    		else
    		{
    			System.out.println("table not created");
    			jsonobject.put("status", "400");
    		}
    	 }
    	 catch(Exception e)
    	 {
    		 System.out.println(e);
    		 
    	 }
    	 finally
    	 {
    		 try {
				con.close();
				stmt1.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	 }
    	 
    	 return jsonobject;
	}
}
