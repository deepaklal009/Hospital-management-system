package Hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Employee_info extends JFrame
{
	public Employee_info(){
	JPanel panel2=new JPanel();
	panel2.setBounds(5,5,990,590);
	panel2.setBackground(new Color(109,164,170));
	panel2.setLayout(null);
	add(panel2);
	
	JTable table=new JTable();
	table.setBounds(10,34,980,450);
	table.setBackground(new Color(109,164,170));
	table.setFont(new Font("Tahoma",Font.BOLD,12));
	panel2.add(table);
	
	  try {
		  Class.forName("net.proteanit.sql.DbUtils");
            conn c2 = new conn();
            String query = "SELECT * FROM EMP_INFO";
            ResultSet rs = c2.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		JLabel label1=new JLabel("Name");
		label1.setBounds(25,9,70,20);
		label1.setFont(new Font("Tahoma",Font.BOLD,14));
		panel2.add(label1);
		
		JLabel label2=new JLabel("Age");
		label2.setBounds(180,9,70,20);
		label2.setFont(new Font("Tahoma",Font.BOLD,14));
		panel2.add(label2);
		
		JLabel label3=new JLabel("Phone no");
		label3.setBounds(350,9,150,20);
		label3.setFont(new Font("Tahoma",Font.BOLD,14));
		panel2.add(label3);
		
		JLabel label4=new JLabel("Salary");
		label4.setBounds(510,9,150,20);
		label4.setFont(new Font("Tahoma",Font.BOLD,14));
		panel2.add(label4);
		
		JLabel label5=new JLabel("Gmail");
		label5.setBounds(700,9,150,20);
		label5.setFont(new Font("Tahoma",Font.BOLD,14));
		panel2.add(label5);
		
		JLabel label6=new JLabel("CNIC");
		label6.setBounds(830,9,150,20);
		label6.setFont(new Font("Tahoma",Font.BOLD,14));
		panel2.add(label6);
		
		JButton b1=new JButton("BACK");
		b1.setBounds(350,500,120,30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.white);
		panel2.add(b1);
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
			}
		});
	
	setUndecorated(true);
	setSize(950,550);
	setLocation(250,210);
	setLayout(null);
	setVisible(true);
	}
	public static void main(String[] args)
	{
		new Employee_info();
	}
}