package GUI;
/*Git hub test*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPasswordField;

public class LoginUI extends JFrame {
	private JTextField tf_ID;
	private JPasswordField pf_Password;
	public LoginUI(){
		setBackground(SystemColor.activeCaption);
		setTitle("Trinity");
		
		JLabel lblNewLabel = new JLabel("Welcome Movie World");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBackground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 15));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("       ID");
		lblNewLabel_1.setFont(new Font("Kartika", Font.BOLD, 20));
		lblNewLabel_1.setBounds(72, 76, 101, 18);
		panel.add(lblNewLabel_1);
		
		tf_ID = new JTextField();
		tf_ID.setBounds(197, 73, 144, 24);
		panel.add(tf_ID);
		tf_ID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Kartika", Font.BOLD, 18));
		lblNewLabel_2.setBounds(46, 106, 127, 18);
		panel.add(lblNewLabel_2);
		
		pf_Password = new JPasswordField();
		pf_Password.setBounds(197, 103, 144, 24);
		panel.add(pf_Password);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btn_Login = new JButton("LOGIN");
		panel_1.add(btn_Login);
		
		JButton btn_SignUp = new JButton("SIGN UP");
		panel_1.add(btn_SignUp);
		
		JButton btn_Adiministrator = new JButton("Administrator MODE");
		panel_1.add(btn_Adiministrator);
		
		
	}
}
