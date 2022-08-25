import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class ShowDriver extends JFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowTrips frame = new ShowTrips();
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
	public ShowDriver() {
		setTitle("Current Drivers");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 574, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>( model );
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, null, null, null));
		list.setBackground(Color.WHITE);
		try {
			FileReader fileReader = new FileReader(new File("AvailableDrivers.txt"));
			BufferedReader buff = new BufferedReader(fileReader);
			String temp = buff.readLine();
			while(temp != null) {
				model.addElement(temp);
				temp = buff.readLine();
			}
			
			}catch(Exception e) {
				
			}
		list.setBounds(12, 13, 408, 227);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.remove(list.getSelectedIndex());
			}
		});
		btnNewButton.setBounds(432, 47, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnClose.setBounds(432, 123, 97, 25);
		contentPane.add(btnClose);
		AddDriver dummyD = new AddDriver();
		JButton btnNewButton_1 = new JButton("Save");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileWriter write = new FileWriter("AvailableDrivers.txt");
					for(int i=0;i<list.getModel().getSize();i++) {
						write.write(String.valueOf(list.getModel().getElementAt(i)));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("File is empty!");
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(432, 85, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dummyD.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(432, 12, 97, 25);
		contentPane.add(btnNewButton_2);
	}
}
