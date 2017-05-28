package GUI;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Client.ClientManager;
import VO.Reservation_Log;

import java.awt.Color;
import java.awt.Font;

/* 2017.05.23 홍규희*/
public class RoomConfirmUI extends JFrame {
	private JTextField textField;

/*	public static void main(String[] args) {
		new RoomConfirmUI();
	}*/
	
	public RoomConfirmUI(String id,String room_name,int start_time,
			int end_time, String date) {
		
		ClientManager cm = new ClientManager();
		getContentPane().setFont(new Font("Consolas", Font.BOLD, 20));

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
		lblConfirm.setFont(new Font("Segoe UI Light", Font.PLAIN, 27));
		lblConfirm.setBackground(Color.WHITE);
		lblConfirm.setBounds(278, 10, 297, 58);
		getContentPane().add(lblConfirm);
		
		//방이름
		JLabel lblRoomName = new JLabel(room_name);
		lblRoomName.setBackground(Color.WHITE);
		lblRoomName.setFont(new Font("Segoe UI Light", Font.PLAIN, 22));
		lblRoomName.setBounds(297, 80, 259, 37);
		getContentPane().add(lblRoomName);
		
		//예약자 이름
		JLabel lblDbUserName = new JLabel("[ ID ] "+id);
		lblDbUserName.setBackground(Color.WHITE);
		lblDbUserName.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblDbUserName.setBounds(297, 136, 259, 31);
		getContentPane().add(lblDbUserName);
		
		//예약 일자
		JLabel lblDate = new JLabel("[ Date ] "+date);
		lblDate.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblDate.setBounds(297, 186, 259, 31);
		getContentPane().add(lblDate);
		
		/*JSpinner spinner = new JSpinner((SpinnerModel) null);
		spinner.setBounds(256, 340, 86, 37);
		getContentPane().add(spinner);*/
		
		//예약 시간
		JLabel lblStartTime = new JLabel("[ Start Time ] "+start_time+" : 00");
		lblStartTime.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblStartTime.setBounds(297, 236, 259, 31);
		getContentPane().add(lblStartTime);
		
		JLabel lblEndTime = new JLabel("[ End Time ] "+end_time+" : 00");
		lblEndTime.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblEndTime.setBounds(297, 286, 259, 31);
		getContentPane().add(lblEndTime);
		
		//확인 버튼
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setToolTipText("confirm and send to E-mail");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField!=null){
					Reservation_Log log = new Reservation_Log(id, room_name, start_time, end_time, textField.getText(), date);
					cm.reservation(log);
					new RoomConfirmPopUpUI(id);
					dispose();					
				}else{
					JOptionPane.showMessageDialog(null, "PLEASE WRITE YOUR USE PURPOSE");
				}
			}
		});
		btnConfirm.setFont(new Font("Segoe UI Light", Font.BOLD, 22));
		btnConfirm.setBackground(new Color(0, 191, 255));
		btnConfirm.setBounds(299, 413, 256, 44);
		getContentPane().add(btnConfirm);

		// Back button
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new ShowRoomsUI(id);
				} catch (Exception e) {
					e.printStackTrace();
				}
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		btnBack.setBackground(new Color(0, 191, 255));
		btnBack.setBounds(742, 464, 100, 31);
		getContentPane().add(btnBack);
		
		JLabel lblUse = new JLabel("Use");
		lblUse.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
		lblUse.setBackground(Color.WHITE);
		lblUse.setBounds(296, 336, 33, 31);
		getContentPane().add(lblUse);
		
		textField = new JTextField();
		textField.setBounds(335, 329, 220, 44);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		this.setResizable(false);
		this.setVisible(true);
	}
}
