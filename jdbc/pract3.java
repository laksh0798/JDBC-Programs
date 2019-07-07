package jdbc;
import java.sql.*;
import java.util.Scanner;
import java.io.*;
public class pract3 {
		public static void main(String args[])
		{	
			try 
			{
			int i;
			Scanner sc = new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
			Statement st = conn.createStatement();
			System.out.println("Enter your choise\n1.To create table 'grades'\n2.To Update\n3.To Read\n"
					+ "4.To delete\n5.To drop table\nAny other key to exit");
			i= sc.nextInt();
			while(i>0 && i<6)
			{
				switch (i) {
				case 1:
					i= st.executeUpdate("CREATE TABLE grades(STD_ID INT NOT NULL AUTO_INCREMEN"
							+ "T PRIMARY KEY, SUBJECT TEXT,MARK INT)");
					System.out.println("Table grade has been created");
					i=sc.nextInt();
					break;
				case 2:
					i = st.executeUpdate("INSERT INTO grades(SUBJECT,MARK) VALUES('java',23)");
					System.out.println("Data for student 1 has been inserted into database");
					i=sc.nextInt();
					break;
				case 3:
					ResultSet  rs = st.executeQuery("SELECT * FROM grades");
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+ "   " + rs.getString(2)+ "   " + rs.getString(3));
					}
					System.out.println("end of data");
					i=sc.nextInt();
					break;	
				case 4:
					i = st.executeUpdate("DELETE FROM grades WHERE STD_ID = 1");
					System.out.println("Data Deleted");
					i=sc.nextInt();
					break;
				case 5:
					i = st.executeUpdate("DROP TABLE grades");
					System.out.println("Table Deleted");
					i=sc.nextInt();
					break;	
				}
				
				System.out.println("Exit");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			}
}
