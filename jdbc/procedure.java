package jdbc;
import java.sql.*;
import java.io.*;
public class procedure {
			public static void main(String args[])
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
					CallableStatement cs = conn.prepareCall("{call demo4}");
					cs.execute();
					System.out.println(cs.getLong("firstname"));
					System.out.println("success");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
}
