package Hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;




public class Room extends JFrame{
	JTable table;
    public Room() 
	{
		JPanel panel =new JPanel();
		panel.setBounds(5,5,890,590);
		panel.setBackground(new Color(90,156,163));
		panel.setLayout(null);
		add(panel);
		
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icon/room.jpeg"));
		Image image=img.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon ImageIcon1=new ImageIcon(image);
		JLabel label=new JLabel(ImageIcon1);
		label.setBounds(600,200,200,200);
		panel.add(label);
		
		table = new JTable();
		table.setBackground(new Color(90,156,163));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 40, 560, 400); // Adjust width & height as needed
		panel.add(scrollPane);
		scrollPane.getViewport().setBackground(new Color(90,156,163));

		
	  try {
		  Class.forName("net.proteanit.sql.DbUtils");
            conn c1 = new conn();
            String query = "SELECT * FROM room";
            ResultSet rs = c1.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		JButton jb1=new JButton("Back");
		jb1.setBounds(200,450,120,30);
		jb1.setBackground(Color.BLACK);
		jb1.setForeground(Color.WHITE);
		panel.add(jb1);
		jb1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setVisible(false);
			}
		});
		
		
		setSize(850,500);
		setLayout(null);
		setLocation(300,230);
		setUndecorated(true);
		setVisible(true);
		
        
    }
	public static void main(String[] args)
	{
		new Room();
	}
}
