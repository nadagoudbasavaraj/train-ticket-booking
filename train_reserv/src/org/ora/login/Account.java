package org.ora.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Account {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("enter emailid");
		String mail = scan.next();
		
		System.out.println("enter phone"); 
		long phone = scan.nextLong();
		
		System.out.println("enetr username");
		String uname = scan.next();
		
		System.out.println("password");
		String pass = scan.next();
		
		System.out.println("eneter gender");
		String gender = scan.next();
		
		String qry ="insert into train_db.login values('"+mail+"',"+phone+",'"+uname+"','"+pass+"','"+gender+"')";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			stmt = con.createStatement();
			stmt.execute(qry);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
