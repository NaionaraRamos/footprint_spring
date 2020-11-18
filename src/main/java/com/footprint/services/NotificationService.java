package com.footprint.services;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.footprint.models.EmailNotification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationService {
	
	private final JavaMailSender mailSender;
	//private final MailContentBuilder mailContentBuilder;
	
	@Async
	void sendMail(EmailNotification emailNotification) {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setFrom("springreddit@email.com");
			messageHelper.setTo(emailNotification.getRecipient());
			messageHelper.setSubject(emailNotification.getSubject());
			messageHelper.setText(emailNotification.getText());
			//messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
		};
		
		try {
			mailSender.send(messagePreparator);
			log.info("Email enviado!");
		}catch(MailException e) {
			log.error("Ocorreu uma exceção: ", e);
		}
	}
}