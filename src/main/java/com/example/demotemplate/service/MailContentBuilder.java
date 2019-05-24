package com.example.demotemplate.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {

//  @Autowired
  private TemplateEngine templateEngine;

  @Autowired
  public MailContentBuilder(TemplateEngine templateEngine) {
    this.templateEngine = templateEngine;
  }

  public String build(String message) {
    Context context = new Context();
    System.out.println("***------build method-------***");
    context.setVariable("message", message);
    return templateEngine.process("creationEmail", context);
  }

}
