package com.ipl.cricbuzz;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Getuniqueid {
	ArrayList<Integer> array=null;
	public ArrayList uniqueid()
	{
		array=new ArrayList<Integer> ();
	    Cricbuzz obj=new Cricbuzz();
	  try {
		 StringBuffer response=Cricbuzz.call_me();
		 String mathches=response.toString();
		 System.out.println(mathches);
		 JSONObject myresponse=new JSONObject(mathches);
		 System.out.println(myresponse);
		 JSONArray matches=myresponse.getJSONArray("matches");
		 
		 for(int i=0;i<matches.length();i++)
		 {
		     array.add((Integer) matches.getJSONObject(i).get("unique_id"));
		     
		 }
	  }
	  catch(Exception e)
	  {
        System.out.println(e);		  
	  }
	  System.out.println(array);
	  return array;
}
}