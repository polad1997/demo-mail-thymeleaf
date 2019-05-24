//package com.example.demotemplate.config;
//
//import org.springframework.context.annotation.Bean;
//import org.thymeleaf.spring4.SpringTemplateEngine;
//import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
//
//public class ThymeleafConfig {
//  @Bean
//  public SpringTemplateEngine springTemplateEngine() {
//    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//    templateEngine.addTemplateResolver(htmlTemplateResolver());
//    return templateEngine;
//  }
//
//  @Bean
//  public SpringResourceTemplateResolver htmlTemplateResolver(){
//    SpringResourceTemplateResolver emailTemplateResolver = new SpringResourceTemplateResolver();
//    emailTemplateResolver.setPrefix("classpath:/templates/");
//    emailTemplateResolver.setSuffix(".html");
//    emailTemplateResolver.setTemplateMode(StandardTemplateModeHandlers.HTML5.getTemplateModeName());
//    emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
//    return emailTemplateResolver;
//  }
//}
