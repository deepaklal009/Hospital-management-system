package Hospital.management.system; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
	JTextField textField;
	JButton jb1,jb2;
	JPasswordField jpasswordField;
	Login()
	{
		JLabel nameLabel=new JLabel("Username");
		nameLabel.setBounds(40,20,100,30);
		nameLabel.setFont(new Font("Tahoma",Font.BOLD,16));
		nameLabel.setForeground(Color.BLACK);
		add(nameLabel);
		
		JLabel password=new JLabel("Password");
		password.setBounds(40,70,100,30);
		password.setFont(new Font("Tahoma",Font.BOLD,16));
		password.setForeground(Color.BLACK);
		add(password);
		
		textField=new JTextField();
		textField.setBounds(150,20,150,30);
		textField.setFont(new Font("Tahoma",Font.PLAIN,15));
		textField.setBackground(new Color(255,179,0));
		add(textField);
		
		jpasswordField=new JPasswordField();
		jpasswordField.setBounds(150,70,150,30);
		jpasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
		jpasswordField.setBackground(new Color(255,179,0));
		add(jpasswordField);
		
		try 
		{
    
		ImageIcon originalIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
    
    
		Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
    
   
		JLabel imageLabel = new JLabel(scaledIcon);
		imageLabel.setBounds(450, 30, 200, 200); 
		add(imageLabel);
		}
 		catch (Exception e) {
		System.err.println("Error loading image: " + e.getMessage());
		JLabel errorLabel = new JLabel("Image not found");
		errorLabel.setBounds(350, 0, 200, 30);
		add(errorLabel);
}

		jb1=new JButton("Login");
		jb1.setBounds(40,140,120,30);
		jb1.setFont(new Font("serif",Font.BOLD,15));
		jb1.setBackground(Color.BLACK);
		jb1.setForeground(Color.white);
		add(jb1);
		jb1.addActionListener(this);
		
		
		jb2=new JButton("Cancel");
		jb2.setBounds(180,140,120,30);
		jb2.setFont(new Font("serif",Font.BOLD,15));
		jb2.setBackground(Color.BLACK);
		jb2.setForeground(Color.WHITE);
		add(jb2);
		jb2.addActionListener(this);
		
		getContentPane().setBackground(new Color(109,164,170));
		setSize(750,300);
		setLocation(330,250);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==jb1)
	{
	try
	{
		conn c = new conn(); 
		String user = textField.getText();
		String pass = new String(jpasswordField.getPassword());

		String query = "SELECT * FROM Login where user_id = ? AND pw = ?";
		PreparedStatement pst = c.c.prepareStatement(query);
		pst.setString(1, user);
		pst.setString(2, pass);


		ResultSet rs = pst.executeQuery();


                if (rs.next()) {
					JOptionPane.showMessageDialog(null, "Login Successfull");
					  setVisible(false);
                    new Dashboard();
                   
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

                rs.close();
                pst.close();
                c.c.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            System.exit(0);
        }
    }
	
	
	public static void main(String[] args)
	{
		new Login();
	}
}