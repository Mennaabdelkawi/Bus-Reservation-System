import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginScreen {

	private JFrame frmBusSystem;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.frmBusSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public LoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	PassengersFrame p1 = new PassengersFrame();
	ManagerFrame m1 = new ManagerFrame();
	DriverInfo D1=new DriverInfo();
	
	
	private void initialize() {
		frmBusSystem = new JFrame();
		frmBusSystem.setTitle("Bus System");
		frmBusSystem.setBounds(100, 100, 522, 263);
		frmBusSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBusSystem.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Panel");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(133, 53, 184, 45);
		frmBusSystem.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setBounds(133, 111, 78, 16);
		frmBusSystem.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(133, 140, 78, 16);
		frmBusSystem.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(201, 108, 116, 22);
		frmBusSystem.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(201, 141, 116, 22);
		frmBusSystem.getContentPane().add(passwordField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Passenger");
		comboBox.addItem("Driver");
		comboBox.addItem("Manager");
		
		comboBox.setBounds(320, 71, 100, 22);
		frmBusSystem.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tempUname = textField.getText();
				String tempPsd = passwordField.getText();
				if(comboBox.getSelectedItem().toString().equals("Manager")) {
					if((tempUname.equals("admin")) && (tempPsd.equals("admin"))) {
						JOptionPane.showMessageDialog(btnNewButton, "Successfully Logged in!");
						m1.setVisible(true);
					}
				}
				if(comboBox.getSelectedItem().toString().equals("Passenger")) {
					try {
						FileReader fileReader = new FileReader(new File("PassengersData.txt"));
						BufferedReader buff = new BufferedReader(fileReader);
						String temp = buff.readLine();
						while(temp!=null) {
							if(temp.equals(textField.getText())) {
								temp = buff.readLine();
								if(temp.equals(passwordField.getText())) {	
									p1.setVisible(true);
									break;
								}
								else {
									temp = buff.readLine();								}
							}
							else {
								temp = buff.readLine();		
							}
							
							
						}
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				if(comboBox.getSelectedItem().toString().equals("Driver")) {
					try {
						FileReader fileReader = new FileReader(new File("DriversLogin.txt"));
						BufferedReader buff = new BufferedReader(fileReader);
						String temp = buff.readLine();
						while(temp!=null) {
							if(temp.equals(textField.getText())) {
								temp = buff.readLine();
								if(temp.equals(passwordField.getText())) {
									D1.setDriver(textField.getText());
									D1.setVisible(true);
									
									break;
								}
								else {
									temp = buff.readLine();								}
							}
							else {
								temp = buff.readLine();		
							}
							
							
						}
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		btnNewButton.setBounds(220, 185, 97, 25);
		frmBusSystem.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(323, 185, 97, 25);
		frmBusSystem.getContentPane().add(btnNewButton_1);
	}
}
