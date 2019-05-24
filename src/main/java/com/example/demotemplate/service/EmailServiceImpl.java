package com.example.demotemplate.service;

import com.example.demotemplate.entity.UserEntity;
import com.example.demotemplate.service.EmailService;
import java.util.Locale;
import javax.mail.internet.MimeMessage;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class EmailServiceImpl implements EmailService {

  @Autowired
  public JavaMailSender emailSender;
  @Autowired
  public MailContentBuilder mailContentBuilder;
  @Autowired
  public TemplateEngine templateEngine;
  @Autowired
  private MessageSource messageSource;

  Logger log = LoggerFactory.getLogger(EmailService.class);


  public void sendSimpleMessage(
      String to, String subject, String text) {

    MimeMessagePreparator messagePreparator = mimeMessage -> {
      MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
      mimeMessageHelper.setFrom("alqayev1997@gmail.com");
      mimeMessageHelper.setTo(to);
      mimeMessageHelper.setSubject("Testtttttttttt");
      mimeMessageHelper.setText("Testttttttttt");
      String content = mailContentBuilder.build(text);
      mimeMessageHelper.setText(content, true);
    };
    try {
      emailSender.send(messagePreparator);
    } catch (MailException e) {
      e.printStackTrace();
    }

//    SimpleMailMessage message = new SimpleMailMessage();
//    message.setTo(to);
//    message.setSubject("Test");
//    message.setText(text);
//    emailSender.send(message);
  }


  public void prepareAndSend(String recipient, String message) {
    MimeMessagePreparator messagePreparator = mimeMessage -> {
      MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
//      messageHelper.setFrom("alqayev1997@gmail.com");
//      messageHelper.setTo("wekiller@inbox.ru");
      System.out.println("***");
//      messageHelper.setSubject("Testtttttttttt");
//      messageHelper.setText("Testttttttttt");
      String content = mailContentBuilder.build(message);
      messageHelper.setText(content, true);
    };
    try {
      System.out.println("emailSender.send() -> is ready");
      emailSender.send(messagePreparator);
    } catch (MailException e) {
      e.printStackTrace();
    }
  }


  public void sendCreationEmail(UserEntity userEntity) {
    log.info("Sending creation email to '{}'", userEntity.getEmail());
    sendEmailFromTemplate(userEntity, "creationEmail", "email.activation.title");

  }

  public void sendEmailFromTemplate(UserEntity userEntity, String templateName, String titleKey) {
    log.info("sendEmailFromTemplate() method starts");
    userEntity.setLangKey("eng");
    userEntity.setEmail("wekiller@inbox.ru");
    userEntity.setName("Polad");
    Locale locale = Locale.forLanguageTag(userEntity.getLangKey());
    Context context = new Context(locale);
    context.setVariable("name", userEntity.getName());
    context.setVariable("email", userEntity.getEmail());
    context.setVariable("langKey", userEntity.getLangKey());
    String content = templateEngine.process(templateName, context);
//    String subject = messageSource.getMessage(titleKey, null, locale);
    sendSimpleMessage(userEntity.getEmail(), "testtetetetetet", content);
  }


}
