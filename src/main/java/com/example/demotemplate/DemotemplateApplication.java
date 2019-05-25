package com.example.demotemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class DemotemplateApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemotemplateApplication.class, args);
  }

}
