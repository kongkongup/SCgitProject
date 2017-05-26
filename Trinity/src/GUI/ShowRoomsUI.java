package GUI;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.DateModel;
import java.util.Properties;
//import org.jdatepicker.util.JDatePickerUtil;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import net.sourceforge.jdatepicker.*;
import net.sourceforge.jdatepicker.graphics.*;
import net.sourceforge.jdatepicker.impl.*;
import net.sourceforge.jdatepicker.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

/* 2017.05.23 홍규희*/
public class ShowRoomsUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelStudyRoom;
	private JPanel panelCurrentStatus;
	private JButton btnMyPage;
	private JLabel lblLogIn;
	private JLabel lblFloorPlan;
	private JButton btnStudyRoom1;
	private JButton btnStudyRoom2;
	private JButton btnStudyRoom3;
	private JButton btnStudyRoom4;
	private JButton btnStudyRoom5;
	private JButton btnStudyRoom6;
	private JButton btnStudyRoom7;
	private JButton btnStudyRoom8;
	private JButton btnStudyRoom9;
	private JButton btnStudyRoom10;
	private JButton btnStudyRoom11;
	private JButton btnStudyRoom12;
	private JButton btnStudyRoom13;
	private JButton btnStudyRoom14;
	private JLabel lblRoomName;
	private JLabel lblSRpic;
	private JLabel lblAssignedTo;
	private JLabel lblOccupancy;
	private JLabel lblOthers;
	private JButton btnSelect;
	private JButton btnBack;
	private JLabel lblInsertDate;
	private JLabel lblSetStartTime;
	private JLabel lblSetEndTime;
	private String studyRoomName = "";
	private String studyRoomPicRoot = "";
	private JPanel pnRoomInfo;
	
	private Date today;
	private String strToday;
	private DateFormat timeToday;
	private String nowtimeToday;
	private Date selectedDate;
	private DateFormat df; 
	
	private JComboBox<String> cbStartTime;
	private JComboBox<String> cbEndTime;
	private JButton btnStartTime;
	private JButton btnEndTime;
	
	private String st = ""; // startTime
	private String et = ""; // endTime
	
	private String selectedStartTime = "";
	private String selectedEndTime = "";

	private int selectedStartTimeToDB = 0;
	private int selectedEndTimeToDB = 0;

	public UtilDateModel model;
	public JDatePanelImpl datePanel;
	public JDatePickerImpl datePicker;
	
	public String selectedDateToDB = "";
	
	private JPanel pnReservationList;
	private JList reservationList;

	
	public String UserNameFromDB;

	public String getUserNameFromDB() {
		return UserNameFromDB;
	}

	public void setUserNameFromDB(String userNameFromDB) {
		UserNameFromDB = userNameFromDB;
	}

	public ShowRoomsUI(String id) {

		getContentPane().setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();

		int xPos = (dim.width / 4) - (this.getWidth() / 2);
		int yPos = (dim.height / 4) - (this.getHeight() / 2);

		this.setBounds(xPos, yPos, 1118, 689);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("[COBEN] SCIT Studyroom Scheduling System - Show Studyrooms");

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblScitCenterOpening = new JLabel("SCIT Center Opening hour : 06:00 ~ 23:00");
		lblScitCenterOpening.setFont(new Font("Instruction", Font.PLAIN, 13));
		lblScitCenterOpening.setBounds(774, 10, 326, 20);
		getContentPane().add(lblScitCenterOpening);

		JLabel lblStudyRoomReservation = new JLabel("Booking hours : MIN 1 hour / MAX 4 hours");
		lblStudyRoomReservation.setFont(new Font("Instruction", Font.PLAIN, 13));
		lblStudyRoomReservation.setBounds(774, 36, 326, 20);
		getContentPane().add(lblStudyRoomReservation);

		// 탭페인 생성
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(12, 46, 1088, 604);
		getContentPane().add(tabbedPane);

		// 누가 로그인?
		lblLogIn = new JLabel("Hello! " + id);
		lblLogIn.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblLogIn.setBounds(12, 6, 259, 31);
		getContentPane().add(lblLogIn);

		// 마이페이지
		btnMyPage = new JButton("My Page");
		btnMyPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MyPageUI();
				dispose();
			}
		});
		btnMyPage.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		btnMyPage.setBackground(new Color(0, 191, 255));
		btnMyPage.setBounds(283, 6, 127, 31);
		getContentPane().add(btnMyPage);

		////////// 첫번째 패널(평면도)
		panelStudyRoom = new JPanel();
		tabbedPane.addTab("Reservation", null, panelStudyRoom, null);
		panelStudyRoom.setBackground(Color.WHITE);
		panelStudyRoom.setLayout(null);

		// 평면도 그림
		lblFloorPlan = new JLabel();
		lblFloorPlan.setIcon(new ImageIcon("./pic/01.png"));
		lblFloorPlan.setBounds(10, 0, 706, 575);
		panelStudyRoom.add(lblFloorPlan);

		// 스터디룸 선택 버튼
		btnStudyRoom1 = new JButton("");
		btnStudyRoom1.setOpaque(false);
		btnStudyRoom1.setBackground(Color.WHITE);
		btnStudyRoom1.setBounds(10, 323, 63, 58);
		panelStudyRoom.add(btnStudyRoom1);

		btnStudyRoom1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom1) {
					setRoomInfo("Study Room 1", "./pic/sr1.jpg", "?", 0, "?");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom2 = new JButton("");
		btnStudyRoom2.setOpaque(false);
		btnStudyRoom2.setBackground(Color.WHITE);
		btnStudyRoom2.setBounds(10, 265, 63, 58);
		panelStudyRoom.add(btnStudyRoom2);

		btnStudyRoom2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom2) {
					setRoomInfo("Study Room 2", "./pic/sr2.jpg", "?", 0, "?");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom3 = new JButton();
		btnStudyRoom3.setOpaque(false);
		btnStudyRoom3.setBackground(Color.WHITE);
		btnStudyRoom3.setBounds(10, 206, 63, 58);
		panelStudyRoom.add(btnStudyRoom3);

		btnStudyRoom3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom3) {
					setRoomInfo("Study Room 3", "./pic/sr3.jpg", "32rd class C", 16, "8 desks / 16 chairs");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom4 = new JButton();
		btnStudyRoom4.setOpaque(false);
		btnStudyRoom4.setBackground(Color.WHITE);
		btnStudyRoom4.setBounds(10, 149, 63, 58);
		panelStudyRoom.add(btnStudyRoom4);

		btnStudyRoom4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom4) {
					setRoomInfo("Study Room 4", "./pic/sr4.jpg", "33rd class D", 14, "7 desks / 14 chairs");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom5 = new JButton();
		btnStudyRoom5.setOpaque(false);
		btnStudyRoom5.setBackground(Color.WHITE);
		btnStudyRoom5.setBounds(10, 100, 63, 49);
		panelStudyRoom.add(btnStudyRoom5);

		btnStudyRoom5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom5) {
					setRoomInfo("Study Room 5", "./pic/sr5.jpg", "33rd class B", 16, "8 desks / 16 chairs");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom6 = new JButton();
		btnStudyRoom6.setOpaque(false);
		btnStudyRoom6.setBackground(Color.WHITE);
		btnStudyRoom6.setBounds(109, 291, 73, 49);
		panelStudyRoom.add(btnStudyRoom6);

		btnStudyRoom6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom6) {
					setRoomInfo("Study Room 6", "./pic/sr6.jpg", "?", 0, "?");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom7 = new JButton();
		btnStudyRoom7.setOpaque(false);
		btnStudyRoom7.setBackground(Color.WHITE);
		btnStudyRoom7.setBounds(109, 247, 73, 44);
		panelStudyRoom.add(btnStudyRoom7);

		btnStudyRoom7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom7) {
					setRoomInfo("Study Room 7", "./pic/sr7.jpg", "33rd class A", 17, "9 desks / 17 chairs");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom8 = new JButton();
		btnStudyRoom8.setOpaque(false);
		btnStudyRoom8.setBackground(Color.WHITE);
		btnStudyRoom8.setBounds(109, 198, 72, 49);
		panelStudyRoom.add(btnStudyRoom8);

		btnStudyRoom8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom8) {
					setRoomInfo("Study Room 8", "./pic/sr8.jpg", "33rd class C", 15, "8 desks / 15 chairs");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom9 = new JButton();
		btnStudyRoom9.setOpaque(false);
		btnStudyRoom9.setBackground(Color.WHITE);
		btnStudyRoom9.setBounds(109, 154, 72, 44);
		panelStudyRoom.add(btnStudyRoom9);

		btnStudyRoom9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom9) {
					setRoomInfo("Study Room 9", "./pic/sr9.jpg", "?", 0, "?");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom10 = new JButton();
		btnStudyRoom10.setOpaque(false);
		btnStudyRoom10.setBackground(Color.WHITE);
		btnStudyRoom10.setBounds(109, 100, 73, 54);
		panelStudyRoom.add(btnStudyRoom10);

		btnStudyRoom10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom10) {
					setRoomInfo("Study Room 10", "./pic/sr10.jpg", "33rd class C", 15, "8 desks / 15 chairs");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom11 = new JButton();
		btnStudyRoom11.setOpaque(false);
		btnStudyRoom11.setBackground(Color.WHITE);
		btnStudyRoom11.setBounds(479, 519, 57, 50);
		panelStudyRoom.add(btnStudyRoom11);

		btnStudyRoom11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom11) {
					setRoomInfo("Study Room 11", "./pic/sr11.jpg", "32rd class A", 9, "2 desks / 9 chairs");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom12 = new JButton();
		btnStudyRoom12.setOpaque(false);
		btnStudyRoom12.setBackground(Color.WHITE);
		btnStudyRoom12.setBounds(536, 519, 56, 50);
		panelStudyRoom.add(btnStudyRoom12);

		btnStudyRoom12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom12) {
					setRoomInfo("Study Room 12", "./pic/sr12.jpg", "?", 0, "?");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom13 = new JButton();
		btnStudyRoom13.setOpaque(false);
		btnStudyRoom13.setBackground(Color.WHITE);
		btnStudyRoom13.setBounds(592, 519, 56, 50);
		panelStudyRoom.add(btnStudyRoom13);

		btnStudyRoom13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom13) {
					setRoomInfo("Study Room 13", "./pic/sr13.jpg", "?", 0, "?");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		btnStudyRoom14 = new JButton();
		btnStudyRoom14.setOpaque(false);
		btnStudyRoom14.setBackground(Color.WHITE);
		btnStudyRoom14.setBounds(648, 519, 58, 50);
		panelStudyRoom.add(btnStudyRoom14);

		btnStudyRoom14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStudyRoom14) {
					setRoomInfo("Study Room 14", "./pic/sr14.jpg", "32rd class A", 8, "4 desks / 8 chairs");
					pnRoomInfo.setVisible(true);
				}
			}
		});

		// date 라벨
		lblInsertDate = new JLabel("Date");
		lblInsertDate.setFont(new Font("Instruction", Font.PLAIN, 18));
		lblInsertDate.setBounds(728, 18, 48, 31);
		panelStudyRoom.add(lblInsertDate);

		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(860, 20, 120, 23);
		
		panelStudyRoom.add(datePicker);
		
		// date 선택 버튼
		JButton btnDateSelect = new JButton("select");
		btnDateSelect.setBounds(992, 18, 79, 23);
		panelStudyRoom.add(btnDateSelect);
		
		btnDateSelect.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			      if (btnDateSelect == e.getSource()) {
			         selectedDate = (Date) datePicker.getModel().getValue();
			         df = new SimpleDateFormat("yyyy/MM/dd");
			         selectedDateToDB = df.format(selectedDate);
			         
			         System.out.println("selectedDateToDB(String) : "+selectedDateToDB);
			         
			 		// date 에서 '오늘' 날짜를 선택했을 때는 시작시간에도 제약이 생긴다.
			 		// 오늘 날짜 구하기
			 		today = new Date();
			 		strToday = df.format(today);
			 		
			 		// 오늘 시간 구하기 09, 10, 11 등으로 출력됨
			 		timeToday = new SimpleDateFormat("HH");
			 		nowtimeToday = timeToday.format(today);
			         
			 		int todayTime = Integer.parseInt(nowtimeToday);
			 		
			 		if (selectedDateToDB.equals(strToday) ) {
			 			for (int i = todayTime +1; i < 23; i++) {
			 				st = i + " : 00";
			 				cbStartTime.addItem(st);
			 			}

			 		} else {
			 			for (int i = 6; i < 23; i++) {
			 				st = i + " : 00";
			 				cbStartTime.addItem(st);
			 			}
			 		}
			      }
			   }
		});
		
		// 시작 시간 라벨+콤보박스+확인버튼
		//라벨
		lblSetStartTime = new JLabel("Start Time");
		lblSetStartTime.setFont(new Font("Instruction", Font.PLAIN, 18));
		lblSetStartTime.setBounds(728, 55, 120, 31);
		panelStudyRoom.add(lblSetStartTime);
		//콤보박스
		cbStartTime = new JComboBox<>();
		cbStartTime.setBounds(860, 62, 120, 21);
		panelStudyRoom.add(cbStartTime);
		//버튼
		btnStartTime = new JButton("ok");
		btnStartTime.setBounds(992, 59, 79, 23);
		panelStudyRoom.add(btnStartTime);
		
		// 끝 시간 라벨+콤보박스+확인버튼
		//라벨
		lblSetEndTime = new JLabel("End Time");
		lblSetEndTime.setFont(new Font("Instruction", Font.PLAIN, 18));
		lblSetEndTime.setBounds(728, 92, 97, 31);
		panelStudyRoom.add(lblSetEndTime);
		//콤보박스
		cbEndTime = new JComboBox<>();
		cbEndTime.setBounds(860, 102, 120, 21);
		panelStudyRoom.add(cbEndTime);
		//버튼
		JButton btnEndTime = new JButton("ok");
		btnEndTime.setBounds(992, 100, 79, 23);
		panelStudyRoom.add(btnEndTime);
		
		//startTime 버튼 액션리스너
		btnStartTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedStartTime = (String)cbStartTime.getSelectedItem();
				System.out.println("selectedStartTime(String) : "+selectedStartTime);
				
				String s1 = selectedStartTime.charAt(0) + "";
				String s2 = selectedStartTime.charAt(1) + "";

				selectedStartTimeToDB = Integer.parseInt(s1+s2);
				System.out.println("selectedStartTimeToDB(Int) : "+selectedStartTimeToDB);
				
				for (int i = selectedStartTimeToDB+1; i < selectedStartTimeToDB+5; i++) {
					et = i+" : 00";
					cbEndTime.addItem(et);
				}
				
			}
		});

		//endTime 버튼 액션리스너
		btnEndTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				selectedEndTime = (String)cbEndTime.getSelectedItem();
				System.out.println("selectedEndTime(String) : "+selectedEndTime);
				
				String s1 = selectedEndTime.charAt(0) + "";
				String s2 = selectedEndTime.charAt(1) + "";

				selectedEndTimeToDB = Integer.parseInt(s1+s2);
				System.out.println("selectedEndTimeToDB(Int) : "+selectedEndTimeToDB);
			}
		});

		// 스터디룸 정보 띄우기
		pnRoomInfo = new JPanel();
		pnRoomInfo.setBorder(new LineBorder(new Color(0, 191, 255), 3, true));
		pnRoomInfo.setBackground(Color.WHITE);
		pnRoomInfo.setBounds(728, 142, 343, 390);
		panelStudyRoom.add(pnRoomInfo);
		pnRoomInfo.setLayout(null);

		lblRoomName = new JLabel(studyRoomName);
		lblRoomName.setBounds(97, 10, 152, 31);
		pnRoomInfo.add(lblRoomName);
		lblRoomName.setForeground(Color.BLACK);
		lblRoomName.setBackground(new Color(176, 224, 230));
		lblRoomName.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblSRpic = new JLabel();
		lblSRpic.setIcon(new ImageIcon(studyRoomPicRoot));
		lblSRpic.setBounds(38, 51, 270, 149);
		lblSRpic.setBackground(new Color(255, 255, 0));
		pnRoomInfo.add(lblSRpic);

		lblAssignedTo = new JLabel();
		lblAssignedTo.setBounds(97, 210, 152, 31);
		lblAssignedTo.setBackground(Color.WHITE);
		lblAssignedTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnRoomInfo.add(lblAssignedTo);

		lblOccupancy = new JLabel();
		lblOccupancy.setBounds(97, 251, 152, 26);
		lblOccupancy.setBackground(Color.WHITE);
		lblOccupancy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnRoomInfo.add(lblOccupancy);

		lblOthers = new JLabel();
		lblOthers.setBounds(97, 287, 152, 26);
		lblOthers.setBackground(Color.WHITE);
		lblOthers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnRoomInfo.add(lblOthers);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(135, 206, 250));
		panel.setBounds(12, 44, 319, 166);
		pnRoomInfo.add(panel);

		// 선택 버튼
		btnSelect = new JButton("Select");
		btnSelect.setBounds(81, 318, 184, 62);
		pnRoomInfo.add(btnSelect);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RoomConfirmUI();
				dispose();
			}
		});
		btnSelect.setBackground(new Color(0, 191, 255));
		btnSelect.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));

		// 뒤로가기 버튼
		btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new LoginUI();
				dispose();
			}
		});
		btnBack.setBackground(new Color(0, 191, 255));
		btnBack.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		btnBack.setBounds(974, 542, 97, 23);
		panelStudyRoom.add(btnBack);

		//////////// 두번째 패널(현황)
		panelCurrentStatus = new JPanel();
		panelCurrentStatus.setBackground(Color.WHITE);
		tabbedPane.addTab("Current Status", panelCurrentStatus);
		panelCurrentStatus.setLayout(null);

		JLabel lblYouCanCheck = new JLabel("You can check reservations here!");
		lblYouCanCheck.setBounds(27, 10, 338, 31);
		lblYouCanCheck.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 20));
		panelCurrentStatus.add(lblYouCanCheck);

		// 달력
		JCalendar calendar = new JCalendar();
		calendar.setBounds(27, 71, 573, 479);
		calendar.setTodayButtonText("Today");
		calendar.setTodayButtonVisible(true);
		panelCurrentStatus.add(calendar);
		
/*		pnReservationList = new JPanel();
		pnReservationList.setBounds(652, 71, 398, 479);
		pnReservationList.setLayout(new BorderLayout());
		
		String reservations[] = new String[];
		

		reservationList.setListData(new reservations[0]);
		reservationList = new JList();
		reservationList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		reservationList.setBackground(new Color(240, 255, 255));
		reservationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(reservationList);
        pnReservationList.add(scrollPane);
        panelCurrentStatus.add(pnReservationList);*/


		this.setResizable(false);
		this.setVisible(true);
	}

	private void setRoomInfo(String RoomName, String pic, String AssignedTo, int i, String Others) {
		lblRoomName.setText(RoomName);
		lblSRpic.setIcon(new ImageIcon(pic));
		lblAssignedTo.setText(AssignedTo);
		lblOccupancy.setText("Occupancy : " + i);
		lblOthers.setText(Others);
	}
}
