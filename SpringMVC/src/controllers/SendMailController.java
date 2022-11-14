package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import javaBeans.MailInfo;

@Controller
public class SendMailController {

	@RequestMapping(path = "/send-mail")
	public String get() {
		return "sendMail";
	}
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(path = "/send-mail",method =  RequestMethod.POST)
	public String sendMail(@Valid @ModelAttribute("obj") MailInfo obj) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(obj.getEmail());
		message.setSubject(obj.getSubject());
		message.setText(obj.getContent());
		mailSender.send(message);
		return "sendMail";
	}
	
}
