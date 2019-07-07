package jdbc;

import java.sql.*;
import java.util.*;
public class Pract5Acc {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try {
			CallableStatement cs = null;
			//Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
			System.out.print("Enter no of Account to Create : ");
			int n = s.nextInt();
			for(int i=0;i<n;i++) {
				System.out.print("Enter Account Number : ");
				int no = s.nextInt();
				System.out.print("Enter Account Holder Name : ");
				String name = s.next();
				System.out.print("Enter Account Balance : ");
				int bal = s.nextInt();
				System.out.print("Enter Account Type : ");
				String type = s.next();
				System.out.print("Enter Account Holder Address : ");
				String addr = s.next();
				System.out.print("Enter Phone Number : ");
				int phno = s.nextInt();
				cs = con.prepareCall("{call create_account(?,?,?,?,?,?)}");
				cs.setInt(1, no);
				cs.setString(2, name);
				cs.setInt(3, bal);
				cs.setString(4, type);
				cs.setString(5, addr);
				cs.setInt(6, phno);
				cs.execute();
				System.out.println("Procedure Executed & Data Inserted.");
			}
			con.close();
			s.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
