package com.example.webservicetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebservicetestApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebservicetestApplication.class, args);
  }

  @RequestMapping("/")
  public String hello(){
    return "hello spring boot";
  }

}
