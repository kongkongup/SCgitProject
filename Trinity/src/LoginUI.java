import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

/* 2017.05.23 È«±ÔÈñ*/
public class LoginUI extends JFrame {
   
   private JTextField tfID;
   private JPasswordField passwordField;
   private JButton btnSignUp;
   private JButton btnLogin;

   public static void main(String[] args) {
      new LoginUI();
   }
   
   
   public LoginUI() {

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
      lblId.setBounds(492, 142, 30, 31);
      lblId.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
      lblId.setBackground(Color.WHITE);
      getContentPane().add(lblId);

      tfID = new JTextField();
      tfID.setBounds(534, 147, 132, 21);
      getContentPane().add(tfID);
      tfID.setColumns(10);

      // PW
      JLabel lblPassword = new JLabel("PassWord");
      lblPassword.setBounds(435, 186, 97, 18);
      lblPassword.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
      getContentPane().add(lblPassword);

      passwordField = new JPasswordField();
      passwordField.setBounds(534, 184, 132, 21);
      getContentPane().add(passwordField);

      // LogInButton
      btnLogin = new JButton("Log In");
      btnLogin.setBounds(662, 206, 132, 58);
      btnLogin.setBackground(new Color(0, 191, 255));
      btnLogin.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
      getContentPane().add(btnLogin);
      
      /*btnLogin.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            ShowRoomsUI sr = new ShowRoomsUI();
            dispose();
         }
      });*/

      // SignUpButton
      JLabel lblJoinUs = new JLabel("Join Us!");
      lblJoinUs.setBounds(596, 245, 88, 31);
      lblJoinUs.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
      getContentPane().add(lblJoinUs);
      this.setSize(860, 535);
      btnLogin.setBounds(678, 147, 132, 58);

      btnSignUp = new JButton("sign up");
     /* btnSignUp.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            SignupUI su = new SignupUI();
            dispose();
         }
      });*/
      btnSignUp.setBounds(696, 245, 114, 30);
      btnSignUp.setBackground(new Color(0, 191, 255));
      btnSignUp.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
      getContentPane().add(btnSignUp);
      
      // ExitButton
      JButton btnExit = new JButton("exit");
      btnExit.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      });
      btnExit.setFont(new Font("Arca Majora 3 Bold", Font.PLAIN, 18));
      btnExit.setBackground(new Color(0, 191, 255));
      btnExit.setBounds(742, 464, 100, 31);
      getContentPane().add(btnExit);

      // Background
      JLabel lblBackgroundImage = new JLabel("");
      lblBackgroundImage.setIcon(new ImageIcon("./pic/background.jpg"));
      lblBackgroundImage.setBounds(0, 0, 854, 506);
      getContentPane().add(lblBackgroundImage);

      this.setResizable(false);
      this.setVisible(true);
   }

}