package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame {
    
    public Dashboard() {
        setLayout(null);
        setSize(1950, 1090);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1525, 670);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1525, 150);
        panel1.setBackground(new Color(109, 164, 170));
        add(panel1);
		
	
	ImageIcon originalIcon = new ImageIcon(getClass().getResource("/icon/dr.png"));
	Image scaledImage = originalIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	ImageIcon scaledIcon = new ImageIcon(scaledImage);
	JLabel imageLabel = new JLabel(scaledIcon);
	imageLabel.setBounds(1190, 0, 150, 150); 
	panel1.add(imageLabel);
	
	ImageIcon i1 = new ImageIcon(getClass().getResource("/icon/amb.png"));
	Image img = i1.getImage().getScaledInstance(220, 220, Image.SCALE_SMOOTH);
	ImageIcon i2 = new ImageIcon(img);
	JLabel label = new JLabel(i2);
	label.setBounds(900, 0, 220, 220); 
	panel1.add(label);

	JButton btn1=new JButton("Add new Patient");
	btn1.setBounds(30,15,200,30);
	btn1.setBackground(new Color(255, 218, 118));
	panel1.add(btn1);
	btn1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			new NEW_PATIENT();
		}
	});
	
	JButton btn2=new JButton("Room");
	btn2.setBounds(30,58,200,30);
	btn2.setBackground(new Color(255, 218, 118));
	panel1.add(btn2);
	btn2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			new Room();
		}
	});
	
	JButton btn3=new JButton("Department");
	btn3.setBounds(30,100,200,30);
	btn3.setBackground(new Color(255, 218, 118));
	panel1.add(btn3);
	btn3.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			new Department();
		}
	});
	
	JButton btn4=new JButton("All employee Info");
	btn4.setBounds(270,15,200,30);
	btn4.setBackground(new Color(255, 218, 118));
	panel1.add(btn4);
	btn4.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			new Employee_info();
		}
	});
	
	JButton btn5=new JButton("Patient Info");
	btn5.setBounds(270,58,200,30);
	btn5.setBackground(new Color(255, 218, 118));
	panel1.add(btn5);
	btn5.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			new All_Patient_Info();
		}
	});
	
	JButton btn6=new JButton("Patient Discharge");
	btn6.setBounds(270,100,200,30);
	btn6.setBackground(new Color(255, 218, 118));
	panel1.add(btn6);
	btn6.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			new patient_discharge();
		}
	});
	
	JButton btn7=new JButton("Update Patient Details");
	btn7.setBounds(510,15,200,30);
	btn7.setBackground(new Color(255, 218, 118));
	panel1.add(btn7);
	btn7.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			new update_patient_details();
		}
	});
	
	JButton btn8=new JButton("Hospital Ambulance");
	btn8.setBounds(510,58,200,30);
	btn8.setBackground(new Color(255, 218, 118));
	panel1.add(btn8);
	btn8.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			new Ambulance();
		}
	});
	
	JButton btn9=new JButton("Search Room");
	btn9.setBounds(510,100,200,30);
	btn9.setBackground(new Color(255, 218, 118));
	panel1.add(btn9);
	btn9.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			new SearchRoom();
		}
	});
	JButton btn10=new JButton("Logout");
	btn10.setBounds(750,15,200,30);
	btn10.setBackground(new Color(255, 218, 118));
	panel1.add(btn10);
	btn10.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			setVisible(false);
			new Login();
		}
	});


        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
