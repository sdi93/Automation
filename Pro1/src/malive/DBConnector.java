package malive;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	public static int dbCheck(String dbUrl,String username, String password, String query) throws ClassNotFoundException, SQLException, Throwable
	{
		int res= 0;
		try
		{	
  	 		
    	    Class.forName("com.mysql.jdbc.Driver");					
    	    Connection con = DriverManager.getConnection(dbUrl,username,password);	
    	    Statement stmt = con.createStatement();					
    	    ResultSet rs= stmt.executeQuery(query);							
    	    
    	    if(rs.next()){
    	    	res = rs.getInt(1);
    	    	System.out.println(res);
    	    	}
    	    
    	     
			
			con.close();
		}
	catch(Exception e)	{
		
		System.out.println(e);
		return res;
		
	}	
			

		
		return res;
	}
}
