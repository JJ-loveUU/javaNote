package resttemplate.resttemplate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import resttemplate.resttemplate.domain.User;

import java.awt.print.Book;

/**
 * @Author yh
 * @Date 2020/10/2 22:59
 */
@RestController
public class TestController {
  @Autowired
  private RestTemplate restTemplate;


  @PostMapping("/test2")
  public User test2() {
    User book = new User();
    book.setUsername("红楼梦");
    book.setPassword("红楼梦2");
    ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://440d3a0f.nat123.fun:47419/resttemplate-0.0.1-SNAPSHOT/test3", book, User.class);
    return responseEntity.getBody();
  }

  @PostMapping("/test3")
  public User test3(@RequestBody User book) {
    System.out.println(book);
    return book;
  }

  @GetMapping("/test4")
  public String test4() {
    return "test4";
  }

}
