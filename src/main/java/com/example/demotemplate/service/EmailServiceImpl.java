package com.example.demotemplate.service;

import com.example.demotemplate.entity.UserEntity;
import com.example.demotemplate.service.EmailService;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import javax.mail.internet.MimeMessage;
import org.apache.catalina.User;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
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
  public TemplateEngine templateEngine;
  @Autowired
  private MessageSource messageSource;

  Logger log = LoggerFactory.getLogger(EmailService.class);


  public void sendSimpleMessage(
      String to, String subject, String text) {

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject("Test");
    message.setText(text);
    emailSender.send(message);
  }

  public void sendCreationEmail(UserEntity userEntity) throws Exception {
    log.info("Sending creation email to '{}'", userEntity.getEmail());
    sendEmailFromTemplate(userEntity, "creationEmail", "email.activation.title");

  }

  public void sendEmailFromTemplate(UserEntity userEntity, String templateName, String titleKey)
      throws Exception {

    MimeMessage mimeMessage = emailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,
        MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
        StandardCharsets.UTF_8.name());

    Locale locale = Locale.forLanguageTag(userEntity.getLangKey());
    Context context = new Context(locale);
    context.setVariable("name", userEntity.getName());
    String content = templateEngine.process(templateName, context);
//    String subject = messageSource.getMessage(titleKey, null, locale);
    helper.setTo(userEntity.getEmail());
    helper.setText(content, true);
    helper.setSubject(userEntity.getSubject());
    helper.setFrom("alqayev1997@gmail.com");
    emailSender.send(mimeMessage);

  }


}
