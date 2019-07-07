package jdbc;

import java.sql.*;
import java.sql.ResultSet;
import java.util.Scanner;
public class Prepared {
			public static void main(String args[])
			{
				Scanner sc = new Scanner(System.in);
//				String firstname,lastname, email;
//				
//				System.out.println("Enter id to insert");
//				int id= sc.nextInt();
//				
//				System.out.println("Enter fname to insert");
//				firstname= sc.nextLine();
//				System.out.println("Enter lname to insert");
//				lastname= sc.nextLine();
//				System.out.println("Enter email to insert");
//				email= sc.nextLine();
				String name,name2;
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
					
					PreparedStatement ps = conn.prepareStatement("select * from employee where id > ?");
					System.out.print("enter the id");
					int data = sc.nextInt();; 
					
					
					ps.setInt(1, data);
//					ps.setString(2, "rahul");
//					ps.setString(3, "tidake");
//					ps.setString(4, "rahul@gmail.com");
					
					 ResultSet rs = ps.executeQuery();
							while (rs.next()) {
						        int id = rs.getInt(1);
						        String firstname = rs.getString(2);
						        String lastname = rs.getString(3);
						        String email = rs.getString(4); 
						        System.out.println(id	 + "\t" + firstname + "\t" + lastname+ "\t" + email );
						      }
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

			private static void display(ResultSet rs) {
				// TODO Auto-generated method stub
				
			}
			
}
