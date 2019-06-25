package com.example.demotemplate.entity;

public class UserEntity {

  private String name;
  private String email;
  private String langKey;
  private String subject;

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getLangKey() {
    return langKey;
  }

  public void setLangKey(String langKey) {
    this.langKey = langKey;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


}
