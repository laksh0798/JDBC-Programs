package Pract7;
import java.io.*;
import java.net.*;
import java.sql.*;
public class pract7Ser {
		public static void main(String args[])
		{
			try
			{
				ServerSocket ss = new ServerSocket(4566);
				Socket s= ss.accept();
				OutputStream os = s.getOutputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintStream ps = new PrintStream(os);
				String state = br.readLine();
				System.out.println(state);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
				PreparedStatement pss = con.prepareStatement("Select capital from states where state = ?");
				pss.setString(1, state);
				ResultSet rs = pss.executeQuery();
				while(rs.next())
				{
					String capital = rs.getString(1);
					ps.println(capital);
					System.out.println(capital);
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
