package GUI;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

/* 2017.05.23 홍규희*/
public class RoomConfirmUI extends JFrame {
	private JTextField tfDateFromDB;
	private JTextField tfStartTime;
	private JTextField tfEndTime;
	private JTextField textField;

/*	public static void main(String[] args) {
		new RoomConfirmUI();
	}*/
	
	public RoomConfirmUI() {
		getContentPane().setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();

		int xPos = (dim.width / 4) - (this.getWidth() / 2);
		int yPos = (dim.height / 4) - (this.getHeight() / 2);

		this.setBounds(xPos, yPos, 860, 530);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("[COBEN] SCIT Studyroom Scheduling System - Confirm");

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		this.setSize(860, 535);
		
		//예약 확인하세요!
		JLabel lblConfirm = new JLabel("Confirm Your Reservation!");
		lblConfirm.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 20));
		lblConfirm.setBackground(Color.WHITE);
		lblConfirm.setBounds(299, 10, 256, 58);
		getContentPane().add(lblConfirm);
		
		//방이름
		JLabel lblRoomName = new JLabel("DB- studyRoom name");
		lblRoomName.setBackground(Color.WHITE);
		lblRoomName.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblRoomName.setBounds(269, 78, 256, 37);
		getContentPane().add(lblRoomName);
		
		//배정된 교실
		JLabel lblClass = new JLabel("Assigned to Class");
		lblClass.setBackground(Color.WHITE);
		lblClass.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblClass.setBounds(269, 125, 160, 37);
		getContentPane().add(lblClass);
		
		//수용인원
		JLabel lblOccupancy = new JLabel("Occupancy");
		lblOccupancy.setBackground(Color.WHITE);
		lblOccupancy.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblOccupancy.setBounds(269, 172, 96, 37);
		getContentPane().add(lblOccupancy);
		
		//기타
		JLabel lblOthers = new JLabel("Others");
		lblOthers.setBackground(Color.WHITE);
		lblOthers.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblOthers.setBounds(269, 219, 63, 37);
		getContentPane().add(lblOthers);
		
		//예약자 이름
		JLabel lblDbUserName = new JLabel("user_name from db");
		lblDbUserName.setBackground(Color.WHITE);
		lblDbUserName.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblDbUserName.setBounds(269, 266, 259, 31);
		getContentPane().add(lblDbUserName);
		
		//예약 일자
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblDate.setBounds(569, 101, 63, 31);
		getContentPane().add(lblDate);
		
		/*JSpinner spinner = new JSpinner((SpinnerModel) null);
		spinner.setBounds(256, 340, 86, 37);
		getContentPane().add(spinner);*/
		
		//예약 시간
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblStartTime.setBounds(569, 161, 97, 31);
		getContentPane().add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblEndTime.setBounds(569, 221, 97, 31);
		getContentPane().add(lblEndTime);
		
		//확인 버튼
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setToolTipText("confirm and send to E-mail");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RoomConfirmPopUpUI();
				dispose();
			}
		});
		btnConfirm.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		btnConfirm.setBackground(new Color(0, 191, 255));
		btnConfirm.setBounds(299, 413, 256, 44);
		getContentPane().add(btnConfirm);

		// Back button
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
		btnBack.setBounds(742, 464, 100, 31);
		getContentPane().add(btnBack);
		
		JLabel lblUse = new JLabel("Use");
		lblUse.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblUse.setBackground(Color.WHITE);
		lblUse.setBounds(269, 335, 33, 31);
		getContentPane().add(lblUse);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.WHITE);
		textPane.setBounds(311, 313, 231, 79);
		getContentPane().add(textPane);
		
		tfDateFromDB = new JTextField();
		tfDateFromDB.setEnabled(false);
		tfDateFromDB.setEditable(false);
		tfDateFromDB.setBounds(569, 130, 136, 21);
		getContentPane().add(tfDateFromDB);
		tfDateFromDB.setColumns(10);
		
		tfStartTime = new JTextField();
		tfStartTime.setEnabled(false);
		tfStartTime.setEditable(false);
		tfStartTime.setColumns(10);
		tfStartTime.setBounds(569, 192, 136, 21);
		getContentPane().add(tfStartTime);
		
		tfEndTime = new JTextField();
		tfEndTime.setEnabled(false);
		tfEndTime.setEditable(false);
		tfEndTime.setColumns(10);
		tfEndTime.setBounds(569, 251, 136, 21);
		getContentPane().add(tfEndTime);
		
		textField = new JTextField();
		textField.setBounds(310, 309, 245, 83);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		this.setResizable(false);
		this.setVisible(true);
	}
}
