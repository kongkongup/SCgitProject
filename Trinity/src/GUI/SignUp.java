package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;


public class SignUp extends JFrame {
	private JPasswordField passwordField;
	private JTextField ID_tf;
	private JTextField Tel_tf;
	private JTextField Birth_tf;
	private JTextField Email_tf;
	
	public SignUp() {
		getContentPane().setBackground(SystemColor.activeCaption);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 220));
		panel_1.setForeground(new Color(255, 248, 220));
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel Title = new JLabel("WELCOME MY NEW FRIEND");
		Title.setBounds(14, 12, 443, 44);
		panel_1.add(Title);
		Title.setFont(new Font("HY°­M", Font.BOLD, 19));
		
		JLabel id = new JLabel("ID?");
		id.setBounds(15, 68, 117, 24);
		panel_1.add(id);
		
		ID_tf = new JTextField();
		ID_tf.setColumns(10);
		ID_tf.setBounds(114, 68, 181, 24);
		panel_1.add(ID_tf);
		
		JLabel password = new JLabel("PASSWORD?");
		password.setBounds(15, 121, 117, 24);
		panel_1.add(password);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(114, 121, 181, 24);
		panel_1.add(passwordField);
		
		JLabel F_M = new JLabel("Male?Female?");
		F_M.setBounds(14, 235, 117, 24);
		panel_1.add(F_M);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(114, 237, 117, 24);
		panel_1.add(comboBox);
		
		JLabel Tel = new JLabel("Tel?");
		Tel.setBounds(15, 177, 117, 24);
		panel_1.add(Tel);
		
		Tel_tf = new JTextField();
		Tel_tf.setBounds(114, 177, 181, 24);
		panel_1.add(Tel_tf);
		Tel_tf.setColumns(10);
		
		JLabel BirthDate = new JLabel("Birth Date?");
		BirthDate.setBounds(14, 292, 117, 24);
		panel_1.add(BirthDate);
		
		Birth_tf = new JTextField();
		Birth_tf.setBounds(114, 295, 181, 24);
		panel_1.add(Birth_tf);
		Birth_tf.setColumns(10);
		
		JLabel Email = new JLabel("E-MAIL?");
		Email.setBounds(14, 351, 117, 24);
		panel_1.add(Email);
		
		Email_tf = new JTextField();
		Email_tf.setColumns(10);
		Email_tf.setBounds(114, 349, 181, 24);
		panel_1.add(Email_tf);
		
		JLabel lblNewLabel = new JLabel("(Only NUMBER Please)");
		lblNewLabel.setBounds(299, 177, 158, 24);
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton OK = new JButton("OK");
		panel.add(OK);
		
		JButton CANCLE = new JButton("CANCLE");
		panel.add(CANCLE);
	}
	

}
