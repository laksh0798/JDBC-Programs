package Pract7;
import java.net.InetAddress;
import java.util.Scanner;
public class IpByName {
		public static void main(String args[])
		{
				try 
				{
						System.out.println("Enter the URL");
						Scanner sc =new Scanner(System.in);
						String data = sc.nextLine();
						InetAddress ip1 = InetAddress.getByName(data);
						System.out.println("IP of entered website is www. is: " + ip1.getHostAddress());
							
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		}
}

