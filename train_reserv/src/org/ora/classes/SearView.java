package org.ora.classes;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearView {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String seat ="select seat_no from train_db.ticket order by seat_no"; 
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("class loaded");
			
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			//System.out.println("connection");
			
			pstmt = con.prepareStatement(seat);
			
			rs = pstmt.executeQuery();
			
			/*int seatno = 8;
			System.out.println("seats researved");
			//ArrayList seats = new ArrayList();
			//System.out.println(seats);
			ArrayList arr = new ArrayList();
			for(int i= 1 ; i<= 8 ; i++ )
			{
				arr.add(i);
			}
			ArrayList arr1 = new ArrayList();
			while(rs.next())
			{
				arr1.add(rs.getInt(1));
				System.out.print(rs.getInt(1)+" ");
			}
			arr.removeAll(arr1);
				System.out.println("select seat"+arr); */
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
