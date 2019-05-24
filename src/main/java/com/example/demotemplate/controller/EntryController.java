package com.example.demotemplate.controller;

import com.example.demotemplate.entity.UserEntity;
import com.example.demotemplate.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {

  @Autowired
  public EmailServiceImpl emailService;
  String to;
  String subject;
  String text;


  @GetMapping("/home")
  public void home(Model model) {
    emailService.sendSimpleMessage(to, subject,text);
    model.addAttribute("title", "Hello World!");
//    return "home";
  }

  @GetMapping("/send")
  public String send() {
    emailService.prepareAndSend("wekiller@inbox.ru", "Testttttttttt");
    return "Succes!";
  }

  @PostMapping("/send2")
  public String send(UserEntity userEntity) {
    emailService.sendCreationEmail(userEntity);
    return "succes";
  }

}
