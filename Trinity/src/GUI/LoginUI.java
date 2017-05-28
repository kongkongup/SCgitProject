package GUI;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Client.ClientManager;

import java.awt.Color;
import java.awt.Font;

/* 2017.05.23 È«±ÔÈñ*/
public class LoginUI extends JFrame {
	private JTextField tfID;
	private JPasswordField passwordField;
	private JButton btnSignUp;
	private JButton btnLogin;
	private ClientManager cm;

	public static void main(String[] args) {
		new LoginUI();
	}
	
	public LoginUI() {
		cm = new ClientManager();
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();

		int xPos = (dim.width / 4) - (this.getWidth() / 2);
		int yPos = (dim.height / 4) - (this.getHeight() / 2);

		this.setBounds(xPos, yPos, 860, 530);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("[COBEN] SCIT Studyroom Scheduling System - Log in");

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		// Logo
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 46, 424, 383);
		lblLogo.setIcon(new ImageIcon("./pic/logo.png"));
		getContentPane().add(lblLogo);

		// ID
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(492, 155, 42, 21);
		lblId.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		lblId.setBackground(Color.WHITE);
		getContentPane().add(lblId);
		
		tfID = new JTextField();
		tfID.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		tfID.setBounds(534, 155, 132, 21);
		getContentPane().add(tfID);
		tfID.setColumns(10);

		// PW
		JLabel lblPassword = new JLabel("PassWord");
		lblPassword.setBounds(442, 186, 92, 18);
		lblPassword.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		passwordField.setBounds(534, 183, 132, 21);
		getContentPane().add(passwordField);

		// LogInButton
		btnLogin = new JButton("Log In");
		btnLogin.setBounds(678, 155, 87, 29);
		btnLogin.setBackground(new Color(0, 191, 255));
		btnLogin.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		getContentPane().add(btnLogin);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					String id = tfID.getText();
					String password = passwordField.getText();
					int result = cm.login(id, password);
					if(result==1){
						JOptionPane.showMessageDialog(null, "LOGIN SUCCESS");
						ShowRoomsUI ui = new ShowRoomsUI(id);
						dispose();
					}else if (result == 0){
						JOptionPane.showMessageDialog(null, "ID Doesn't Exist");
					}else if(result == 2){
						JOptionPane.showMessageDialog(null, "ID OR PASSWORD INCORRECT");
					}
				} 
				
			
		});

		// SignUpButton
		JLabel lblJoinUs = new JLabel("Join Us!");
		lblJoinUs.setBounds(596, 245, 88, 31);
		lblJoinUs.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		getContentPane().add(lblJoinUs);
		this.setSize(860, 535);
		btnLogin.setBounds(678, 147, 132, 58);

		btnSignUp = new JButton("sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignupUI su = new SignupUI();
				dispose();
			}
		});
		btnSignUp.setBounds(696, 245, 114, 30);
		btnSignUp.setBackground(new Color(0, 191, 255));
		btnSignUp.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		getContentPane().add(btnSignUp);
		
		// ExitButton
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnExit.setBackground(new Color(0, 191, 255));
		btnExit.setBounds(742, 464, 100, 31);
		getContentPane().add(btnExit);

		// Background
		JLabel lblBackgroundImage = new JLabel("");
		lblBackgroundImage.setFont(new Font("Instruction", Font.BOLD, 15));
		lblBackgroundImage.setIcon(new ImageIcon("./pic/background.jpg"));
		lblBackgroundImage.setBounds(0, 0, 854, 506);
		getContentPane().add(lblBackgroundImage);

		this.setResizable(false);
		this.setVisible(true);
	}
}
