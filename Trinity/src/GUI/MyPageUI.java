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
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTextArea;

/* 2017.05.23 홍규희*/
public class MyPageUI extends JFrame{
	private JTextField tfID;

	public JPasswordField getTfPassword() {
		return tfPassword;
	}

	public void setTfPassword(JPasswordField tfPassword) {
		this.tfPassword = tfPassword;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	private JPasswordField tfPassword;
	private JTextField tfName;
	private JTextField tfSocialNumber;
	private JTextField tfEmail;


	public MyPageUI() {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		
		int xPos = (dim.width / 4) - (this.getWidth()/2);
		int yPos = (dim.height / 4) - (this.getHeight()/2);
		
		this.setBounds(xPos, yPos, 860, 530);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("[COBEN] SCIT Studyroom Scheduling System - My page");
		
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblJoinUs = new JLabel("My Page");
		lblJoinUs.setBounds(372, 23, 110, 49);
		lblJoinUs.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 25));
		getContentPane().add(lblJoinUs);
		this.setSize(860, 535);
		
		//ID
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(164, 92, 30, 31);
		lblId.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblId.setBackground(Color.WHITE);
		getContentPane().add(lblId);

		tfID = new JTextField("DB에서 가져오기");
		tfID.setBounds(206, 97, 132, 21);
		getContentPane().add(tfID);
		tfID.setColumns(10);
		tfID.setEditable(false);
		
		//PW
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(97, 129, 97, 31);
		lblPassword.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		getContentPane().add(lblPassword);

		tfPassword = new JPasswordField("DB에서 가져오기");
		tfPassword.setBounds(206, 134, 132, 21);
		getContentPane().add(tfPassword);
		tfPassword.setEditable(false);
		
		//Name
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblName.setBackground(Color.WHITE);
		lblName.setBounds(130, 173, 64, 26);
		getContentPane().add(lblName);
		
		tfName = new JTextField("DB에서 가져오기");
		tfName.setColumns(10);
		tfName.setBounds(206, 176, 132, 21);
		getContentPane().add(tfName);
		tfName.setEditable(false);
		
		//Gender
		JLabel lblGender = new JLabel("gender");
		lblGender.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblGender.setBounds(122, 208, 72, 31);
		getContentPane().add(lblGender);
		
		JRadioButton rdbtnGenderM = new JRadioButton("M");
		rdbtnGenderM.setBackground(Color.WHITE);
		rdbtnGenderM.setBounds(219, 215, 37, 23);
		getContentPane().add(rdbtnGenderM);
		
		JRadioButton rdbtnGenderF = new JRadioButton("F");
		rdbtnGenderF.setBackground(Color.WHITE);
		rdbtnGenderF.setBounds(279, 215, 37, 23);
		getContentPane().add(rdbtnGenderF);
		
		//SocialNumber
		JLabel lblSocialNumber = new JLabel("social number");
		lblSocialNumber.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblSocialNumber.setBackground(Color.WHITE);
		lblSocialNumber.setBounds(62, 247, 132, 31);
		getContentPane().add(lblSocialNumber);
		
		tfSocialNumber = new JTextField("DB에서 가져오기");
		tfSocialNumber.setColumns(10);
		tfSocialNumber.setBounds(206, 252, 132, 21);
		getContentPane().add(tfSocialNumber);
		tfSocialNumber.setEditable(false);

		//E-mail
		JLabel lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblEmail.setBounds(130, 290, 64, 18);
		getContentPane().add(lblEmail);
		
		tfEmail = new JTextField("DB에서 가져오기");
		tfEmail.setColumns(10);
		tfEmail.setBounds(206, 289, 132, 21);
		getContentPane().add(tfEmail);
		tfEmail.setEditable(false);
		
		//Period
		JLabel lblPeriod = new JLabel("period");
		lblPeriod.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblPeriod.setBackground(Color.WHITE);
		lblPeriod.setBounds(130, 323, 64, 31);
		getContentPane().add(lblPeriod);
		
		JComboBox cbPeriod = new JComboBox();
		cbPeriod.setEnabled(false);
		cbPeriod.setBounds(206, 328, 132, 21);
		cbPeriod.setBackground(Color.WHITE);
		cbPeriod.setModel(new DefaultComboBoxModel(new String[] {"-", "33", "32", "31", "30", "29", "28", "27", "26", "25", "24", "23", "22", "21", "20", "19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"}));
		getContentPane().add(cbPeriod);
		
		//ClassABC
		JLabel lblClassabc = new JLabel("classABC");
		lblClassabc.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblClassabc.setBounds(107, 364, 87, 23);
		getContentPane().add(lblClassabc);
		
		JComboBox cbClass = new JComboBox();
		cbClass.setEnabled(false);
		cbClass.setBounds(206, 365, 132, 21);
		cbClass.setBackground(Color.WHITE);
		cbClass.setModel(new DefaultComboBoxModel(new String[] {"Select your class", "A", "B", "C", "D"}));
		cbClass.setEditable(false);
		getContentPane().add(cbClass);
		
		//뒤로가기 버튼
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ShowRoomsUI();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnBack.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		btnBack.setBackground(new Color(0, 191, 255));
		btnBack.setBounds(732, 465, 110, 31);
		getContentPane().add(btnBack);
		
		//예약로그
		JLabel lblReservationLog = new JLabel("My Reservation Log");
		lblReservationLog.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblReservationLog.setBounds(485, 82, 171, 54);
		getContentPane().add(lblReservationLog);
		
		JTextArea txtReservationLog = new JTextArea();
		txtReservationLog.setBackground(Color.WHITE);
		txtReservationLog.setText("DB\uC5D0\uC11C \uAC00\uC838\uC624\uAE30. \uC544\uC9C1 \uC624\uC9C0 \uC54A\uC740 \uC77C\uC815\uC5D0 \uB300\uD574\uC11C\uB294 \uCDE8\uC18C \uAC00\uB2A5");
		txtReservationLog.setBounds(485, 136, 254, 251);
		getContentPane().add(txtReservationLog);
		
		//수정 버튼
		JButton btnModify = new JButton("modify");
		btnModify.setBackground(new Color(0, 191, 255));
		btnModify.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		btnModify.setBounds(233, 399, 105, 30);
		getContentPane().add(btnModify);
		
			//수정확인 버튼
			JButton btnOK = new JButton("OK");
			btnOK.setBackground(new Color(0, 191, 255));
			btnOK.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 16));
			btnOK.setBounds(233, 439, 105, 30);
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
		
		//취소 버튼
		JButton btnCancel = new JButton("cancel");
		btnCancel.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		btnCancel.setBackground(new Color(0, 191, 255));
		btnCancel.setBounds(632, 399, 105, 30);
		getContentPane().add(btnCancel);
		
		this.setResizable(false);
		this.setVisible(true);
	}
}