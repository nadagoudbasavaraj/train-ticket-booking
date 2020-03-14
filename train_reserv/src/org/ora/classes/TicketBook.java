package org.ora.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class TicketBook {

	public static void main(String[] args) {
		System.out.println("enter your choice");
		int f=0;
		while(f==0) {
			System.out.println("1.IRTC Maintenance");
			System.out.println("2.Customer");
			Scanner scan = new Scanner(System.in);
			int choice =scan.nextInt();
			if(choice==1)
			{
				System.err.println("No Result found choose other option");
			}else if(choice==2)
			{
				checkSeat();
				f=1;
			}else
			{
				System.out.println("Enter correct option");
			}
		}
	}
		
			public static void checkSeat()
			{
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				String seat = "select seat_no from train_db.ticket";

				try {
					Class.forName("com.mysql.jdbc.Driver");
					con =DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
					ArrayList<Integer> arr1 = new ArrayList<Integer>();
					pstmt = con.prepareStatement(seat);
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						arr1.add(rs.getInt(1));
					}
					int i=0;
					System.out.println("seats available");
					while(i++<8)
					{
						if(!arr1.contains(i))
						{
							System.out.print(i+"  ");
						}
					}
					System.out.println();
					bookSeat(arr1, con);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				finally
				{
					if(con != null)
					{
						try {
								con.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
					}
					if(pstmt != null)
					{	
						try {
								pstmt.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
					}
				}
			}
	public static void bookSeat(ArrayList arr1,Connection con) throws SQLException
		{
			PreparedStatement pstmt1 = null;
			String cust ="insert into train_db.ticket values(?,?,?,?)";
			int flag=1;
			Scanner scan = new Scanner(System.in);
			
			while(flag==1)
			{
				System.out.println("select seat or enter seat no");
				int s=scan.nextInt();
				if(arr1.contains(s))
				{
					System.err.println("seat reserved");
				}
				else if(s>8 || s<=0)
				{
					System.err.println("Max seat_no is 8");
				}else
				{
					pstmt1 = con.prepareStatement(cust);
					pstmt1.setInt(1,s);
					flag=0;
				}
			}
			while(flag==0)
			{
				System.out.println("eneter cust name");
				String cname= scan.next().toLowerCase();
				char[] arr = cname.toCharArray();
				if(arr[0]>='a' && arr[0]<='z') 
				{
					pstmt1.setString(2, cname);
					flag=1;
				}else
				{
					System.err.println("enter correct name");
				}	
			}
			while(flag==1)
			{
				System.out.println("from");
				String from= scan.next().toLowerCase();
				char[] arr = from.toCharArray();
				int count=0;
				for(int i=0;i<arr.length;i++)
				{
					if(arr[i]>='a' && arr[i]<='z')
					{
						count++;
					}
				}
				if(count==arr.length)
				{
					pstmt1.setString(3,from);
					flag=0;
				}else
				{
					System.err.println("enter correct name");

				}
			}
			while(flag==0)
			{
				System.out.println("dest");
				String dest= scan.next().toLowerCase();
				char[] arr = dest.toCharArray();
				if(arr[0]>='a' && arr[0]<='z')
				{
					pstmt1.setString(4,dest);
					flag=1;
				}else
				{
					System.err.println("enter correct name");
				}
			}
			pstmt1.executeUpdate();
			System.out.println("booking confirmed");
		}
		
}
		
