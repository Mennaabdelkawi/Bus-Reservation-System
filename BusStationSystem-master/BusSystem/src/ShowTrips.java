import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowTrips extends JFrame {

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
	public ShowTrips() {
		setTitle("Current Trips");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 724, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>( model );
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, null, null, null));
		list.setBackground(Color.WHITE);
		try {
			FileReader fileReader = new FileReader(new File("AvailableTrips.txt"));
			BufferedReader buff = new BufferedReader(fileReader);
			String temp = buff.readLine();
			while(temp != null) {
				model.addElement(temp);
				temp = buff.readLine();
			}
			
			}catch(Exception e) {
				
			}
		list.setBounds(12, 13, 574, 310);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.remove(list.getSelectedIndex());
			}
		});
		btnNewButton.setBounds(597, 13, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setBounds(597, 51, 97, 25);
		contentPane.add(btnClose);
	}
}
