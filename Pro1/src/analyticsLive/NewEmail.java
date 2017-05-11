package analyticsLive;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.testng.annotations.Test;


public class NewEmail 
{
	public static String username = "chaudharysiddharth93@gmail.com";
	final static String password = "changednow";
	@Test
	public static void email( String filePath,String repname)
	{

		Properties props = new Properties();
		//props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() 
		{
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("chaudharysiddharth93@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("<mprasad_ic@fishbowl.com>,<sjain_ic@fishbowl.com>"));
			message.setSubject("Report of todays "+repname+" automation run");
			message.setText("PFA");

			MimeBodyPart messageBodyPart = new MimeBodyPart();

			Multipart multipart = new MimeMultipart();

			messageBodyPart = new MimeBodyPart();
			String file = filePath+repname+".html";
			String fileName =repname+".html";
			DataSource source = new FileDataSource(file);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(fileName);
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

			System.out.println("Sending");

			Transport.send(message);

			System.out.println("Email has been Sent");

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}

