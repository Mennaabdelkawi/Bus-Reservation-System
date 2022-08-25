import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.BevelBorder;

public class DriverInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverInfo frame = new DriverInfo();
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
	JLabel lblNewLabel_6;
	JLabel label_1;
	JLabel lblNewLabel_8;
	JList<String> list1;
	
	public void setDriver(String driverName) {
		try {
			FileReader fileReader = new FileReader(new File("AvailableDrivers.txt"));
			BufferedReader buff = new BufferedReader(fileReader);
			while(buff.ready()) {
				String line = buff.readLine();
				if(line.startsWith(driverName)) {
					String[] driverInfo = line.split(",");
					lblNewLabel_6.setText(driverName);
					label_1.setText(driverInfo[1]);
					lblNewLabel_8.setText(driverInfo[5]);
					
					break;
				}
				
			}
			
			
			}catch(Exception e) {
				
			}
		
		DefaultListModel<String> model = new DefaultListModel<>();
		
		try {
			FileReader fileReader = new FileReader(new File("AvailableTrips.txt"));
			BufferedReader buff = new BufferedReader(fileReader);
			while(buff.ready()) {
				String line = buff.readLine();
				if(line.contains(driverName)) {
					model.addElement(line);
				}
				
			}
			list1.setModel(model);
			
			}catch(Exception e) {
				
			}
	}
	public DriverInfo() {
		setTitle("Your Information");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 826, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("YOUR PROFILE INFORMATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(12, 12, 282, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton.setBounds(640, 388, 100, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(24, 56, 66, 25);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAge.setBounds(34, 89, 44, 25);
		contentPane.add(lblAge);
		
		JLabel lblNewLabel_3 = new JLabel("Contact your Manager if you want to change any of your information");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(109, 317, 490, 16);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_6 = new JLabel("Assem");
		lblNewLabel_6.setBounds(203, 62, 56, 16);
		contentPane.add(lblNewLabel_6);
		
		label_1 = new JLabel("20");
		label_1.setBounds(203, 95, 56, 16);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_7 = new JLabel("Gender:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(22, 127, 68, 16);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Male");
		lblNewLabel_8.setBounds(203, 124, 56, 16);
		contentPane.add(lblNewLabel_8);
		
		list1 = new JList<>();
		list1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list1.setBounds(282, 56, 458, 248);
		contentPane.add(list1);
		
		JLabel lblNewLabel_4 = new JLabel("Your Trips");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(306, 10, 140, 31);
		contentPane.add(lblNewLabel_4);
		
		
	}
}
