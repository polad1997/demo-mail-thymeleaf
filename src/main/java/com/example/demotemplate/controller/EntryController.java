package com.example.demotemplate.controller;

import com.example.demotemplate.entity.UserEntity;
import com.example.demotemplate.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class EntryController {

  @Autowired
  public EmailServiceImpl emailService;

  @PostMapping("/sendTemplate")
  public String send(@RequestBody UserEntity userEntity) throws Exception {
    emailService.sendCreationEmail(userEntity);
    return "creationEmail";
  }

  @RequestMapping("/sendTest")
  public String sendTest(ModelMap modelMap) {
    modelMap.addAttribute("");
    return "testi18n";
  }

}
