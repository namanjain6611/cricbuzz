package com.ipl.cricbuzz;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Playerdetailsprocess {
   public void playerdetails(StringBuffer data)
   {
	    Playerdetailsset set=new Playerdetailsset();
	    Insert insert=new Insert();
	   try {
			 String players=data.toString();
			 System.out.println(players);
			 JSONObject player=new JSONObject(players);
			 String imageurl=player.getString("imageURL");
			 set.setImageurl(imageurl);
			 int pid=player.getInt("pid");
			 set.setPid(pid);
			 String fullname=player.getString("fullName");
			 set.setFullname(fullname);
			 String name=player.getString("name");
			 set.setName(name);
			 String country=player.getString("country");
			 set.setCountry(country);
			 String role=player.getString("playingRole");
			 set.setRole(role);
			 insert.playerdata(set);
		  }
		  catch(Exception e)
		  {
	        System.out.println(e);		  
		  }
   }
}
