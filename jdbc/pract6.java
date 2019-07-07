package jdbc;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class pract6 extends Applet implements KeyListener{
	char msg;
	public void init() {
		addKeyListener(this);
		requestFocus();
	}
	public void keyPressed(KeyEvent ke) {
		
	}
	public void keyReleased(KeyEvent ke) {
		
	}
	public void keyTyped(KeyEvent ke) {
		msg=ke.getKeyChar();
		repaint();
	}
	public void paint(Graphics g) {
		try {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pract","root","root");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM telephone WHERE name LIKE ?");
		String s = msg+"%";
		ps.setString(1, s);
		ResultSet rs = ps.executeQuery();
		int y=30;
		while (rs.next())
	    	{
			
			String s1 = rs.getString(1)+ " " + rs.getInt(2);
			g.drawString(s1, 30, y);
			y = y +10;
			System.out.println(y);
 		}}
        catch (SQLException | ClassNotFoundException e1) {
            e1.printStackTrace();
        }
 }  
	}
