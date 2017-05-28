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
import UTIL.BlankCheck;
import VO.Users;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

/* 2017.05.23 È«±ÔÈñ*/
public class SignupUI extends JFrame {
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
	private int i, j = 0;
	private BlankCheck bCheck;

	public SignupUI() {
		cm = new ClientManager();
		bCheck = new BlankCheck();
		getContentPane().setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();

		int xPos = (dim.width / 4) - (this.getWidth() / 2);
		int yPos = (dim.height / 4) - (this.getHeight() / 2);

		this.setBounds(xPos, yPos, 860, 530);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("[COBEN] SCIT Studyroom Scheduling System - Sign up");

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		lblJoinUs = new JLabel("Join Us!");
		lblJoinUs.setBounds(375, 42, 104, 31);
		lblJoinUs.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
		getContentPane().add(lblJoinUs);
		this.setSize(860, 535);

		// ID
		lblId = new JLabel("ID");
		lblId.setBounds(362, 97, 18, 31);
		lblId.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblId.setBackground(Color.WHITE);
		getContentPane().add(lblId);

		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		textFieldID.setBounds(408, 107, 132, 21);
		getContentPane().add(textFieldID);
		textFieldID.setColumns(10);

		// PW
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(308, 138, 72, 31);
		lblPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		passwordField.setBounds(408, 148, 132, 21);
		getContentPane().add(passwordField);

		// Name
		lblName = new JLabel("name");
		lblName.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblName.setBackground(Color.WHITE);
		lblName.setBounds(337, 179, 43, 26);
		getContentPane().add(lblName);

		tfName = new JTextField();
		tfName.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		tfName.setColumns(10);
		tfName.setBounds(408, 184, 132, 21);
		getContentPane().add(tfName);

		// Gender
		lblGender = new JLabel("gender");
		lblGender.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblGender.setBounds(326, 215, 54, 31);
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

		// SocialNumber
		lblSocialNumber = new JLabel("social number");
		lblSocialNumber.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblSocialNumber.setBackground(Color.WHITE);
		lblSocialNumber.setBounds(270, 252, 110, 31);
		getContentPane().add(lblSocialNumber);

		tfSocialNumber = new JTextField();
		tfSocialNumber.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		tfSocialNumber.setColumns(10);
		tfSocialNumber.setBounds(408, 257, 132, 21);
		getContentPane().add(tfSocialNumber);

		// E-mail
		lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblEmail.setBounds(326, 295, 54, 18);
		getContentPane().add(lblEmail);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		tfEmail.setColumns(10);
		tfEmail.setBounds(408, 296, 132, 21);
		getContentPane().add(tfEmail);

		// Period
		lblPeriod = new JLabel("period");
		lblPeriod.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblPeriod.setBackground(Color.WHITE);
		lblPeriod.setBounds(326, 325, 54, 31);
		getContentPane().add(lblPeriod);

		cbPeriod = new JComboBox();
		cbPeriod.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		cbPeriod.setModel(new DefaultComboBoxModel(new String[] { "select", "33", "32", "31", "30", "29", "28", "27",
				"26", "25", "24", "23", "22", "21", "20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10",
				"9", "8", "7", "6", "5", "4", "3", "2", "1" }));
		cbPeriod.setEditable(true);
		cbPeriod.setBackground(Color.WHITE);
		cbPeriod.setBounds(408, 335, 132, 21);
		getContentPane().add(cbPeriod);

		// ClassABC
		lblClassabc = new JLabel("class");
		lblClassabc.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblClassabc.setBounds(337, 366, 43, 23);
		getContentPane().add(lblClassabc);

		cbClass = new JComboBox();
		cbClass.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		cbClass.setModel(new DefaultComboBoxModel(new String[] { "select", "A", "B", "C", "D" }));
		cbClass.setEditable(true);
		cbClass.setBackground(Color.WHITE);
		cbClass.setBounds(408, 368, 132, 21);
		getContentPane().add(cbClass);

		// SignUp Button
		btnSignUp = new JButton("sign up!");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (i == 1 && j == 1) {
					
					String password = passwordField.getText();
					String e_Mail = tfEmail.getText();
					String name = tfName.getText();
					String jumin = tfSocialNumber.getText();
					String id = textFieldID.getText();
					String classRoom = cbClass.getSelectedItem().toString();
					String period = cbPeriod.getSelectedItem().toString();
					String m_f = "";
					if(gender[0].isSelected()){
						m_f = gender[0].getText();						
					}else if(gender[1].isSelected()){
						m_f= gender[1].getText();
					}
					Users user = new Users(id, password, name, m_f , jumin, e_Mail, period, classRoom);
					if(cm.insertClient(user)==1){
						new SignUpWelcomePopUpUI();
						dispose();						
					}else{
						JOptionPane.showMessageDialog(null, "CHECK YOUR ID OR CHECK YOUR JUMIN");
					}
				} else if (i == 0) {
					JOptionPane.showMessageDialog(null, "CHECK YOUR SOCIAL NUMBER");
				} else if (j == 0) {
					JOptionPane.showMessageDialog(null, "CHECK YOUR ID");
				}
			}
		});

		// BtnSignup
		btnSignUp.setBounds(304, 435, 241, 31);
		btnSignUp.setBackground(new Color(0, 191, 255));
		btnSignUp.setFont(new Font("Segoe UI Light", Font.BOLD, 19));
		getContentPane().add(btnSignUp);

		JButton btnIDreset = new JButton("reset");
		btnIDreset.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnIDreset.setBackground(new Color(0, 191, 255));
		btnIDreset.setBounds(646, 107, 80, 21);
		getContentPane().add(btnIDreset);
		btnIDreset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				j = 0;
				textFieldID.setEditable(true);
				btnIDreset.setVisible(false);
			}
		});
		btnIDreset.setVisible(false);

		// BtnJuminReset
		JButton btnJuminReset = new JButton("reset");
		btnJuminReset.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnJuminReset.setBackground(new Color(0, 191, 255));
		btnJuminReset.setBounds(646, 257, 80, 21);
		getContentPane().add(btnJuminReset);
		btnIDreset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				i = 0;
				tfSocialNumber.setEditable(true);
				btnJuminReset.setVisible(false);
			}
		});
		btnJuminReset.setVisible(false);

		// Back button
		btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoginUI();
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		btnBack.setBackground(new Color(0, 191, 255));
		btnBack.setBounds(732, 466, 110, 31);
		getContentPane().add(btnBack);

		btnRedundancyCheckForID = new JButton("check");
		btnRedundancyCheckForID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = textFieldID.getText();
				if (id != null) {
					if(bCheck.Check(id)==false){
						Users result = cm.selectOneClient(id);
						if (result == null) {
							JOptionPane.showMessageDialog(null, "ID AVAILABLE");
							j = 1;
							textFieldID.setEditable(false);
							btnIDreset.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "ID UNAVAILABLE, PLEASE TRY AGAIN");
							textFieldID.setText("");
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "SPACES NOT ALLOWED");
					}
				} else {
					JOptionPane.showMessageDialog(null, "PLEASE ENTER YOUR ID FIRST");
				}
			}
		});
		btnRedundancyCheckForID.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnRedundancyCheckForID.setBackground(new Color(0, 191, 255));
		btnRedundancyCheckForID.setBounds(554, 107, 80, 21);
		getContentPane().add(btnRedundancyCheckForID);

		btnRedundancyCheckForJumin = new JButton("check");
		btnRedundancyCheckForJumin.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		btnRedundancyCheckForJumin.setBackground(new Color(0, 191, 255));
		btnRedundancyCheckForJumin.setBounds(554, 257, 80, 21);
		getContentPane().add(btnRedundancyCheckForJumin);

		btnRedundancyCheckForJumin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String jumin = tfSocialNumber.getText();
				if (jumin != null) {
					if (bCheck.Check(jumin) == false) {
						Users result = cm.equalJumin(jumin);
						if (result == null) {
							JOptionPane.showMessageDialog(null, "SOCIAL NUMBER AVAILABLE");
							i = 1;
							tfSocialNumber.setEditable(false);
							btnJuminReset.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "SOCIAL NUMBER ALREADY USED, PLEASE INPUT ANOTHER NUMBER");
							tfSocialNumber.setText("");
						}
					} else { // (bCheck.Check(jumin) == true -> ½ºÆäÀÌ½º »ç¿ëµÊ)
						JOptionPane.showMessageDialog(null, "SPACES NOT ALLOWED");
					}
				} else { // (jumin == null)
					JOptionPane.showMessageDialog(null, "ENTER SOCIAL NUMBER");
				}
			}

		});

		this.setResizable(false);
		this.setVisible(true);
	}
}