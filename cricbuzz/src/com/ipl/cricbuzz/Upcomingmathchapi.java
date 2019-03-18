package com.ipl.cricbuzz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import connection.Hikaricp;


public class Upcomingmathchapi{
	public static void main(String args[]) throws SQLException
	  {
		    Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String query = "";
            String query1="";
			JSONObject jsonObject = null;
			JSONArray jsonArray = null;
		  Cricbuzz obj=new Cricbuzz();
		  try {
			 StringBuffer response=Cricbuzz.call_me();
			 System.out.println(response);
			 String mathches=response.toString();
			 System.out.println(mathches);
			 JSONObject myresponse=new JSONObject(mathches);
			 System.out.println(myresponse);
			 JSONArray matches=myresponse.getJSONArray("matches");
			 System.out.println(matches);
			 con = Hikaricp.getConn();
			 query = "insert into upcomingmatchs(unique_id,date,team1,team2,type,squad,matchstarted) values(?,?,?,?,?,?,?)";
			 ps = con.prepareStatement(query);
			 for(int i=0;i<matches.length();i++)
			 {
			
			 ps.setInt(1,(int) matches.getJSONObject(i).get("unique_id"));
			
			 ps.setString(2, (String) matches.getJSONObject(i).get("date"));
			
			 ps.setString(3, (String) matches.getJSONObject(i).get("team-1"));
			
			 ps.setString(4, (String) matches.getJSONObject(i).get("team-2"));
			
			 ps.setString(5, (String) matches.getJSONObject(i).get("type"));
		
			 ps.setBoolean(6, (boolean) matches.getJSONObject(i).get("squad"));
			 
			 ps.setBoolean(7,(boolean) matches.getJSONObject(i).get("matchStarted"));
			 ps.addBatch();
			 }
			 ps.executeBatch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  finally
		  {
			  con.commit();
			  ps.clearBatch();
		  }
	  }
}

