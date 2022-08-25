import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AddDriver extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDriver frame = new AddDriver();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public AddDriver() {
		setTitle("Add New Driver");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 566, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(127, 34, 105, 22);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(255, 36, 143, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAge.setBounds(143, 95, 47, 20);
		contentPane.add(lblAge);
		
		textField_1 = new JTextField();
		textField_1.setBounds(255, 96, 143, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(255, 128, 143, 22);
		contentPane.add(textField_2);
		
		JLabel lblMobilePhone = new JLabel("Mobile Phone :");
		lblMobilePhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobilePhone.setBounds(67, 129, 126, 16);
		contentPane.add(lblMobilePhone);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(255, 160, 143, 22);
		contentPane.add(textField_3);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(113, 158, 93, 22);
		contentPane.add(lblAddress);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(121, 196, 78, 16);
		contentPane.add(lblGender);
		
		JLabel lblNewLabel = new JLabel("Passcode :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(101, 69, 93, 16);
		contentPane.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(255, 68, 143, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(255, 195, 143, 22);
		contentPane.add(comboBox);
	
		
		JButton btnAdd = new JButton("Add ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FileWriter fileIn = new FileWriter("AvailableDrivers.txt",true);
					FileWriter file = new FileWriter("DriversLogin.txt",true);
					fileIn.write(textField.getText()+","+textField_1.getText()+","+textField_2.getText()+","+textField_3.getText()+","+textField_4.getText()+","+comboBox.getSelectedItem().toString()+System.lineSeparator());
					file.write(textField.getText()+System.lineSeparator()+textField_4.getText()+System.lineSeparator());
					fileIn.close();
					file.close();
					JOptionPane.showMessageDialog(btnAdd, "Successfully Added !");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		btnAdd.setBounds(301, 254, 97, 25);
		contentPane.add(btnAdd);
		
	
}}
