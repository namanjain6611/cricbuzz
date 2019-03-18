package connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

public class connection {
	 Connection con=null;
	    public Connection connection1()
	    {
	        
	    try
	    {
	        Class.forName("com.mysql.jdbc.Driver");
	        con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cricbuzz","root", "newrootpassword");
	       
	    }
	    catch(Exception e)
	    {
	        JOptionPane.showMessageDialog(null,"error");
	    }
	   
	    return con;
	    
	    }
		public PreparedStatement prepareStatement(String sql) {
			// TODO Auto-generated method stub
			return null;
		}
		
}
