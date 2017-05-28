package GUI;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.border.LineBorder;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import Client.ClientManager;
import VO.Reservation_Log;

//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.DateModel;
import java.util.Properties;
//import org.jdatepicker.util.JDatePickerUtil;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;

import java.awt.*;
import java.awt.event.*;
import net.sourceforge.jdatepicker.*;
import net.sourceforge.jdatepicker.graphics.*;
import net.sourceforge.jdatepicker.impl.*;
import net.sourceforge.jdatepicker.util.*;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

/* 2017.05.23 홍규희*/
public class ShowRoomsUI_액션리스너정리함 extends JFrame {
	private static final long serialVersionUID = 1L;
	private ClientManager cm;
	MyActionListener al = new MyActionListener();
//  전체 패널
	private JButton btnMyPage;
	private JLabel lblLogIn;
	
//  첫번째 패널(센터 평면도)
	private JPanel panelStudyRoom;
  //평면도 그림
	private JLabel lblFloorPlan;
  //스터디룸 선택 버튼
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
  //시간 선택
	// 오늘 날짜, 시간 구하기
	private Date today;
	private DateFormat df;
	private DateFormat timeToday;
	private UtilDateModel model;
	private String strToday;
	private String nowtimeToday;
	private int todayTime;
	//날짜 선택 (DatePicker api)
	private JLabel lblInsertDate;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl datePicker;
	private Date selectedDate;
	private JButton btnDateSelect;
	private String selectedDateToDB = "";
	//시작 시간 선택
	private JLabel lblSetStartTime;
	private JComboBox<String> cbStartTime;
	private JButton btnStartTime;
	private String st = ""; // startTime
	private String selectedStartTime = "";
	private int selectedStartTimeToDB = 0;
	//끝 시간 선택
	private JLabel lblSetEndTime;
	private JComboBox<String> cbEndTime;
	private JButton btnEndTime;
	private String et = ""; // endTime
	private String selectedEndTime = "";
	private int selectedEndTimeToDB = 0;
	
  //가능한 스터디룸 보여주기	
	private ArrayList<Reservation_Log> logList;
	
  //스터디룸 정보
	private JPanel pnRoomInfo;
	private JLabel lblRoomName;
	private JLabel lblSRpic;
	private JLabel lblAssignedTo;
	private JLabel lblOccupancy;
	private JLabel lblOthers;
	private String studyRoomName = "";
	private String studyRoomPicRoot = "";
  //예약하기, 뒤로가기 버튼
	private JButton btnSelect;
	private JButton btnBack;
	
//  두번째 패널(달력 현황)
	private JPanel panelCurrentStatus;
	private JPanel pnReservationList;
	private JList reservationList;

	//생성자
	public ShowRoomsUI_액션리스너정리함(String id) {
		
// 전체 틀 생성
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
		
// 오늘 날짜, 시간 구해놓기
		// 오늘 날짜 구하기
		today = new Date();
		strToday = df.format(today);
		// 오늘 시간 구하기 09, 10, 11 등으로 출력됨
		timeToday = new SimpleDateFormat("HH");
		nowtimeToday = timeToday.format(today);
		todayTime = Integer.parseInt(nowtimeToday);
		
// 센터 정보, 예약 시간 표시
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

// 로그인한 사용자한테 인사하기! Hello~
		lblLogIn = new JLabel("Hello! " + id);
		lblLogIn.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		lblLogIn.setBounds(12, 6, 259, 31);
		getContentPane().add(lblLogIn);

// 마이페이지
		btnMyPage = new JButton("My Page");
		btnMyPage.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		btnMyPage.setBackground(new Color(0, 191, 255));
		btnMyPage.setBounds(283, 6, 127, 31);
		getContentPane().add(btnMyPage);
		btnMyPage.addActionListener(al);

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
		btnStudyRoom1.setEnabled(false);
		btnStudyRoom1.addActionListener(al);

		btnStudyRoom2 = new JButton("");
		btnStudyRoom2.setOpaque(false);
		btnStudyRoom2.setBackground(Color.WHITE);
		btnStudyRoom2.setBounds(10, 265, 63, 58);
		panelStudyRoom.add(btnStudyRoom2);
		btnStudyRoom2.setEnabled(false);
		btnStudyRoom2.addActionListener(al);

		btnStudyRoom3 = new JButton();
		btnStudyRoom3.setOpaque(false);
		btnStudyRoom3.setBackground(Color.WHITE);
		btnStudyRoom3.setBounds(10, 206, 63, 58);
		panelStudyRoom.add(btnStudyRoom3);
		btnStudyRoom3.setEnabled(false);
		btnStudyRoom3.addActionListener(al);

		btnStudyRoom4 = new JButton();
		btnStudyRoom4.setOpaque(false);
		btnStudyRoom4.setBackground(Color.WHITE);
		btnStudyRoom4.setBounds(10, 149, 63, 58);
		panelStudyRoom.add(btnStudyRoom4);
		btnStudyRoom4.setEnabled(false);
		btnStudyRoom4.addActionListener(al);

		btnStudyRoom5 = new JButton();
		btnStudyRoom5.setOpaque(false);
		btnStudyRoom5.setBackground(Color.WHITE);
		btnStudyRoom5.setBounds(10, 100, 63, 49);
		panelStudyRoom.add(btnStudyRoom5);
		btnStudyRoom5.setEnabled(false);
		btnStudyRoom5.addActionListener(al);

		btnStudyRoom6 = new JButton();
		btnStudyRoom6.setOpaque(false);
		btnStudyRoom6.setBackground(Color.WHITE);
		btnStudyRoom6.setBounds(109, 291, 73, 49);
		panelStudyRoom.add(btnStudyRoom6);
		btnStudyRoom6.setEnabled(false);
		btnStudyRoom6.addActionListener(al);

		btnStudyRoom7 = new JButton();
		btnStudyRoom7.setOpaque(false);
		btnStudyRoom7.setBackground(Color.WHITE);
		btnStudyRoom7.setBounds(109, 247, 73, 44);
		panelStudyRoom.add(btnStudyRoom7);
		btnStudyRoom7.setEnabled(false);
		btnStudyRoom7.addActionListener(al);

		btnStudyRoom8 = new JButton();
		btnStudyRoom8.setOpaque(false);
		btnStudyRoom8.setBackground(Color.WHITE);
		btnStudyRoom8.setBounds(109, 198, 72, 49);
		panelStudyRoom.add(btnStudyRoom8);
		btnStudyRoom8.setEnabled(false);
		btnStudyRoom8.addActionListener(al);

		btnStudyRoom9 = new JButton();
		btnStudyRoom9.setOpaque(false);
		btnStudyRoom9.setBackground(Color.WHITE);
		btnStudyRoom9.setBounds(109, 154, 72, 44);
		panelStudyRoom.add(btnStudyRoom9);
		btnStudyRoom9.setEnabled(false);
		btnStudyRoom9.addActionListener(al);

		btnStudyRoom10 = new JButton();
		btnStudyRoom10.setOpaque(false);
		btnStudyRoom10.setBackground(Color.WHITE);
		btnStudyRoom10.setBounds(109, 100, 73, 54);
		panelStudyRoom.add(btnStudyRoom10);
		btnStudyRoom10.setEnabled(false);
		btnStudyRoom10.addActionListener(al);

		btnStudyRoom11 = new JButton();
		btnStudyRoom11.setOpaque(false);
		btnStudyRoom11.setBackground(Color.WHITE);
		btnStudyRoom11.setBounds(479, 519, 57, 50);
		panelStudyRoom.add(btnStudyRoom11);
		btnStudyRoom11.setEnabled(false);
		btnStudyRoom11.addActionListener(al);

		btnStudyRoom12 = new JButton();
		btnStudyRoom12.setOpaque(false);
		btnStudyRoom12.setBackground(Color.WHITE);
		btnStudyRoom12.setBounds(536, 519, 56, 50);
		panelStudyRoom.add(btnStudyRoom12);
		btnStudyRoom12.setEnabled(false);
		btnStudyRoom12.addActionListener(al);

		btnStudyRoom13 = new JButton();
		btnStudyRoom13.setOpaque(false);
		btnStudyRoom13.setBackground(Color.WHITE);
		btnStudyRoom13.setBounds(592, 519, 56, 50);
		panelStudyRoom.add(btnStudyRoom13);
		btnStudyRoom13.setEnabled(false);
		btnStudyRoom13.addActionListener(al);

		btnStudyRoom14 = new JButton();
		btnStudyRoom14.setOpaque(false);
		btnStudyRoom14.setBackground(Color.WHITE);
		btnStudyRoom14.setBounds(648, 519, 58, 50);
		panelStudyRoom.add(btnStudyRoom14);
		btnStudyRoom14.setEnabled(false);
		btnStudyRoom14.addActionListener(al);

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
		datePicker.addActionListener(al);
		
		

		// date 선택 버튼
		btnDateSelect = new JButton("select");
		btnDateSelect.setEnabled(false);
		btnDateSelect.setBounds(992, 18, 79, 23);
		panelStudyRoom.add(btnDateSelect);
		btnDateSelect.addActionListener(al);

		// 시작 시간 라벨+콤보박스+확인버튼
		// 라벨
		lblSetStartTime = new JLabel("Start Time");
		lblSetStartTime.setFont(new Font("Instruction", Font.PLAIN, 18));
		lblSetStartTime.setBounds(728, 55, 120, 31);
		panelStudyRoom.add(lblSetStartTime);
		// 콤보박스
		cbStartTime = new JComboBox<>();
		cbStartTime.setBounds(860, 62, 120, 21);
		panelStudyRoom.add(cbStartTime);
		cbStartTime.addActionListener(al);
		// 버튼
		btnStartTime = new JButton("ok");
		btnStartTime.setBounds(992, 59, 79, 23);
		panelStudyRoom.add(btnStartTime);
		btnStartTime.setEnabled(false);
		btnStartTime.addActionListener(al);

		// 끝 시간 라벨+콤보박스+확인버튼
		// 라벨
		lblSetEndTime = new JLabel("End Time");
		lblSetEndTime.setFont(new Font("Instruction", Font.PLAIN, 18));
		lblSetEndTime.setBounds(728, 92, 97, 31);
		panelStudyRoom.add(lblSetEndTime);
		// 콤보박스
		cbEndTime = new JComboBox<>();
		cbEndTime.setBounds(860, 102, 120, 21);
		panelStudyRoom.add(cbEndTime);
		cbEndTime.addActionListener(al);

		// 버튼
		btnEndTime = new JButton("ok");
		btnEndTime.setBounds(992, 100, 79, 23);
		panelStudyRoom.add(btnEndTime);
		btnEndTime.setEnabled(false);
		btnEndTime.addActionListener(al);

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
		btnSelect.setBackground(new Color(0, 191, 255));
		btnSelect.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		pnRoomInfo.add(btnSelect);
		btnSelect.addActionListener(al);

		// 뒤로가기 버튼
		btnBack = new JButton("back");
		btnBack.setBounds(974, 542, 97, 23);
		btnBack.setBackground(new Color(0, 191, 255));
		btnBack.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
		panelStudyRoom.add(btnBack);
		btnBack.addActionListener(al);

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

		/*
		 * pnReservationList = new JPanel(); pnReservationList.setBounds(652,
		 * 71, 398, 479); pnReservationList.setLayout(new BorderLayout());
		 * 
		 * String reservations[] = new String[];
		 * 
		 * 
		 * reservationList.setListData(new reservations[0]); reservationList =
		 * new JList(); reservationList.setBorder(new
		 * BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		 * reservationList.setBackground(new Color(240, 255, 255));
		 * reservationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION)
		 * ; JScrollPane scrollPane = new JScrollPane(reservationList);
		 * pnReservationList.add(scrollPane);
		 * panelCurrentStatus.add(pnReservationList);
		 */
		
		this.setResizable(false);
		this.setVisible(true);
	}// 생성자 끝
	
	private void setRoomInfo(String RoomName, String pic, String AssignedTo, int i, String Others) {
		lblRoomName.setText(RoomName);
		lblSRpic.setIcon(new ImageIcon(pic));
		lblAssignedTo.setText(AssignedTo);
		lblOccupancy.setText("Occupancy : " + i);
		lblOthers.setText(Others);
	}

	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
		//마이페이지 선택
			/*if (e.getSource() == btnMyPage) {
				new MyPageUI();
				dispose();
			}
		//스터디룸 선택
			  else */if (e.getSource() == btnStudyRoom1) {
				setRoomInfo("Study Room 1", "./pic/sr1.jpg", "?", 10, "?");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom2) {
				setRoomInfo("Study Room 2", "./pic/sr2.jpg", "?", 12, "?");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom3) {
				setRoomInfo("Study Room 3", "./pic/sr3.jpg", "32rd class C", 16, "8 desks / 16 chairs");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom4) {
				setRoomInfo("Study Room 4", "./pic/sr4.jpg", "33rd class D", 14, "7 desks / 14 chairs");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom5) {
				setRoomInfo("Study Room 5", "./pic/sr5.jpg", "33rd class B", 16, "8 desks / 16 chairs");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom6) {
				setRoomInfo("Study Room 6", "./pic/sr6.jpg", "?", 12, "?");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom7) {
				setRoomInfo("Study Room 7", "./pic/sr7.jpg", "33rd class A", 17, "9 desks / 17 chairs");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom8) {
				setRoomInfo("Study Room 8", "./pic/sr8.jpg", "33rd class C", 15, "8 desks / 15 chairs");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom9) {
				setRoomInfo("Study Room 9", "./pic/sr9.jpg", "?", 15, "?");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom10) {
				setRoomInfo("Study Room 10", "./pic/sr10.jpg", "33rd class C", 15, "8 desks / 15 chairs");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom11) {
				setRoomInfo("Study Room 11", "./pic/sr11.jpg", "32rd class A", 9, "2 desks / 9 chairs");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom12) {
				setRoomInfo("Study Room 12", "./pic/sr12.jpg", "?", 0, "?");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom13) {
				setRoomInfo("Study Room 13", "./pic/sr13.jpg", "?", 0, "?");
				pnRoomInfo.setVisible(true);
			} else if (e.getSource() == btnStudyRoom14) {
				setRoomInfo("Study Room 14", "./pic/sr14.jpg", "32rd class A", 8, "4 desks / 8 chairs");
				pnRoomInfo.setVisible(true);
			}
		//날짜선택
			  else if (e.getSource() == datePicker) {
				btnDateSelect.setEnabled(true);
			} else if (btnDateSelect == e.getSource()) {
				selectedDate = (Date) datePicker.getModel().getValue();
				df = new SimpleDateFormat("yyyy/MM/dd");
				selectedDateToDB = df.format(selectedDate);
				if (selectedDateToDB.equals(strToday)) { //선택한 날짜가 오늘일 경우
					for (int i = todayTime + 1; i < 23; i++) {
						st = i + " : 00";
						cbStartTime.addItem(st);
					}
				} else { //선택한 날짜가 오늘이 아닐 경우
					for (int i = 6; i < 23; i++) {
						st = i + " : 00";
						cbStartTime.addItem(st);
					}
				}
			} else if (e.getSource() == cbStartTime) {
				btnStartTime.setEnabled(true);
			} else if (e.getSource() == cbEndTime) {
				btnEndTime.setEnabled(true);
			} else if (e.getSource() == btnStartTime) {
				cbEndTime.removeAllItems();
				selectedStartTime = (String) cbStartTime.getSelectedItem();
				String s1 = selectedStartTime.charAt(0) + "";
				String s2 = selectedStartTime.charAt(1) + "";
				String s3 = (s1 + s2).trim();
				selectedStartTimeToDB = Integer.parseInt(s3);
				if (selectedStartTimeToDB < 20) {
					for (int i = selectedStartTimeToDB + 1; i < selectedStartTimeToDB + 5; i++) {
						et = i + " : 00";
						cbEndTime.addItem(et);
					}
				} else if (selectedStartTimeToDB == 20) {
					cbEndTime.addItem("21:00");
					cbEndTime.addItem("22:00");
					cbEndTime.addItem("23:00");
				} else if (selectedStartTimeToDB == 21) {
					cbEndTime.addItem("22:00");
					cbEndTime.addItem("23:00");
				} else if (selectedStartTimeToDB == 22) {
					cbEndTime.addItem("23:00");
				}
			} else if (e.getSource() == btnEndTime) {
				selectedEndTime = (String) cbEndTime.getSelectedItem();
				String s1 = selectedEndTime.charAt(0) + "";
				String s2 = selectedEndTime.charAt(1) + "";
				selectedEndTimeToDB = Integer.parseInt(s1 + s2);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////				
				/*ArrayList<Reservation_Log>*/
				logList = cm.selectAllLogs();

				 /* 비어있는 스터디룸 예약하기
				 * 1. 날짜를 확인
				 * 2. 시작시간 비교
				 * 3. 종료시간 비교
				 * 
				 * 로그에서 날짜 가져오기 log.getDate()
				 * 로그에서 방 순서대로 체크하기
				 * 로그에서 시작시간 가져오기 log.getStart_time()
				 * 로그에서 끝*/
				ArrayList<String> roomAvailable = null;
				ArrayList<String> roomNotAvailable = null;
				ArrayList<String> roomAvailableForSure = null;
				ArrayList<String> roomNotAvailableForSure = null;
				
				if (!logList.isEmpty()) {
					for (int i = 0; i < logList.size(); i++) {
						if (selectedDate.equals(logList.get(i).getDate())) { //선택한 날짜와 같은 날짜를 선택한 이전 로그를 하나씩 보면서
							if (logList.get(i).getStart_time() >= selectedEndTimeToDB 
							 && logList.get(i).getEnd_time() <= selectedStartTimeToDB) {
								roomAvailable.add(logList.get(i).getRoom_name());
							} else {
								roomNotAvailable.add(logList.get(i).getRoom_name());
							}
						}
					}// 각 로그 별로 같은 날짜 예약 중 시작 시간, 끝 시간 비교해서 가능한 방, 불가능한 방 리스트로 분류.
					for (int i = 0; i < roomAvailable.size(); i++) {
						for (int j = 0; j < roomNotAvailable.size(); j++) {
							if (roomAvailable.get(i).equals(roomNotAvailable.get(j))) {
								roomNotAvailableForSure.add(roomAvailable.get(i));
							} else {
								roomAvailableForSure.add(roomAvailable.get(i));
							}
						}
					}// 각 로그별로 가능한 방, 불가능한 방 비교해서 가능한 방 배열에는 있으나, 불가능한 방 배열에는 없는 방 이름을 추출 => 진짜 예약 할 수 있는 방
				} else {// 리스트가 비어있을 경우 -> 아무렇게나 예약 가능
					btnStudyRoom1.setEnabled(true);
					btnStudyRoom2.setEnabled(true);
					btnStudyRoom3.setEnabled(true);
					btnStudyRoom4.setEnabled(true);
					btnStudyRoom5.setEnabled(true);
					btnStudyRoom6.setEnabled(true);
					btnStudyRoom7.setEnabled(true);
					btnStudyRoom8.setEnabled(true);
					btnStudyRoom9.setEnabled(true);
					btnStudyRoom10.setEnabled(true);
					btnStudyRoom11.setEnabled(true);
					btnStudyRoom12.setEnabled(true);
					btnStudyRoom13.setEnabled(true);
					btnStudyRoom13.setEnabled(true);
				}
				
				for (int a = 0; a < roomAvailableForSure.size(); a++) {
					String key = roomAvailableForSure.get(a);
					switch (key) {
					case "Study Room1":
						btnStudyRoom1.setEnabled(true);
						break;
						
					case "Study Room2":	
						btnStudyRoom2.setEnabled(true);
						break;
						
					case "Study Room3":
						btnStudyRoom3.setEnabled(true);
						break;
						
					case "Study Room4":
						btnStudyRoom4.setEnabled(true);
						break;
						
					case "Study Room5":
						btnStudyRoom5.setEnabled(true);
						break;
						
					case "Study Room6":
						btnStudyRoom6.setEnabled(true);
						break;
						
					case "Study Room7":
						btnStudyRoom7.setEnabled(true);
						break;
						
					case "Study Room8":
						btnStudyRoom8.setEnabled(true);
						break;
						
					case "Study Room9":
						btnStudyRoom9.setEnabled(true);
						break;

					case "Study Room10":
						btnStudyRoom10.setEnabled(true);
						break;

					case "Study Room11":
						btnStudyRoom11.setEnabled(true);
						break;

					case "Study Room12":
						btnStudyRoom12.setEnabled(true);
						break;

					case "Study Room13":
						btnStudyRoom13.setEnabled(true);
						break;

					case "Study Room14":
						btnStudyRoom13.setEnabled(true);
						break;
					default:
						break;
					}
				}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			} /*else if (e.getSource() == btnSelect) {
				new RoomConfirmUI(id);
				dispose();
			} else if (e.getSource() == btnBack) {
				new LoginUI();
				dispose();
			}
*/
		}
	} //액션리스너 끝

}//전체 클래스 끝
