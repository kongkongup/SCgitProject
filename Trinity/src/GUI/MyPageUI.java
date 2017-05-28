package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Client.ClientManager;
import VO.Reservation_Log;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/* 2017.05.23 홍규희*/
public class MyPageUI extends JFrame {
	private ClientManager cm;
	private JTextField tfID;
	private String[] cName = { "NUM", "ID", "Date", "Start", "End", "RoomName", "Purpose"};
	private DefaultTableModel tableModel = new DefaultTableModel(cName, 0);
	
	 



	/*
	 * public JPasswordField getTfPassword() { return tfPassword; }
	 * 
	 * public void setTfPassword(JPasswordField tfPassword) { this.tfPassword =
	 * tfPassword; }
	 * 
	 * public JTextField getTfName() { return tfName; }
	 * 
	 * public void setTfName(JTextField tfName) { this.tfName = tfName; }
	 * 
	 * public JTextField getTfEmail() { return tfEmail; }
	 * 
	 * public void setTfEmail(JTextField tfEmail) { this.tfEmail = tfEmail; }
	 */
	private JPasswordField tfPassword;
	private JTextField tfName;
	private JTextField tfSocialNumber;
	private JTextField tfEmail;
	private JTable table;

	public MyPageUI(String id) {
		cm = new ClientManager();

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();

		int xPos = (dim.width / 4) - (this.getWidth() / 2);
		int yPos = (dim.height / 4) - (this.getHeight() / 2);

		this.setBounds(xPos, yPos, 860, 530);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("[COBEN] SCIT Studyroom Scheduling System - My page");

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel lblJoinUs = new JLabel("My Page");
		lblJoinUs.setBounds(475, 23, 99, 49);
		lblJoinUs.setFont(new Font("Segoe UI Light", Font.BOLD, 25));
		getContentPane().add(lblJoinUs);
		this.setSize(1056, 535);

		// ID
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(116, 93, 26, 31);
		lblId.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblId.setBackground(Color.WHITE);
		getContentPane().add(lblId);

		tfID = new JTextField(cm.selectOneClient(id).getUser_ID());
		tfID.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		tfID.setBounds(156, 96, 132, 21);
		getContentPane().add(tfID);
		tfID.setColumns(10);
		tfID.setEditable(false);

		// PW
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(59, 134, 83, 31);
		lblPassword.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		getContentPane().add(lblPassword);

		tfPassword = new JPasswordField(cm.selectOneClient(id).getPassword());
		tfPassword.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		tfPassword.setBounds(156, 133, 132, 21);
		getContentPane().add(tfPassword);
		tfPassword.setEditable(false);

		// Name
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblName.setBackground(Color.WHITE);
		lblName.setBounds(91, 175, 51, 26);
		getContentPane().add(lblName);

		tfName = new JTextField(cm.selectOneClient(id).getName());
		tfName.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		tfName.setColumns(10);
		tfName.setBounds(156, 175, 132, 21);
		getContentPane().add(tfName);
		tfName.setEditable(false);

		// Gender
		JLabel lblGender = new JLabel("gender");
		lblGender.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblGender.setBounds(78, 211, 64, 31);
		getContentPane().add(lblGender);

		JRadioButton rdbtnGenderM = new JRadioButton("M");
		rdbtnGenderM.setBackground(Color.WHITE);
		rdbtnGenderM.setBounds(163, 214, 37, 23);
		getContentPane().add(rdbtnGenderM);

		JRadioButton rdbtnGenderF = new JRadioButton("F");
		rdbtnGenderF.setBackground(Color.WHITE);
		rdbtnGenderF.setBounds(223, 214, 37, 23);
		getContentPane().add(rdbtnGenderF);

		// SocialNumber
		JLabel lblSocialNumber = new JLabel("social number");
		lblSocialNumber.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblSocialNumber.setBackground(Color.WHITE);
		lblSocialNumber.setBounds(26, 252, 116, 31);
		getContentPane().add(lblSocialNumber);

		tfSocialNumber = new JTextField(cm.selectOneClient(id).getJumin());
		tfSocialNumber.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		tfSocialNumber.setColumns(10);
		tfSocialNumber.setBounds(156, 251, 132, 21);
		getContentPane().add(tfSocialNumber);
		tfSocialNumber.setEditable(false);

		// E-mail
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblEmail.setBounds(78, 293, 64, 18);
		getContentPane().add(lblEmail);

		tfEmail = new JTextField(cm.selectOneClient(id).getE_Mail());
		tfEmail.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		tfEmail.setColumns(10);
		tfEmail.setBounds(156, 288, 132, 21);
		getContentPane().add(tfEmail);
		tfEmail.setEditable(false);

		// Period
		JLabel lblPeriod = new JLabel("period");
		lblPeriod.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblPeriod.setBackground(Color.WHITE);
		lblPeriod.setBounds(78, 321, 64, 31);
		getContentPane().add(lblPeriod);

		JComboBox cbPeriod = new JComboBox();
		cbPeriod.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		cbPeriod.setEnabled(false);
		cbPeriod.setBounds(156, 327, 132, 21);
		cbPeriod.setBackground(Color.WHITE);
		cbPeriod.setModel(new DefaultComboBoxModel(new String[] { "-", "33", "32", "31", "30", "29", "28", "27", "26",
				"25", "24", "23", "22", "21", "20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "9",
				"8", "7", "6", "5", "4", "3", "2", "1" }));
		getContentPane().add(cbPeriod);

		// ClassABC
		JLabel lblClassabc = new JLabel("class");
		lblClassabc.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
		lblClassabc.setBounds(91, 362, 51, 23);
		getContentPane().add(lblClassabc);

		JComboBox cbClass = new JComboBox();
		cbClass.setFont(new Font("Segoe UI Light", Font.BOLD, 15));
		cbClass.setEnabled(false);
		cbClass.setBounds(156, 364, 132, 21);
		cbClass.setBackground(Color.WHITE);
		cbClass.setModel(new DefaultComboBoxModel(new String[] { "Select your class", "A", "B", "C", "D" }));
		cbClass.setEditable(false);
		getContentPane().add(cbClass);

		// 뒤로가기 버튼
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ShowRoomsUI(id);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		btnBack.setBackground(new Color(0, 191, 255));
		btnBack.setBounds(926, 459, 110, 31);
		getContentPane().add(btnBack);

		// 예약로그
		JLabel lblReservationLog = new JLabel("My Reservation Log");
		lblReservationLog.setFont(new Font("Segoe UI Light", Font.PLAIN, 19));
		lblReservationLog.setBounds(326, 91, 220, 31);
		getContentPane().add(lblReservationLog);
		ArrayList<Reservation_Log> list = cm.selectOneUserAllLogs(id);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(326, 136, 683, 251);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		ArrayList<Reservation_Log> result = new ArrayList<>();
		result = cm.selectOneUserAllLogs(id);
		for (Reservation_Log reservation_Log : result) {
			tableModel.addRow(reservation_Log.toArray());
		}
		
		

		// 수정 버튼
		JButton btnModify = new JButton("modify");
		btnModify.setBackground(new Color(0, 191, 255));
		btnModify.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		btnModify.setBounds(183, 398, 105, 30);
		getContentPane().add(btnModify);

		// 수정확인 버튼
		JButton btnOK = new JButton("OK");
		btnOK.setBackground(new Color(0, 191, 255));
		btnOK.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		btnOK.setBounds(183, 438, 105, 30);
		btnOK.setVisible(false);
		getContentPane().add(btnOK);

		btnModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tfPassword.setEditable(true);
				tfName.setEditable(true);
				tfEmail.setEditable(true);
				cbPeriod.setEnabled(true);
				cbClass.setEnabled(true);
				btnOK.setVisible(true);
			}
		});

		// 취소 버튼
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnCancel.setFont(new Font("Segoe UI Light", Font.BOLD, 17));
		btnCancel.setBackground(new Color(0, 191, 255));
		btnCancel.setBounds(877, 399, 132, 30);
		getContentPane().add(btnCancel);

		this.setResizable(false);
		this.setVisible(true);
	}
}