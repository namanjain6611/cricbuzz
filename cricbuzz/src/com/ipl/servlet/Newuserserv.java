package com.ipl.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.ipl.bean.Newusers;
import com.ipl.process.Getteam;

/**
 * Servlet implementation class Newuserserv
 */
@WebServlet("/Newuserserv")
public class Newuserserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newuserserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		JSONObject obj=null;
		Gson gson=null;
		BufferedReader br=null;
		Newusers newuser=null;
		String json="";
		try
		{
			gson=new Gson();
			Getteam team=new Getteam();
			br=new BufferedReader(new InputStreamReader(request.getInputStream()));
			if(br!=null)
			{
		      json=br.readLine();		
			}
			else
			{
				obj.put("status", "400");
			}
			if(json!=null)
			{
				Newusers bean=gson.fromJson(json, Newusers.class);
				
				if(bean.getUsername()!=null)
				{
					obj=team.newuser(bean.getUsername(),bean.getPhoneno(),bean.getAmount());
				}
				else
				{
					obj.put("status", "400");
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		response.getWriter().print(obj);
	}

}
