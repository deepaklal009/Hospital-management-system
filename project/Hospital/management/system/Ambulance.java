package Hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Ambulance extends JFrame
{
	public Ambulance()
	{
		JPanel panel=new JPanel();
		panel.setBounds(5,5,890,590);
		panel.setBackground(new Color(90,156,163));
		panel.setLayout(null);
		add(panel);
		
		JTable tabel=new JTable();
		tabel.setBounds(20,40,850,450);
		tabel.setBackground(new Color(90,156,163));
		tabel.setFont(new Font("Tahoma",Font.BOLD,12));
		panel.add(tabel);
		
		  try
   	  {
	   	  Class.forName("net.proteanit.sql.DbUtils");
            conn c3 = new conn();
            String query = "SELECT * FROM Ambulance";
            ResultSet rs = c3.s.executeQuery(query);
            tabel.setModel(DbUtils.resultSetToTableModel(rs));
        }
		catch (Exception ex)
		{
            ex.printStackTrace();
        }
		
		JLabel label1=new JLabel("Name");
		label1.setBounds(29,11,100,14);
		label1.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label1);
		
		JLabel label2=new JLabel("Gender");
		label2.setBounds(180,11,100,14);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label2);
		
		JLabel label3=new JLabel("Car name");
		label3.setBounds(350,11,100,14);
		label3.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label3);
		
		JLabel label4=new JLabel("Availability");
		label4.setBounds(520,11,100,14);
		label4.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label4);
		
		JLabel label5=new JLabel("Location");
		label5.setBounds(700,11,100,14);
		label5.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label5);
		
		
		
		
		
		JButton b1=new JButton("BACK");
		b1.setBounds(450,510,120,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.white);
		panel.add(b1);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
			}
		});
		
		setUndecorated(true);
		setSize(900,600);
		setLayout(null);
		setLocation(290,200);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new Ambulance();
	}
}

