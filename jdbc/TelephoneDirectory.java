package jdbc;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Vector;

import javax.swing.*;

public class TelephoneDirectory extends Applet implements KeyListener{
	Contacts contacts;
	char [] letters;
	Vector results;
	Color col = Color.WHITE;
	
	public void init() {
		this.contacts = new Contacts();
		this.results = new Vector(0);
		
		letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		
		addKeyListener(this);
		requestFocus();
	}
	
	@Override
	public void keyTyped(KeyEvent ke) {
		this.showContacts(ke.getKeyChar());
	}
	
	@Override
	public void keyReleased(KeyEvent ke) {
			
	}
	
	@Override
	public void keyPressed(KeyEvent ke) {
		
	}
	
	public void start() {
		for(int i=0; i<100; i++) {
			String name = letters[randomInt(0, 25)] + "" + letters[randomInt(0, 25)] + "" + letters[randomInt(0, 25)];
			String number = "";
			
			for(int j=0; j<10; j++) {
				number += randomInt(0, 9) + "";
			}
			
			contacts.add(name, number);
			
			System.out.println(i+". "+ name + "    " + number);
		}
	}
	
	public void paint(Graphics g) {
		int length = this.results.size();
		
		for(int i=0; i<length; i++) {
			Contact c = (Contact) this.results.elementAt(i);
			g.drawString(c.name, 20, i*30 + 50);
			g.drawString(c.number, 100, i*30 + 50);
		}
	}
	
	public int randomInt(int min, int max) {
		return (int)Math.floor(Math.random()*(max-min+1)) + min;
	}
	
	void showContacts(char c) {
		this.results =  contacts.getContacts(c);
		repaint();
	}
}

class Contacts{
	Vector contacts;
	
	public Contacts() {
		this.contacts = new Vector();
	}
	
	public void add(String name, String number) {
		this.contacts.addElement(new Contact(name, number));
	}
	
	public Vector getContacts(char c) {
		int length = this.contacts.size();
		Vector results = new Vector(0);
		for(int i=0; i<length; i++) {
			Contact contact = (Contact)this.contacts.elementAt(i);
			if(contact.name.charAt(0) == c) {
				results.addElement(contact);
			}
		}
		
		return results;
	}
}

class Contact{
	String name, number;
	public Contact(String name, String number){
		this.name = name;
		this.number = number;
	}
}