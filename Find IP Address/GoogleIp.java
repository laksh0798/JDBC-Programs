package Pract7;
import java.io.IOException;
import java.net.InetAddress;
public class GoogleIp {
		
		public static void check(String start)throws IOException
		{
			int to = 100;
			for(int i = 0 ; i<255 ; i++)
			{
				String ip = start + "." + i;
				if(InetAddress.getByName(ip).isReachable(to))
				{
					System.out.println(ip + " is reachable");
				}
			}
		}
		
		public static void main(String args[]) throws IOException
		{
			check("192.168.178");
		}
}
