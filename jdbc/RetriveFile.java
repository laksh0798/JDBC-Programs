package jdbc;

import java.sql.*;
import java.io.*;

public class RetriveFile {
	public static void main(String args[])
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
			PreparedStatement ps = conn.prepareStatement("select file from employee");
			ResultSet rs = ps.executeQuery();
			rs.next();
			Clob c= rs.getClob(1);
			Reader r = c.getCharacterStream();
			FileWriter fw= new FileWriter("/home/laksh/Desktop/l.txt");
			int i;
			while((i=r.read())!=-1)
			{
				fw.write((char)i);
			}
			fw.close();
			System.out.println(i + " file retrived ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		}
}
