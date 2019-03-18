package com.ipl.cricbuzz;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Fatchvalue {
	public void fatch() throws Exception
	{
		int pid=0;
		Pidset pidd=new Pidset();
		Insert insert=new Insert();
		Getuniqueid uniqueid=new Getuniqueid();
		  ArrayList array=uniqueid.uniqueid();
		  ArrayList arraylist=new ArrayList();
	for(int i=0;i<array.size();i++)
	  {
		
		  
		  int saq=(int) array.get(i);
		  StringBuffer squa=Getsquadd.squad(saq);
		  String name=squa.toString();
		  JSONObject myresponse=new JSONObject(name);
			 //System.out.println(myresponse);
		  try
		  {
			 JSONArray matches=myresponse.getJSONArray("squad");
			 //System.out.println("ma"+matches);
			 for(int j=0;j<2;j++)
			 {
			 JSONObject players=matches.getJSONObject(j);
			 System.out.println("players"+players);
			 System.out.println(players.getJSONArray("players"));
			 JSONArray pla=players.getJSONArray("players");
			 for(int k=0;k<pla.length();k++)
			 {
				 JSONObject name1=pla.getJSONObject(k);
				 String playername=name1.getString("name");
				 pidd.setPlayername(playername);
				 System.out.println(playername);
				 pidd.setPid(pid);
				  pid=name1.getInt("pid");
				 System.out.println(pid);
				 String url="http://cricapi.com/api/playerStats?pid="+pid+"&apikey=KrCZoEKfiNZ7s3vNsOBQ84c7kBh2";
          	     getresponse response=new getresponse();
                 StringBuffer data= response.response(url);
                 System.out.println("value of data"+data);
                 Playerdetailsprocess player=new Playerdetailsprocess();
                 player.playerdetails(data);
				 insert.insertdata(pidd);
			 }
			 }
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		 
	  }


	
}
}