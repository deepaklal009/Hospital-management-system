package Hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame
{
	Choice choice;
	JTable table;
	public SearchRoom()
	{
		JPanel panel=new JPanel();
		panel.setBounds(5,5,690,490);
		panel.setBackground(new Color(90,156,163));
		panel.setLayout(null);
		add(panel);
			
		JLabel For=new JLabel("Search for Room");
		For.setBounds(250,11,186,31);
		For.setForeground(Color.white);
		For.setFont(new Font("Tahoma",Font.BOLD,20));
		panel.add(For);
		
		JLabel status=new JLabel("Status :");
		status.setBounds(70,70,80,20);
		status.setForeground(Color.white);
		status.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(status);
		
		choice=new Choice();
		choice.setBounds(170,70,140,20);
		choice.add("Available");
		choice.add("Occupied");
		panel.add(choice);
		
		table=new JTable();
		table.setBounds(0,187,700,210);
		table.setBackground(new Color(90,156,163));
		table.setForeground(Color.white);
		panel.add(table);
		
		try
		{
			Class.forName("net.proteanit.sql.DbUtils");
			conn c=new conn();
			String query = "SELECT * FROM room";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		JLabel Roomno=new JLabel("Room Number");
		Roomno.setBounds(7,162,150,20);
		Roomno.setForeground(Color.white);
		Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(Roomno);
		
		JLabel price=new JLabel("Price");
		price.setBounds(180,162,150,20);
		price.setForeground(Color.white);
		price.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(price);
		
		JLabel available=new JLabel("Availability");
		available.setBounds(340,162,150,20);
		available.setForeground(Color.white);
		available.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(available);
		
		JLabel bed=new JLabel("Bed Type");
		bed.setBounds(520,162,150,20);
		bed.setForeground(Color.white);
		bed.setFont(new Font("Tahoma",Font.BOLD,14));
		panel.add(bed);
		
		JButton search=new JButton("Search");
		search.setBounds(200,420,120,25);
		search.setBackground(Color.BLACK);
		search.setForeground(Color.white);
		panel.add(search);
		search.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{	
				String query="select * from room where Availability='"+choice.getSelectedItem()+"'";
				try
				{
					Class.forName("net.proteanit.sql.DbUtils");
					conn c1=new conn();
					ResultSet rs=c1.s.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JButton back=new JButton("Back");
		back.setBounds(380,420,120,25);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.white);
		panel.add(back);
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
			}
		});
		
		setUndecorated(true);
		setSize(700,500);
		setLocation(370,250);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new SearchRoom();
	}
}