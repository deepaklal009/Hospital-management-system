package Hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class update_patient_details extends JFrame
{
	public update_patient_details()
	{
		JPanel panel =new JPanel();
		panel.setBounds(5,5,940,490);
		panel.setBackground(new Color(90,156,163));
		panel.setLayout(null);
		add(panel);
		
		ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
		Image image=img.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
		ImageIcon img1=new ImageIcon(image);
		JLabel label =new JLabel(img1);
		label.setBounds(550,60,300,300);
		panel.add(label);
		
		JLabel label1=new JLabel("Update Patient Details");
		label1.setBounds(124,11,260,25);
		label1.setFont(new Font("Tahoma",Font.BOLD,20));
		label1.setForeground(Color.white);
		panel.add(label1);
		
		JLabel label2=new JLabel("Name :");
		label2.setBounds(25,88,100,15);
		label2.setFont(new Font("Tahoma",Font.PLAIN,14));
		label2.setForeground(Color.white);
		panel.add(label2);
		
		Choice choice=new Choice();
		choice.setBounds(248,85,180,25);
		panel.add(choice);
		
		try{
			conn c=new conn();
			String query="select * from patient_info";
			ResultSet rs1=c.s.executeQuery(query);
			while(rs1.next())
			{
				choice.add(rs1.getString("Name"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		JLabel label3=new JLabel("Room Number :");
		label3.setBounds(25,129,100,15);
		label3.setFont(new Font("Tahoma",Font.PLAIN,14));
		label3.setForeground(Color.white);
		panel.add(label3);
		
		JTextField jtextFiledR=new JTextField();
		jtextFiledR.setBounds(248,129,180,20);
		panel.add(jtextFiledR);
		
		JLabel label4=new JLabel("In-Time :");
		label4.setBounds(25,174,100,15);
		label4.setFont(new Font("Tahoma",Font.PLAIN,14));
		label4.setForeground(Color.white);
		panel.add(label4);
		
		JTextField jtextFiledIntime=new JTextField();
		jtextFiledIntime.setBounds(248,174,180,20);
		panel.add(jtextFiledIntime);
		
		JLabel label5=new JLabel("Amount Paid (RS) :");
		label5.setBounds(25,216,100,14);
		label5.setFont(new Font("Tahoma",Font.PLAIN,14));
		label5.setForeground(Color.white);
		panel.add(label5);
		
		JTextField jtextfieldAmount=new JTextField();
		jtextfieldAmount.setBounds(248,216,180,20);
		panel.add(jtextfieldAmount);
		
		JLabel label6=new JLabel("Pending Amount (RS) :");
		label6.setBounds(25,261,100,14);
		label6.setFont(new Font("Tahoma",Font.PLAIN,14));
		label6.setForeground(Color.white);
		panel.add(label6);
		
		JTextField jtextfieldPending=new JTextField();
		jtextfieldPending.setBounds(248,261,180,20);
		panel.add(jtextfieldPending);
		
		JButton check=new JButton("CHECK");
		check.setBounds(281,378,89,23);
		check.setBackground(Color.black);
		check.setForeground(Color.white);
		panel.add(check);
		check.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				String name=choice.getSelectedItem();
				String query="select * from patient_info where Name='"+name+"'";
				try
				{
					conn c=new conn();
					ResultSet rs=c.s.executeQuery(query);
					while(rs.next())
					{
						jtextFiledR.setText(rs.getString("Room_Number"));
						jtextFiledIntime.setText(rs.getString("Time"));
						jtextfieldAmount.setText(rs.getString("Deposition"));
						
					}
					ResultSet rs2=c.s.executeQuery("select * from room where room_no='"+jtextFiledR.getText()+"'");
					while(rs2.next())
					{
						String price=rs2.getString("price");
						int amountPaid=Integer.parseInt(price) - Integer.parseInt(jtextfieldAmount.getText());
						jtextfieldPending.setText(""+amountPaid);
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		JButton update=new JButton("UPDATE");
		update.setBounds(56,378,89,23);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		panel.add(update);
		update.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
        try {
            conn c = new conn();
            String name = choice.getSelectedItem();
            String room = jtextFiledR.getText();
            String time = jtextFiledIntime.getText();
            String amount = jtextfieldAmount.getText();

           
		String oldRoom = "";
		String fetchOldRoomQuery = "SELECT Room_Number FROM patient_info WHERE Name = ?";
		PreparedStatement getOldRoom = c.c.prepareStatement(fetchOldRoomQuery);
		getOldRoom.setString(1, name);
		ResultSet rs = getOldRoom.executeQuery();
		if (rs.next()) 
		{
			oldRoom = rs.getString("Room_Number");
		}
		getOldRoom.close();


		String queryUpdate = "UPDATE patient_info SET Room_Number = ?, Time = ?, Deposition = ? WHERE Name = ?";
		PreparedStatement ps = c.c.prepareStatement(queryUpdate);
		ps.setString(1, room);
		ps.setString(2, time);
		ps.setString(3, amount);
		ps.setString(4, name);
		int rows = ps.executeUpdate();
		ps.close();


		if (!oldRoom.equals(room)) {
    
		String updateOldRoom = "UPDATE room SET Availability = 'Available' WHERE Room_No = ?";
		PreparedStatement psOld = c.c.prepareStatement(updateOldRoom);
		psOld.setString(1, oldRoom);
		psOld.executeUpdate();
		psOld.close();

   
		String updateNewRoom = "UPDATE room SET Availability = 'Occupied' WHERE Room_No = ?";
		PreparedStatement psNew = c.c.prepareStatement(updateNewRoom);
		psNew.setString(1, room);
		psNew.executeUpdate();
		psNew.close();
}

            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Updated Successfully");
				setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "No matching record found");
				setVisible(false);
            }

            ps.close();
            c.c.close(); 
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Update Failed: " + e.getMessage());
        }
    }
});

		
		JButton back=new JButton("BACK");
		back.setBounds(168,378,89,23);
		back.setBackground(Color.black);
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
		setSize(950,500);
		setLayout(null);
		setLocation(265,230);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new update_patient_details();
	}
}