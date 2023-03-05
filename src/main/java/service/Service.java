package service;

import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.RandomStringUtils;

import entity.Camera;
import entity.Laptop;

public class Service {
	public String getDateTime() {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		return year + "-" + (month + 1) + "-" + day + " " + hour + ":" + minute + ":" + second;
	}

	public String random() {
		String input = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm";
		return RandomStringUtils.random(6, input);
	}

	public void sendCode(String email, String code) {
		String HOST_NAME = "smtp.gmail.com";
		int SSL_PORT = 465; // Port for SSL
		int TSL_PORT = 587; // Port for TLS/STARTTLS

		// email gui ma
		String APP_EMAIL = "mine.message123@gmail.com"; // your email

		// mat khau ung dung email
		String APP_PASSWORD = "pbfubxqctsnqpdfg"; // your password

		String RECEIVE_EMAIL = email;
		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", HOST_NAME);
		props.put("mail.smtp.socketFactory.port", SSL_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", SSL_PORT);
		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(APP_EMAIL, APP_PASSWORD);
			}
		});
		// compose message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECEIVE_EMAIL));
			message.setSubject("L&C");
			message.setText(code);
			// send message
			Transport.send(message);
			System.out.println("Message sent successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public String formatNumberL(int gia, int giamGia) {
		String s = (int) ((double) gia * (100 - (double) giamGia) / 100) + "";
		String reverse = new StringBuffer(s).reverse().toString();
		String arr[] = reverse.split("");
		String s1 = "";
		for (int i = 0; i < arr.length; i++) {
			s1 += arr[i];
			if ((i == 2 && 2 < arr.length - 1) || (i == 5 && 5 < arr.length - 1) || (i == 8 && 8 < arr.length - 1)
					|| (i == 11 && 11 < arr.length - 1) || (i == 14 && 14 < arr.length - 1)
					|| (i == 17 && 17 < arr.length - 1) || (i == 20 && 20 < arr.length - 1)) {
				s1 += ",";
			}
		}
		return new StringBuffer(s1).reverse().toString();
	}

	public String formatNumberLL(int gia) {
		String s = gia + "";
		String reverse = new StringBuffer(s).reverse().toString();
		String arr[] = reverse.split("");
		String s1 = "";
		for (int i = 0; i < arr.length; i++) {
			s1 += arr[i];
			if ((i == 2 && 2 < arr.length - 1) || (i == 5 && 5 < arr.length - 1) || (i == 8 && 8 < arr.length - 1)
					|| (i == 11 && 11 < arr.length - 1) || (i == 14 && 14 < arr.length - 1)
					|| (i == 17 && 17 < arr.length - 1) || (i == 20 && 20 < arr.length - 1)) {
				s1 += ",";
			}
		}
		return new StringBuffer(s1).reverse().toString();
	}

}
