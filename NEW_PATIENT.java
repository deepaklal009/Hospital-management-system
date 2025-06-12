package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class NEW_PATIENT extends JFrame implements ActionListener {
    JComboBox<String> comboBox, c1;
    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposit;
    JRadioButton rb1, rb2;
    JLabel date;
    JButton b1, b2;

    public NEW_PATIENT() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 840, 540);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon i1 = new ImageIcon(getClass().getResource("/icon/patient.png"));
        Image img = i1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(img);
        JLabel label = new JLabel(i2);
        label.setBounds(530, 150, 200, 200);
        panel.add(label);

        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelID.setForeground(Color.WHITE);
        panel.add(labelID);

        comboBox = new JComboBox<>(new String[]{"CNIC", "Driving License", "Voter ID"});
        comboBox.setBounds(271, 70, 150, 25);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);

        JLabel number = new JLabel("Number :");
        number.setBounds(35, 111, 200, 14);
        number.setFont(new Font("Tahoma", Font.BOLD, 14));
        number.setForeground(Color.WHITE);
        panel.add(number);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 115, 150, 20);
        panel.add(textFieldNumber);

        JLabel labelname1 = new JLabel("Name :");
        labelname1.setBounds(35, 151, 200, 14);
        labelname1.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelname1.setForeground(Color.WHITE);
        panel.add(labelname1);

        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        panel.add(textName);

        JLabel labelgender = new JLabel("Gender :");
        labelgender.setBounds(35, 191, 200, 14);
        labelgender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelgender.setForeground(Color.WHITE);
        panel.add(labelgender);

        rb1 = new JRadioButton("Male");
        rb1.setFont(new Font("Tahoma", Font.BOLD, 14));
        rb1.setForeground(Color.WHITE);
        rb1.setBackground(new Color(109, 164, 170));
        rb1.setBounds(271, 191, 80, 15);
        panel.add(rb1);

        rb2 = new JRadioButton("Female");
        rb2.setFont(new Font("Tahoma", Font.BOLD, 14));
        rb2.setForeground(Color.WHITE);
        rb2.setBackground(new Color(109, 164, 170));
        rb2.setBounds(350, 191, 80, 15);
        panel.add(rb2);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35, 231, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 231, 150, 20);
        panel.add(textFieldDisease);

        JLabel Roomlabel = new JLabel("Room :");
        Roomlabel.setBounds(35, 274, 200, 14);
        Roomlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        Roomlabel.setForeground(Color.WHITE);
        panel.add(Roomlabel);

        c1 = new JComboBox<>();
        try {
            conn c2 = new conn();
            String query = "SELECT * FROM Room WHERE Availability='Available'";
            Statement stmt = c2.c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                c1.addItem(rs.getString("room_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(271, 274, 150, 25);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setBackground(new Color(3, 45, 48));
        c1.setForeground(Color.WHITE);
        panel.add(c1);

        JLabel labeldate = new JLabel("Time :");
        labeldate.setBounds(35, 316, 200, 14);
        labeldate.setFont(new Font("Tahoma", Font.BOLD, 14));
        labeldate.setForeground(Color.WHITE);
        panel.add(labeldate);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(271, 316, 250, 14);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        date.setForeground(Color.WHITE);
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposit :");
        labelDeposit.setBounds(35, 359, 200, 17);
        labelDeposit.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDeposit.setForeground(Color.WHITE);
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271, 359, 150, 20);
        panel.add(textFieldDeposit);

        b1 = new JButton("ADD");
        b1.setBounds(100, 430, 120, 30);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(260, 430, 120, 30);
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.addActionListener(e -> setVisible(false));
        panel.add(b2);

        setUndecorated(true);
        setSize(830, 520);
        setLayout(null);
        setLocation(280, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String idType = (String) comboBox.getSelectedItem();
            String idNumber = textFieldNumber.getText();
            String name = textName.getText();
            String gender = rb1.isSelected() ? "Male" : rb2.isSelected() ? "Female" : "";
            String disease = textFieldDisease.getText();
            String room = (String) c1.getSelectedItem();
            String time = date.getText();
            String deposit = textFieldDeposit.getText();

            try {
                PreparedStatement pst = c.c.prepareStatement("INSERT INTO patient_info VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                pst.setString(1, idType);
                pst.setString(2, idNumber);
                pst.setString(3, name);
                pst.setString(4, gender);
                pst.setString(5, disease);
                pst.setString(6, room);
                pst.setString(7, time);
                pst.setString(8, deposit);
                pst.executeUpdate();

                PreparedStatement pst2 = c.c.prepareStatement("UPDATE room SET Availability='Occupied' WHERE room_no=?");
                pst2.setString(1, room);
                pst2.executeUpdate();

                JOptionPane.showMessageDialog(null, "Patient Added Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new NEW_PATIENT();
    }
} 