package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Client.ClientManager;
import VO.Users;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

/* 2017.05.23 È«±ÔÈñ*/
public class SignupUI extends JFrame{
	private JTextField textFieldID;
	private JPasswordField passwordField;
	private JTextField tfName;
	private JTextField tfSocialNumber;
	private JTextField tfEmail;
	private JLabel lblJoinUs;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblGender;
	private JLabel lblSocialNumber;
	private JLabel lblEmail;
	private JLabel lblPeriod;
	private JComboBox<Integer> cbPeriod;
	private JLabel lblClassabc;
	private JComboBox<String> cbClass;
	private JButton btnSignUp;
	private JButton btnBack;
	private JButton btnRedundancyCheckForID;
	private JButton btnRedundancyCheckForJumin;
	private ButtonGroup bg;
	private ClientManager cm;

	public SignupUI() {
		cm = new ClientManager();
		getContentPane().setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 11));
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		
		int xPos = (dim.width / 4) - (this.getWidth()/2);
		int yPos = (dim.height / 4) - (this.getHeight()/2);
		
		this.setBounds(xPos, yPos, 860, 530);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("[COBEN] SCIT Studyroom Scheduling System - Sign up");
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		lblJoinUs = new JLabel("Join Us!");
		lblJoinUs.setBounds(375, 23, 104, 31);
		lblJoinUs.setFont(new Font("Instruction", Font.BOLD, 22));
		getContentPane().add(lblJoinUs);
		this.setSize(860, 535);
		
		//ID
		lblId = new JLabel("ID");
		lblId.setBounds(369, 92, 18, 31);
		lblId.setFont(new Font("Instruction", Font.BOLD, 15));
		lblId.setBackground(Color.WHITE);
		getContentPane().add(lblId);

		textFieldID = new JTextField();
		textFieldID.setBounds(413, 100, 132, 21);
		getContentPane().add(textFieldID);
		textFieldID.setColumns(10);
		
		//PW
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(315, 129, 72, 31);
		lblPassword.setFont(new Font("Instruction", Font.BOLD, 15));
		getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(413, 137, 132, 21);
		getContentPane().add(passwordField);

		//Name
		lblName = new JLabel("name");
		lblName.setFont(new Font("Instruction", Font.BOLD, 15));
		lblName.setBackground(Color.WHITE);
		lblName.setBounds(348, 173, 39, 26);
		getContentPane().add(lblName);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(413, 179, 132, 21);
		getContentPane().add(tfName);
		
		//Gender
		lblGender = new JLabel("gender");
		lblGender.setFont(new Font("Instruction", Font.BOLD, 15));
		lblGender.setBounds(333, 209, 54, 31);
		getContentPane().add(lblGender);
		
		bg = new ButtonGroup();
		JRadioButton[] gender = new JRadioButton[2];
		gender[0] = new JRadioButton("M");
		gender[0].setBackground(Color.WHITE);
		gender[0].setBounds(426, 215, 37, 23);
		
		gender[1] = new JRadioButton("F");
		gender[1].setBackground(Color.WHITE);
		gender[1].setBounds(486, 215, 37, 23);
		
		bg.add(gender[0]);
		bg.add(gender[1]);
		
		getContentPane().add(gender[0]);
		getContentPane().add(gender[1]);
		
		//SocialNumber
		lblSocialNumber = new JLabel("social number");
		lblSocialNumber.setFont(new Font("Instruction", Font.BOLD, 15));
		lblSocialNumber.setBackground(Color.WHITE);
		lblSocialNumber.setBounds(270, 248, 117, 31);
		getContentPane().add(lblSocialNumber);
		
		tfSocialNumber = new JTextField();
		tfSocialNumber.setColumns(10);
		tfSocialNumber.setBounds(413, 255, 132, 21);
		getContentPane().add(tfSocialNumber);
		
		//E-mail
		lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Instruction", Font.BOLD, 15));
		lblEmail.setBounds(333, 291, 54, 18);
		getContentPane().add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(413, 292, 132, 21);
		getContentPane().add(tfEmail);
		
		//Period
		lblPeriod = new JLabel("period");
		lblPeriod.setFont(new Font("Instruction", Font.BOLD, 15));
		lblPeriod.setBackground(Color.WHITE);
		lblPeriod.setBounds(333, 324, 54, 31);
		getContentPane().add(lblPeriod);
		
		cbPeriod = new JComboBox();
		cbPeriod.setModel(new DefaultComboBoxModel(new String[] {"select", "33", "32", "31", "30", "29", "28", "27", "26", "25", "24", "23", "22", "21", "20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"}));
		cbPeriod.setEditable(true);
		cbPeriod.setBackground(Color.WHITE);
		cbPeriod.setBounds(413, 331, 132, 21);
		getContentPane().add(cbPeriod);
		
		//ClassABC
		lblClassabc = new JLabel("classABC");
		lblClassabc.setFont(new Font("Instruction", Font.BOLD, 15));
		lblClassabc.setBounds(315, 365, 72, 23);
		getContentPane().add(lblClassabc);
		
		cbClass = new JComboBox();
		cbClass.setModel(new DefaultComboBoxModel(new String[] {"select", "A", "B", "C", "D"}));
		cbClass.setEditable(true);
		cbClass.setBackground(Color.WHITE);
		cbClass.setBounds(413, 368, 132, 21);
		getContentPane().add(cbClass);
		
		//SignUp Button
		btnSignUp = new JButton("sign up!");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUpWelcomePopUpUI();
				dispose();
			}
		});
		
		btnSignUp.setBounds(304, 435, 241, 31);
		btnSignUp.setBackground(new Color(0, 191, 255));
		btnSignUp.setFont(new Font("Instruction", Font.BOLD, 14));
		getContentPane().add(btnSignUp);
		
		//Back button
		btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoginUI();
				dispose();
			}
		});
		btnBack.setFont(new Font("Instruction", Font.BOLD, 14));
		btnBack.setBackground(new Color(0, 191, 255));
		btnBack.setBounds(732, 466, 110, 31);
		getContentPane().add(btnBack);
		
		btnRedundancyCheckForID = new JButton("check");
		btnRedundancyCheckForID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textFieldID.getText();
				if(id!=null){
					Users result = cm.selectOneClient(id);
					if(result==null){
						JOptionPane.showMessageDialog(null, "ID AVAILABLE");
					}else{
						JOptionPane.showMessageDialog(null, "ID UNAVAILABLE, PLEASE TRY AGAIN");
						textFieldID.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(null, "PLEASE ENTER YOUR ID FIRST");
				}
			}
		});
		btnRedundancyCheckForID.setFont(new Font("Instruction", Font.BOLD, 12));
		btnRedundancyCheckForID.setBackground(new Color(0, 191, 255));
		btnRedundancyCheckForID.setBounds(554, 99, 80, 21);
		getContentPane().add(btnRedundancyCheckForID);
		
		btnRedundancyCheckForJumin = new JButton("check");
		btnRedundancyCheckForJumin.setFont(new Font("Instruction", Font.BOLD, 12));
		btnRedundancyCheckForJumin.setBackground(new Color(0, 191, 255));
		btnRedundancyCheckForJumin.setBounds(554, 254, 80, 21);
		getContentPane().add(btnRedundancyCheckForJumin);
		
		btnRedundancyCheckForJumin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String jumin = tfSocialNumber.getText();
				if(jumin!=null){
					Users result = cm.equalJumin(jumin);
					if(result==null){
						JOptionPane.showMessageDialog(null, "SOCIAL.No AVAILABLE");
					}else{
						JOptionPane.showMessageDialog(null, "SOCIAL.No ALREADY USED, PLEASE INPUT ANOTHER NUMBER");
						tfSocialNumber.setText("");
					}
				}else{
					JOptionPane.showMessageDialog(null, "PLEASE ENTER YOUR SOCIAL.No FIRST");
				}
			}
		});
		
		this.setResizable(false);
		this.setVisible(true);
	}
}