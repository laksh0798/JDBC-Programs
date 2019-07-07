package jdbc;
import java.sql.*;
import java.awt.*;
import java.util.Scanner;
public class metadata {
		public static void main(String args[])
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract", "root", "root");
				PreparedStatement ps = conn.prepareStatement("select * from employee where id> ?");
				Scanner sc = new Scanner(System.in);
				System.out.println("enter the id ");
				int i = sc.nextInt();
				ps.setInt(1, i);
				ResultSet rs = ps.executeQuery();
				ResultSetMetaData md = rs.getMetaData();
				System.out.println("Column number are " + md.getColumnCount());
				System.out.println("table name is " + md.getTableName(1));
				System.out.println("number of rows are 2" + md.getColumnLabel(1));
				DatabaseMetaData dmd = conn.getMetaData();
				System.out.println("Username of database is " + dmd.getUserName());
				System.out.println("Driver version" + dmd.getDatabaseProductVersion());
				System.out.println("database product name" + dmd.getDatabaseProductName());
				
				while(rs.next())
				{
					System.out.println(rs.getInt("id")+ "  "+ rs.getString("firstname")+ "   " + rs.getString("lastname") + "  " + rs.getString("email") );
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
}
