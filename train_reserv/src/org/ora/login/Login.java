package org.ora.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Login {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String qry = "select * from train_db.login where email_id=?";
		String qry1 = "select * from train_db.login where phone =?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		
			Scanner scan = new Scanner(System.in);
			System.out.println("enter emailid or phone");
			String mail =  scan.next();
			char[] arr = mail.toCharArray();
			if(arr[0]>='a'  && arr[0]<='z')
			{
				pstmt = con.prepareStatement(qry);
				pstmt.setString(1,mail);
				rs =pstmt.executeQuery();
			}else {
				long phone = Long.parseLong(mail);
				pstmt = con.prepareStatement(qry1);
				pstmt.setLong(1,phone);
				rs =pstmt.executeQuery();
			}
			if(rs.next())
			{
				System.out.println("welcome "+rs.getString(3));
			}else {
					System.out.println("invalid emailid or phone");
				  }
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
