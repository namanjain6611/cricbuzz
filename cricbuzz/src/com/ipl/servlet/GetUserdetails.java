package com.ipl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.ipl.bean.Newusers;
import com.ipl.process.GetUserDetail;

/**
 * Servlet implementation class GetUserdetails
 */
@WebServlet("/GetUserdetails")
public class GetUserdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject jsonobject=null;
		try
		{
			jsonobject =new JSONObject();
		GetUserDetail getuserdetail=new GetUserDetail();
	    Newusers newuser=getuserdetail.getuser();
	    jsonobject.put("username", newuser.getUsername());
	    jsonobject.put("phoneno", newuser.getPhoneno());
	    jsonobject.put("amount", newuser.getAmount());
	    
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		response.getWriter().println(jsonobject);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
