/*SEND OTP TO PROVIDED MAIL */

package PASSWORD_OTP;		//PACKAGE STATEMENT

/*IMPORT STATEMNENT FOR EMAIL SENT*/
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

import static PASSWORD_OTP.LOGINUSER.*;	//IMPORT STATIC OF LOGINUSER CLASS

public class MAILSEND extends LOGINUSER			//CLASS WITH PARENT CLASS USING EXTENDS KEWWORD
{

	Session newSession = null;
	MimeMessage mimeMessage = null;
	public static void main(String args[])			//MAIN FUNCTION
	{
		MAILSEND mail = new MAILSEND();
		mail.setupServerProperties();
		try {
			mail.draftEmail();
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			mail.sendEmail();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void sendEmail() throws MessagingException 			//SEND MAIL METHOD
	{
		// TODO Auto-generated method stub
		String user = "kumarsahuatish@gmail.com";
		String fromUserPassword = "nvfkvbjssumtvhiv";				//nvfkvbjssumtvhiv
		String emailHost = "smtp.gamil.com";
		Transport t = newSession.getTransport("smtp");
		t.connect("smtp.gmail.com", "kumarsahuatish@gmail.com", "nvfkvbjssumtvhiv");
		t.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		t.close();
		JOptionPane.showMessageDialog(null , "Mail sent successfully, Enter the OTP in OTP TextFIELD.");
		
		
	}
	
	private MimeMessage draftEmail() throws AddressException, MessagingException, IOException		//DRAFT MAIL METHOD
	{
		// TODO Auto-generated method stub
		
		String mailreceive = takemail;
		String mailSubject = "This is the Subject mail for you.";
		String body1 = "Hi ";
		String body3 = takemail;
		String body4 = Integer.toString(OTP);
		String body2 = " for your OTP for authentication";
		String mailBody = body1 + body3 + " the given OTP is "+body4 + body2;
		
		mimeMessage = new MimeMessage(newSession);
		mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mailreceive));
		mimeMessage.setSubject(mailSubject);
		MimeBodyPart bodyPart = new MimeBodyPart();
		bodyPart.setContent(mailBody,"text/html");
		MimeMultipart multi = new MimeMultipart();
		multi.addBodyPart(bodyPart);
		mimeMessage.setContent(multi);
		
		return mimeMessage;
		
 		
	}
	
	private void setupServerProperties() 			//SUPPORT SERVER PROPERTIES METHOD
	{
		// TODO Auto-generated method stub
		
		Properties properties = System.getProperties();
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		
		newSession = Session.getDefaultInstance(properties,null);
		
	}
}