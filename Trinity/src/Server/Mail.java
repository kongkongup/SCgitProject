package Server;


import java.util.Date;
import java.util.Properties; 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import DAO.UsersDAO;
import VO.Users;
 
public class Mail {
	
    public Mail() {
        UsersDAO uDAO = new UsersDAO();
        String id = "";
        Users u = uDAO.selectOneUser(id);
        String email = u.getE_Mail();
        String message = "";
    	
        Properties p = System.getProperties();
        p.put("mail.smtp.starttls.enable", "true");     // gmail�� ������ true ����
        p.put("mail.smtp.host", "smtp.gmail.com");      // smtp ���� �ּ�
        p.put("mail.smtp.auth","true");                 // gmail�� ������ true ����
        p.put("mail.smtp.port", "587");                 // gmail ��Ʈ
        
        Authenticator auth = new MyAuthentication();
         
        //session ���� ��  MimeMessage����
        Session session = Session.getDefaultInstance(p, auth);
        MimeMessage msg = new MimeMessage(session);
         
        try{
        	
            //���������ð�
            msg.setSentDate(new Date());             
            InternetAddress from = new InternetAddress() ;  
            from = new InternetAddress("COBEN<kongkongup@gmail.com>");
            // �̸��� �߽���
            msg.setFrom(from);            
            // �̸��� ������
            InternetAddress to = new InternetAddress(email);
            msg.setRecipient(Message.RecipientType.TO, to);            
            // �̸��� ����
            msg.setSubject("<COBEN>���ǽ�/���͵�� ���� Ȯ��", "UTF-8");             
            // �̸��� ����
            msg.setText(message, "UTF-8");             
            // �̸��� ���
            msg.setHeader("content-Type", "text/html");             
            //���Ϻ�����
            javax.mail.Transport.send(msg);
             
        }catch (AddressException addr_e) {
            addr_e.printStackTrace();
        }catch (MessagingException msg_e) {
            msg_e.printStackTrace();
        }
    }
 
}
 
 
class MyAuthentication extends Authenticator {
      
    PasswordAuthentication pa;
    
 
    public MyAuthentication(){
         
        String id = "kongkongup@gmail.com";       // ���� ID
        String pw = "tmurjsakbnpbhyau";          // ���� ��й�ȣ
 
        // ID�� ��й�ȣ�� �Է��Ѵ�.
        pa = new PasswordAuthentication(id, pw);
      
    }
 
    // �ý��ۿ��� ����ϴ� ��������
    public PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
}
