package jdbc;

/*
Student registration System
*/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.*;
public class A3P3 extends JFrame
{
JMenuBar mb;
JMenu Master,Help;
JMenuItem New,Search,Update,help,about;
JLabel j1,j2,j3,j4,j5,j6,j7,j8,j9,j10;
JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
JTable jt=null;
JScrollPane jts=null;
JButton submit,cancle;
	A3P3()
{
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(400,400);
	mb=new JMenuBar();
	Master=new JMenu("Master");
	Help=new JMenu("Help");
	mb.add(Master);
	mb.add(Help);
	setJMenuBar(mb);
	New=new JMenuItem("New Student");
	Search=new JMenuItem("Search");
	Update=new JMenuItem("Update");
	help=new JMenuItem("help");
	about=new JMenuItem("about us");
	Master.add(New);
	New.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){new A3P3("New Student",0);}});
	Search.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){new A3P3("Search",0);}});
	Update.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){new A3P3("Update",0);}});
	help.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){new A3P3("Help",0);}});
	about.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){new A3P3("About us",0);}});
	
	Master.add(Search);
	Master.add(Update);
	Help.add(help);
	Help.add(about);
	
	setVisible(true);
}

String []cols;	
	A3P3(String s,int id)
{
	int xxxxx=0;
	switch(s)
	{
		case "New Student":
			JLabel tmp=new JLabel("Accept details of students",JLabel.CENTER);
			JPanel j=new JPanel();
			j.setLayout(new GridLayout(11,2));
			j1=new JLabel("Reg_id");
			j2=new JLabel("S_name");
			j3=new JLabel("S_address");
			j4=new JLabel("S_city");
			j5=new JLabel("S_state");
			j6=new JLabel("S_pincode");
			j7=new JLabel("s_ph_no");
			j8=new JLabel("Dept_id");
			j9=new JLabel("Dept_name");
			j10=new JLabel("Gender");			
			t1=new JTextField();j.add(j1);j.add(t1);
			t2=new JTextField();j.add(j2);j.add(t2);
			t3=new JTextField();j.add(j3);j.add(t3);
			t4=new JTextField();j.add(j4);j.add(t4);
			t5=new JTextField();j.add(j5);j.add(t5);
			t6=new JTextField();j.add(j6);j.add(t6);
			t7=new JTextField();j.add(j7);j.add(t7);
			t8=new JTextField();j.add(j8);j.add(t8);
			t9=new JTextField();j.add(j9);j.add(t9);
			t10=new JTextField();j.add(j10);j.add(t10);
			submit=new JButton("Submit");
			submit.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){
				if(test(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10)){
				try{
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				if(DriverManager.getConnection("jdbc:mysql://192.168.43.50/Anand","root","413512aA").createStatement().executeUpdate("insert into Student values("+t1.getText()+",'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"',"+t6.getText()+","+t7.getText()+",'"+t8.getText()+"','"+t9.getText()+"','"+t10.getText()+"')")==1)
	{	System.out.println("Successfully inserted");	dispose();}
				}catch(Exception e){System.out.println("Failed...");}
			}
				else System.out.println("Please enter all fields...");
			}});
			cancle=new JButton("Cancle");cancle.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){dispose();}});
			j.add(submit);j.add(cancle);
			add(j,BorderLayout.CENTER);
			tmp.setFont(new Font(null,0,20));
			add(tmp,BorderLayout.NORTH);
		break;
		case "Search":
		JLabel tmp2=new JLabel("Update students",JLabel.CENTER);
		JButton b3=new JButton("Search");
		JPanel jjj=new JPanel();
		JRadioButton b1,b2;
		b1=new JRadioButton("By ID");
		b2=new JRadioButton("By name");
		jjj.setLayout(new GridLayout(2,2));
		t1=new JTextField();jjj.add(b1);jjj.add(t1);
		t2=new JTextField();jjj.add(b2);jjj.add(t2);
		ButtonGroup bg=new ButtonGroup();
		bg.add(b1);bg.add(b2);
		add(jjj);
		JPanel jjj1=new JPanel();
		jjj1.setLayout(new GridLayout(2,1));
		jjj1.add(b3);
		add(jjj1,BorderLayout.SOUTH);
		b3.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){
try{			if(b1.isSelected()&&t1.getText().toString().trim().length()!=0)
			{
				int id=Integer.parseInt(t1.getText().toString());
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				ResultSet rss=DriverManager.getConnection("jdbc:mysql://192.168.43.50/Anand","root","413512aA").createStatement().executeQuery("select * from Student where Reg_id like '"+id+"%'");
				String [][]strdat=new String[10000][10];
				cols=new String[10];
				int jcount=0,icount=0;
				while(rss.next())
				{
				ResultSetMetaData m=rss.getMetaData();
					for(jcount=0;jcount<10;jcount++)cols[jcount]=m.getColumnName(jcount+1);
				System.out.println("\n\tFetching : "+rss.getString(1));
					jcount=1;
					while(jcount<=10)strdat[icount][jcount-1]=rss.getString(jcount++);icount++;
				}
				if(jcount!=0)
				{
					DefaultTableModel model=new DefaultTableModel(strdat,cols){
				            public int getColumnCount() { 
        				        return cols.length; 
            				} 

				            public String getColumnName(int index) { 
				                return cols[index]; 
			               }
				};
				if(jts!=null)jjj1.remove(jts);
				if(strdat==null)System.out.println("null 1");
				if(cols==null)System.out.println("null 2");
				String [][]strdat1=new String[icount][10];
				for(jcount=0;jcount<icount;jcount++)strdat1[jcount]=strdat[jcount];
				jt=new JTable(strdat1,cols);
				jt.addMouseListener(new MouseAdapter() {
		        public void mouseClicked(MouseEvent e) {
        		    if (e.getClickCount() == 1) {
        			        JTable target = (JTable) e.getSource();
                			int column = target.getSelectedColumn();
					 int row = target.getSelectedRow();
					if(column==0)
						{new A3P3("Update",Integer.parseInt(target.getModel().getValueAt(row, column).toString()));}
           				
               				 }
				        }});
				jt.setPreferredScrollableViewportSize(jt.getPreferredSize());
				jts=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				jjj1.add(jts);
				pack();
		
				}
				else{System.out.println("No record found");}
			}
			else if(b1.isSelected())
			{System.out.println("Please input id");}
			if(b2.isSelected()&&t2.getText().toString().trim().length()!=0)
			{
				String sname=t2.getText().toString();
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				ResultSet rss=DriverManager.getConnection("jdbc:mysql://192.168.43.50/Anand","root","413512aA").createStatement().executeQuery("select * from Student where S_name like '%"+sname+"%'");
				String [][]strdat=new String[10000][10];
				cols=new String[10];
				int jcount=0,icount=0;
				while(rss.next())
				{
				ResultSetMetaData m=rss.getMetaData();
					for(jcount=0;jcount<10;jcount++)cols[jcount]=m.getColumnName(jcount+1);
				System.out.println("\n\tFetching : "+rss.getString(1));
					jcount=1;
					while(jcount<=10)strdat[icount][jcount-1]=rss.getString(jcount++);icount++;
				}
				if(jcount!=0)
				{
					DefaultTableModel model=new DefaultTableModel(strdat,cols){
				            public int getColumnCount() { 
        				        return cols.length; 
            				} 

				            public String getColumnName(int index) { 
				                return cols[index]; 
			               }
				};
				if(jts!=null)jjj1.remove(jts);
				if(strdat==null)System.out.println("null 1");
				if(cols==null)System.out.println("null 2");
				String [][]strdat1=new String[icount][10];
				for(jcount=0;jcount<icount;jcount++)strdat1[jcount]=strdat[jcount];
				jt=new JTable(strdat1,cols);
				jt.addMouseListener(new MouseAdapter() {
		        public void mouseClicked(MouseEvent e) {
        		    if (e.getClickCount() == 1) {
        			        JTable target = (JTable) e.getSource();
                			int column = target.getSelectedColumn();
					 int row = target.getSelectedRow();
					if(column==0)
						{new A3P3("Update",Integer.parseInt(target.getModel().getValueAt(row, column).toString()));}
           				
               				 }
				        }});
				jt.setPreferredScrollableViewportSize(jt.getPreferredSize());
				jts=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				jjj1.add(jts);
				pack();
		
				}
				else{System.out.println("No record found");}
				
			}
			else if(b2.isSelected())
			{System.out.println("Please input name");}
}catch(Exception e){e.printStackTrace();}	
	}});
		break;
		case "Update":
			JLabel tmp1=new JLabel("Update students",JLabel.CENTER);
			JPanel jj=new JPanel();
			if(id==0)
			{
				jj.setLayout(new GridLayout(2,2));
				jj.add(new JLabel("Enter Roll no : "));
				t1=new JTextField();
				jj.add(t1);
			submit=new JButton("Search");submit.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){if(t1.getText().toString().trim().length()!=0){new A3P3("Update",Integer.parseInt(t1.getText()));dispose();}else System.out.println("Input id please...");}});
			cancle=new JButton("Cancle");cancle.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){dispose();}});
			jj.add(t1);jj.add(submit);jj.add(cancle);
		add(jj,BorderLayout.CENTER);
			}
			else
	{System.out.println("Requesting update id : "+id);
			try{
			jj.setLayout(new GridLayout(11,2));

				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				ResultSet rs=DriverManager.getConnection("jdbc:mysql://192.168.43.50/Anand","root","413512aA").createStatement().executeQuery("select * from Student where Reg_id="+id);
				if(rs.next())
				{
			j1=new JLabel("Reg no : "+id);
			j2=new JLabel("S_name");
			j3=new JLabel("S_address");
			j4=new JLabel("S_city");
			j5=new JLabel("S_state");
			j6=new JLabel("S_pincode");
			j7=new JLabel("s_ph_no");
			j8=new JLabel("Dept_id");
			j9=new JLabel("Dept_name");
			j10=new JLabel("Gender");			
			t1=new JTextField();jj.add(j1);jj.add(t1);t1.setVisible(false);
			t2=new JTextField();t2.setText(rs.getString(2));jj.add(j2);jj.add(t2);
			t3=new JTextField();t3.setText(rs.getString(3));jj.add(j3);jj.add(t3);
			t4=new JTextField();t4.setText(rs.getString(4));jj.add(j4);jj.add(t4);
			t5=new JTextField();t5.setText(rs.getString(5));jj.add(j5);jj.add(t5);
			t6=new JTextField();t6.setText(rs.getString(6));jj.add(j6);jj.add(t6);
			t7=new JTextField();t7.setText(rs.getString(7));jj.add(j7);jj.add(t7);
			t8=new JTextField();t8.setText(rs.getString(8));jj.add(j8);jj.add(t8);
			t9=new JTextField();t9.setText(rs.getString(9));jj.add(j9);jj.add(t9);
			t10=new JTextField();t10.setText(rs.getString(10));jj.add(j10);jj.add(t10);
			submit=new JButton("Update");
			submit.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){
				if(test(t2,t2,t3,t4,t5,t6,t7,t8,t9,t10)){
				try{
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				Statement s=DriverManager.getConnection("jdbc:mysql://192.168.43.50/Anand","root","413512aA").createStatement();
				int count=0;
				s.executeUpdate("update Student set S_name='"+t2.getText()+"' where Reg_id="+id);count++;
				s.executeUpdate("update Student set S_Address='"+t3.getText()+"' where Reg_id="+id);count++;
				s.executeUpdate("update Student set S_city='"+t4.getText()+"' where Reg_id="+id);count++;
				s.executeUpdate("update Student set S_state='"+t5.getText()+"' where Reg_id="+id);count++;
				s.executeUpdate("update Student set S_pincode="+t6.getText()+" where Reg_id="+id);count++;
				s.executeUpdate("update Student set S_ph_no="+t7.getText()+" where Reg_id="+id);count++;
				s.executeUpdate("update Student set Dept_id='"+t8.getText()+"' where Reg_id="+id);count++;
				s.executeUpdate("update Student set Dept_name='"+t9.getText()+"' where Reg_id="+id);count++;
				s.executeUpdate("update Student set Gender='"+t10.getText()+"' where Reg_id="+id);count++;
				if(count==9)
	{	System.out.println("Successfully Updated");}
				}catch(Exception e){System.out.println("Failed...\t"+e.getMessage());}
			}
				else System.out.println("Please enter all fields...");
			}});
			cancle=new JButton("Done");cancle.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent a){dispose();}});
			jj.add(submit);jj.add(cancle);
			add(jj,BorderLayout.CENTER);
			tmp1.setFont(new Font(null,0,20));
			add(tmp1,BorderLayout.NORTH);

				}else{new A3P3("Update",0);System.out.println("Id do not exist...");setVisible(false);dispose();xxxxx=1;}
			}catch(Exception e){e.printStackTrace();}
	 }
		break;
		case "Help":
			setSize(400,400);setVisible(true);j1=new JLabel("If you need help then contact : 2017bcs511");j1.setFont(new Font("Isabela",Font.ITALIC,30));
			add(j1);pack();xxxxx=1;
		break;
		case "About us":			
			setSize(400,400);setVisible(true);j1=new JLabel("My self Anand, \n\tgot lot of free time on hand\n\n....So writting something here...\n\n ");j1.setFont(new Font("Isabela",Font.ITALIC,30));
			add(j1);pack();xxxxx=1;
		break;
	}
if(xxxxx==0){	setVisible(true);
	setSize(400,400);}
}

public boolean test(JTextField t1,JTextField t2,JTextField t3,JTextField t4,JTextField t5,JTextField t6,JTextField t7,JTextField t8,JTextField t9,JTextField t10)
{
				if(t1.getText().toString().trim().length()!=0&&
				t2.getText().toString().trim().length()!=0&&
				t3.getText().toString().trim().length()!=0&&
				t4.getText().toString().trim().length()!=0&&
				t5.getText().toString().trim().length()!=0&&
				t6.getText().toString().trim().length()!=0&&
				t7.getText().toString().trim().length()!=0&&
				t8.getText().toString().trim().length()!=0&&
				t9.getText().toString().trim().length()!=0&&
				t10.getText().toString().trim().length()!=0)return true;
				else return false;
}
	public static void main(String[]a)
	{
		new A3P3();
	}
}