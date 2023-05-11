package util;

import java.net.InterfaceAddress;
import java.security.MessageDigest;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	//mail: thaitina5@gmail.com
	//pass: nmcxvgqjnrkbuykx
	
	static final String from = "thaitina5@gmail.com";
	static final String password = "nmcxvgqjnrkbuykx";

	public static boolean sendEmail(String to, String tieuDe, String noiDung) {
		
		//khai báo các properties
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
		props.put("mail.smtp.auth","true"); // phải login thì ms gửi mail đi dc
		props.put("mail.smtp.starttls.enable", "true");
		
		// create Authenticator
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
			
		};
		
		//Phiên làm việc
		Session session = Session.getInstance(props, auth);
		// Tạo một tin nhắn
		MimeMessage msg = new MimeMessage(session);
		
		try {
			//Kieu noi dung
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			//nguoi gui
			msg.setFrom(from);
			//nguoi nhan
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
			//Tieu de email
			msg.setSubject(tieuDe);
			//Quy dinh ngay gui
			msg.setSentDate(new Date());
			// Quy định email nhận phản hồi
			// msg.setReplyTo(InternetAddress.parse(from, false))
			// Nội dung
			msg.setContent(noiDung,"text/HTML; charset=UTF-8");
			// Gửi email
			Transport.send(msg);
			System.out.println("Send mail SUCCESS");
			return true;
			
		} catch (MessagingException e) {
			System.out.println("error");
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		sendEmail("najenda00@gmail.com", "Test email", "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<h1>The img element</h1>\r\n"
				+ "\r\n"
				+ "<img src=\"https://www.w3schools.com/tags/img_girl.jpg\" alt=\"Girl in a jacket\" width=\"500\" height=\"600\">\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "");
		
	}
}
