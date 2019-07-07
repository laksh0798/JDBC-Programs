package Pract7;
import java.net.InetAddress;
public class PrintIp {
		public static void main(String args[])
		{
				try 
				{
						InetAddress ip = InetAddress.getLocalHost();
						System.out.println("Local ip of my machinr is: " + ip.getHostAddress());
						InetAddress ip1 = InetAddress.getByName("www.sggs.ac.in");
						System.out.println("IP of my institute website  is: " + ip1.getHostAddress());
						InetAddress ip2[] = InetAddress.getAllByName("www.google.com");
						for(int i=0; i< 2; i++)
						{
							System.out.println("IP of my institute website  is: " + ip2[i]);
						}	
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		}
}
