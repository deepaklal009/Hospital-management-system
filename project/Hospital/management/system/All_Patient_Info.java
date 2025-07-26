package Hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class All_Patient_Info extends JFrame
{
	public All_Patient_Info()
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
            String query = "SELECT * FROM patient_info";
            ResultSet rs = c3.s.executeQuery(query);
            tabel.setModel(DbUtils.resultSetToTableModel(rs));
        }
		catch (Exception ex)
		{
            ex.printStackTrace();
        }
		
		JLabel label1=new JLabel("ID");
		label1.setBounds(29,11,100,14);
		label1.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label1);
		
		JLabel label2=new JLabel("Number");
		label2.setBounds(133,11,100,14);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label2);
		
		JLabel label3=new JLabel("Name");
		label3.setBounds(240,11,100,14);
		label3.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label3);
		
		JLabel label4=new JLabel("Gender");
		label4.setBounds(338,11,100,14);
		label4.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label4);
		
		JLabel label5=new JLabel("Disease");
		label5.setBounds(450,11,100,14);
		label5.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label5);
		
		JLabel label6=new JLabel("Room");
		label6.setBounds(560,11,100,14);
		label6.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label6);
		
		JLabel label7=new JLabel("Time");
		label7.setBounds(660,11,100,14);
		label7.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(label7);
		
		JLabel label8=new JLabel("Deposit");
		label8.setBounds(760,11,100,14);
		label8.setFont(new Font("Tahoma",Font.BOLD,13));
		panel.add(label8);
		
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
		new All_Patient_Info();
	}
}