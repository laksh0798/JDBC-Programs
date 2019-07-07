package jdbc;

import java.sql.*;
import java.util.*;

public class Salary {
public static void main(String[] args) throws SQLException,BatchUpdateException
{
	DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract","root","root");
	Scanner s= new Scanner(System.in);
	
	float da,hra,oa,va;
	
	PreparedStatement ps5=con.prepareStatement("create table emp(id integer,fname VARCHAR(30),lname VARCHAR(30),category integer,basic_pay integer)");
	ps5.executeUpdate();
	ps5.addBatch("insert into emp values(11,'Laxman','Tidake',1,10000)");
    ps5.addBatch("insert into emp values (12,'deepak','yadav',2,20000)");
    ps5.addBatch("insert into emp values (13,'saurav','chaudhari',3,30000)");
    ps5.addBatch("insert into emp values (14,'gaurav','band',4,40000)");
    int c[]=ps5.executeBatch();
    System.out.println((c.length) +" rows" +" inserted");

    PreparedStatement ps4=con.prepareStatement("create table afe(category integer,da integer,hra integer,oa integer,va integer)");
    
    ps4.executeUpdate();
    ps4.addBatch("insert into afe values(1,87,8,0,500)");
    ps4.addBatch("insert into afe values(2,65,8,0,1100)");
    ps4.addBatch("insert into afe values(3,45,8,5,2)");
    ps4.addBatch("insert into afe values(4,30,8,15,2.5)");
    int c1[]=ps4.executeBatch();
    System.out.println((c1.length) +" rows" +" inserted");
while(true)
{
    System.out.println("\n" +"Enter id of employee");
	int id = s.nextInt();
	PreparedStatement ps1=con.prepareStatement("select * from emp where id="+id);
	ResultSet rs=ps1.executeQuery();
	rs.next();
    String fnam=rs.getString(2);
	String lnam=rs.getString(3);
	int cat=rs.getInt(4);
	int bsal=rs.getInt(5);

	
	if(cat==1||cat==2)
	{
	PreparedStatement ps2=con.prepareStatement("select * from afe where category="+cat);
	ResultSet rs1=ps2.executeQuery();
	while(rs1.next())
	{
		da=rs1.getInt(2);
		hra=rs1.getInt(3);
		oa=rs1.getInt(4);
		va=rs1.getInt(5);
		float tsal=(float)bsal+(da/100)*bsal+(hra/100)*bsal+va;
		System.out.println("Total salary of "+fnam +lnam +" is " +tsal);
	}
	}
	else if(cat==3||cat==4)
	{
		PreparedStatement ps3=con.prepareStatement("select * from afe where category="+cat);
		ResultSet rs2=ps3.executeQuery();
		while(rs2.next())
		{
			da=rs2.getInt(2);
			hra=rs2.getInt(3);
			oa=rs2.getInt(4);
			va=rs2.getInt(5);
			float tsal=(float)bsal+(da/100)*bsal+(hra/100)*bsal+(oa/100)*bsal+(va/100)*bsal;
			System.out.println("Total salary of "+fnam +" "+lnam +" is " +tsal);
	}
	}
	else
	{
		System.out.println("category for this employee is not available in allowance for employee table" +"\n"+"but basic_pay of "+fnam +" is " +bsal);
	}
	

	
}   
	
}
}