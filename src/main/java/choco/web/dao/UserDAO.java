package choco.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import choco.web.model.User;

public class UserDAO {
private Connection con;
private String query;
private PreparedStatement pst;
private ResultSet rs;

public UserDAO(Connection con) {
	super();
	this.con = con;
}


public UserDAO() {
	super();
}


public User userLogin(String name, String password)
{
	User user=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/chocoholics","root","root");
		PreparedStatement pst = con.prepareStatement("select *  from  user where username=? and password=? ");
		pst.setString(1, name);
		pst.setString(2, password);
		rs=pst.executeQuery();
		
		if(rs.next())
		{
			user =new User();
			user.setId(rs.getInt("uid"));
			user.setName(rs.getString("username"));
			
		
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	return user;
}


}
