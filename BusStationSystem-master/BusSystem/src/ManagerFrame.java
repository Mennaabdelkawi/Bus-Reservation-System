import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTable;

public class ManagerFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//AddDriver addD = new AddDriver();
	/**
	 * Create the frame.
	 */
	SettingTrips st = new SettingTrips();
	
	ShowTrips showAvT = new ShowTrips();
	ShowDriver showD=new ShowDriver();
	AddDriver AD=new AddDriver();
	
	public ManagerFrame() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Adminstrator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(181, 13, 240, 43);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Create new trip");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				st.setVisible(true);
			}
		});
		btnNewButton.setBounds(181, 71, 190, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Driver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			AD.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(181, 147, 190, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Show Trips");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAvT.setVisible(true);
			}
		});
		
		btnNewButton_2.setBounds(181, 109, 192, 25);
		contentPane.add(btnNewButton_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setBounds(420, 253, 97, 25);
		contentPane.add(btnLogout);
		
		JButton btnNewButton_3 = new JButton("Show All Drivers");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showD.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(181, 189, 190, 25);
		contentPane.add(btnNewButton_3);
	}
}
