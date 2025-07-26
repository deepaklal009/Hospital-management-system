package Hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class patient_discharge extends JFrame
{
	public patient_discharge()
	{
		JPanel panel=new JPanel();
		panel.setBounds(5,5,790,390);
		panel.setBackground(new Color(90,156,163));
		panel.setLayout(null);
		add(panel);
		
		JLabel label1=new JLabel("Check Out");
		label1.setBounds(100,20,150,20);
		label1.setFont(new Font("Tahoma",Font.BOLD,22));
		label1.setForeground(Color.white);
		panel.add(label1);
		
		JLabel label2=new JLabel("Customer ID");
		label2.setBounds(30,80,150,20);
		label2.setFont(new Font("Tahoma",Font.BOLD,15));
		label2.setForeground(Color.white);
		panel.add(label2);
		
		Choice choice =new Choice();
		choice.setBounds(200,80,150,25);
		panel.add(choice);
		
		try
		{
			conn c=new conn();
			String query="select * from patient_info";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
			{
				choice.add(rs.getString("ID"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JLabel label3=new JLabel("Room Number");
		label3.setBounds(30,130,150,20);
		label3.setFont(new Font("Tahoma",Font.BOLD,15));
		label3.setForeground(Color.white);
		panel.add(label3);
		
		JLabel RNo=new JLabel();
		RNo.setBounds(200,130,150,20);
		RNo.setFont(new Font("Tahoma",Font.BOLD,15));
		RNo.setForeground(Color.white);
		panel.add(RNo);
		
		JLabel label4=new JLabel("In Time");
		label4.setBounds(30,180,150,20);
		label4.setFont(new Font("Tahoma",Font.BOLD,15));
		label4.setForeground(Color.white);
		panel.add(label4);
		
		JLabel INTime=new JLabel();
		INTime.setBounds(200,180,130,20);
		INTime.setFont(new Font("Tahoma",Font.BOLD,13));
		INTime.setForeground(Color.white);
		panel.add(INTime);
		
		JLabel label5 = new JLabel("Out Time");
		label5.setBounds(30, 230, 150, 20);
		label5.setFont(new Font("Tahoma", Font.BOLD, 15));
		label5.setForeground(Color.white);
		panel.add(label5);

		Date date = new Date();

		JLabel OUTTime = new JLabel("" + date);
		OUTTime.setBounds(200, 230, 300, 20); 
		OUTTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		OUTTime.setForeground(Color.white);
		panel.add(OUTTime);
		
		JButton discharge=new JButton("Discharge");
		discharge.setBounds(30,300,120,30);
		discharge.setBackground(Color.BLACK);
		discharge.setForeground(Color.white);
		panel.add(discharge);
		discharge.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae){
			conn c=new conn();
			try
			{
				c.s.executeUpdate("delete from patient_info where ID='"+choice.getSelectedItem()+"'");
				c.s.executeUpdate("Update room set Availability='Available' where room_no='"+RNo.getText()+"'");
				JOptionPane.showMessageDialog(null,"Done");
				setVisible(false);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		});
		
		JButton Check=new JButton("Check");
		Check.setBounds(170,300,120,30);
		Check.setBackground(Color.BLACK);
		Check.setForeground(Color.white);
		panel.add(Check);
		Check.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				conn c1=new conn();
				try
				{
					String query = "select * from patient_info where ID='"+choice.getSelectedItem()+"'";
					ResultSet rs=c1.s.executeQuery(query);
					while(rs.next())
					{
						RNo.setText(rs.getString("Room_number"));
						INTime.setText(rs.getString("Time"));
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			} 
		});
		
		JButton Back=new JButton("Back");
		Back.setBounds(300,300,120,30);
		Back.setBackground(Color.BLACK);
		Back.setForeground(Color.white);
		panel.add(Back);
		Back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
			}
		});
		
		

		
		setUndecorated(true);
		setSize(800,400);
		setLocation(400,250);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new patient_discharge();
	}
}