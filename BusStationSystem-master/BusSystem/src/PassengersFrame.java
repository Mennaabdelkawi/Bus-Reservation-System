import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.ComboBox;

import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PassengersFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengersFrame frame = new PassengersFrame();
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
	public PassengersFrame() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 676, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> list = new JList<>( model );
		
		
		JList list2 = new JList();
		
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
		Tickets server = new Tickets();
		SettingTrips newk = new SettingTrips();
		
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		list.setBounds(12, 13, 525, 288);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Reserve");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String item = model.get(list.getSelectedIndex());
				String[] tripData = item.split(",");
				int numOfPassengeres = Integer.parseInt(tripData[tripData.length-1]);
				if(numOfPassengeres>0) {
				numOfPassengeres--;
				
				tripData[tripData.length-1] = ""+numOfPassengeres;
		        StringBuilder stringBuilder = new StringBuilder();

		        for (int i = 0; i < tripData.length; i++) {
		            stringBuilder.append(tripData[i]);
		            if(i<tripData.length-1) {
		            	 stringBuilder.append(",");
		            }
		        }

		        model.set(list.getSelectedIndex(),stringBuilder.toString());
				try {
						
					FileWriter fileIn = new FileWriter("AvailableTrips.txt",false);
					for(int i = 0 ; i<model.getSize(); i++) {
					
					fileIn.write(model.get(i)+"\n");
					}
					fileIn.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
					}
			
			}
		});
		btnNewButton.setBounds(549, 12, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(549, 63, 97, 25);
		contentPane.add(btnNewButton_1);
	}
	
}
