package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class Department extends JFrame {
    public Department() {
        // Main panel
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(new Color(90, 156, 163));
        add(panel1);

       JTable table = new JTable();
	Color bgColor = new Color(90, 156, 163);
	table.setBackground(bgColor);
	table.setFont(new Font("Tahoma", Font.BOLD, 14));
	table.setRowHeight(25);

	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.getViewport().setBackground(bgColor);  // This makes the white area teal
	scrollPane.setColumnHeaderView(null);

	panel1.add(scrollPane, BorderLayout.CENTER);


        // Populate data
        try {
            conn c = new conn();
            String query = "SELECT * FROM department";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

	 JButton b1 = new JButton("BACK");
	 b1.setBounds(200,450,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(bgColor);
        buttonPanel.add(b1);
        panel1.add(buttonPanel, BorderLayout.SOUTH);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
            }
        });

        // Frame settings
		setUndecorated(true);	
        setTitle("Department Table");
        setSize(700, 500);
        setLocation(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
