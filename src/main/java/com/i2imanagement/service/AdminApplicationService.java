package com.i2imanagement.service;


import java.util.Optional;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



import com.i2imanagement.modeladmin.Admin;
import com.i2imanagement.modeladmin.AdminResponse;
import com.i2imanagement.repository.AdminApplicationRepository;

@Service
public class AdminApplicationService {
	@Autowired
	AdminApplicationRepository adminApplicationRepository;

	@Value("${admin.email}")
	  private String fromEmail;
	
	@Value("${admin.password}")
	  private String fromPassword;
	
	
	public Admin fetchByEmailId(String email) {
		
		return adminApplicationRepository.fetchByEmailId(email);
	}

	public void saveUser(Admin user) {
		adminApplicationRepository.save(user);
		
	}
	public boolean sendEmail(String subject,String message,String to)
	{
		boolean f=false;
		//variable for email...
	//	System.out.println(fromEmail+" "+fromPassword);
		String host="smtp.gmail.com";
		
		Properties properties=System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.transport.protocol", "smtp");
		
		// step-1 To get Session Object...
		Session session= Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, fromPassword);
			}
			
			
		});
		session.setDebug(true);
	
		//step 2: compose the message[text, multimedia]
		
		MimeMessage mimeMessage= new MimeMessage(session);
		
		//from message
		try {
			mimeMessage.setFrom(fromEmail);
			
			// adding Recipient to message
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//Adding sub to message.
			mimeMessage.setSubject(subject);
			
			//adding message text to employee
			mimeMessage.setContent(message,"text/html");
			
			System.out.println("Send Message Successfully......");
			f=true;
			//Send 
			//Step 2: Send the message using Transport Class
			Transport.send(mimeMessage);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
		
	}

	public AdminResponse getUserDetailsById(Long adminId) {
		Optional<Admin> admin=adminApplicationRepository.findById(adminId);
		AdminResponse resp=new AdminResponse();
		resp.setId(admin.get().getId());
		resp.setEmail(admin.get().getEmail());
		resp.setAdminName(admin.get().getAdminName());
		
		resp.setAddress(admin.get().getAddress());
		resp.setPhone(admin.get().getPhone());
		resp.setRole(admin.get().getRole());
		resp.setUserStatus(admin.get().getUserStatus());
		resp.setProfileImage(admin.get().getProfileImage());
		
		return resp;
	}

}
