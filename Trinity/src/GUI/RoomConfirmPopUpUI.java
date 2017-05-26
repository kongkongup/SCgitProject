package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RoomConfirmPopUpUI extends JFrame {
	

    
	
	public static void main(String[] args) {
		new RoomConfirmPopUpUI();
	}
		
	public RoomConfirmPopUpUI() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 3) - (this.getWidth() / 2);
		int yPos = (dim.height / 3) - (this.getHeight() / 2);
		
		this.setBounds(xPos, yPos, 430, 265);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("[COBEN] SCIT Studyroom Scheduling System - Confirm");

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
				
		JLabel label = new JLabel("Reservation Completed!");
		label.setBackground(Color.WHITE);
		label.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		label.setBounds(105, 58, 214, 35);
		getContentPane().add(label);
		
		JLabel lblCheckYourEmail = new JLabel("Check Your E-mail :)");
		lblCheckYourEmail.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblCheckYourEmail.setBackground(Color.WHITE);
		lblCheckYourEmail.setBounds(121, 107, 183, 35);
		getContentPane().add(lblCheckYourEmail);
		
		JButton btnGoToMain = new JButton("go to Main");
		btnGoToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ShowRoomsUI();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
		});
		btnGoToMain.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		btnGoToMain.setBackground(new Color(0, 191, 255));
		btnGoToMain.setBounds(121, 176, 183, 29);
		getContentPane().add(btnGoToMain);
			
		this.setResizable(false);
		this.setVisible(true);
	}
}