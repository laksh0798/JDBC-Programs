package Pract7;
import java.net.*;
import java.io.*;
import java.sql.*;

import java.io.*;
public class pract7cli {
		public static void main(String args[])
		{
			try
			{
				Socket s = new Socket("127.0.0.1", 4566);
				OutputStream os = s.getOutputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
				PrintStream ps = new PrintStream(os);
				System.out.println("Enter the state to get capital");
				String state = kb.readLine();
				ps.println(state);
				String capital = br.readLine();
				System.out.println(capital);
			}
			catch(Exception e)
			{
				
			}
		}
}
