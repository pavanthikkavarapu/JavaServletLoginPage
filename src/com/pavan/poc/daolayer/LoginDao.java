package com.pavan.poc.daolayer;

import java.sql.*;  

public class LoginDao  {  
public static boolean validate(String name,String pass){  
boolean status=false;  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/employee","root","root");  
      
PreparedStatement ps=con.prepareStatement(  
"select * from userreg where name=? and pass=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
while(rs.next())  
	System.out.println(rs.getString(1)+"  "+rs.getInt(2));  
          
}catch(Exception e){System.out.println(e);}  
return status;  
}  
}  