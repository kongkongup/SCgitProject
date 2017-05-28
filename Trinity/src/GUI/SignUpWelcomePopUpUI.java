package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* 2017.05.23 È«±ÔÈñ*/
public class SignUpWelcomePopUpUI extends JFrame {
	private JLabel lblSignUpCompleted;
	private JButton btnYes;
	private JLabel lblWelcome;

	public SignUpWelcomePopUpUI() {

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();

		int xPos = (dim.width / 3) - (this.getWidth() / 2);
		int yPos = (dim.height / 3) - (this.getHeight() / 2);

		this.setBounds(xPos, yPos, 430, 265);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("[COBEN] SCIT Studyroom Scheduling System - Confirm");

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		lblSignUpCompleted = new JLabel("Sign up Completed!");
		lblSignUpCompleted.setBackground(Color.WHITE);
		lblSignUpCompleted.setFont(new Font("Segoe UI Light", Font.PLAIN, 23));
		lblSignUpCompleted.setBounds(115, 49, 193, 44);
		getContentPane().add(lblSignUpCompleted);
		
		btnYes = new JButton("go to Log in");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginUI();
				dispose();
			}
		});
		btnYes.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		btnYes.setBackground(new Color(0, 191, 255));
		btnYes.setBounds(120, 176, 183, 29);
		getContentPane().add(btnYes);
		
		lblWelcome = new JLabel("Welcome:)");
		lblWelcome.setFont(new Font("Segoe UI Light", Font.PLAIN, 23));
		lblWelcome.setBackground(Color.WHITE);
		lblWelcome.setBounds(157, 103, 110, 44);
		getContentPane().add(lblWelcome);

		this.setResizable(false);
		this.setVisible(true);
	}
}
