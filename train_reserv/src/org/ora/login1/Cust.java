package org.ora.login1;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cust {
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String qry = "insert into tain_db.ticket values(?,?)";
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			
			//pstmt = con.prepareStatement(sql);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
