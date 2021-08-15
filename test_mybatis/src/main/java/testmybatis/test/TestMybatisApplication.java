package testmybatis.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@MapperScan(basePackages = "testmybatis.test")
public class TestMybatisApplication {

  @Autowired
  private UserMapper2 userMapper2;
  @Autowired
  private UserMapper userMapper;

  public static void main(String[] args) {
    SpringApplication.run(TestMybatisApplication.class, args);
  }

  @RequestMapping("/test")
  public Object test() {
    HashMap<String, Object> map = new HashMap<>();
    map.put("a", "b");
    try {
      for (int i = 0; i < 10000000; i++) {
        userMapper2.addUser(System.currentTimeMillis() + UUID.randomUUID().toString().substring(0, 5));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return map;
  }

  @RequestMapping("/get")
  public Object get() {
    HashMap<String, Object> map = new HashMap<>();
    List<BlackList> allUsers = userMapper2.getAllUsers();
    return map;
  }
  @RequestMapping("/delete")
  public Object delete() {
    List<String> phones = userMapper2.getPhones();
    HashMap<String, Object> map = new HashMap<>();
    ArrayList<String> ids = new ArrayList<>();
    for (int i = 0; i <100000; i++) {
      ids.add(phones.get(i*2+1));
    }
    for (int i = 0; i <100000; i++) {
      ids.add(System.currentTimeMillis() + UUID.randomUUID().toString().substring(0, 5));
    }
    Instant now = Instant.now();
    Integer count = userMapper.deleteUserById(ids);
    Instant end = Instant.now();
    System.out.println(count);
    System.out.println(Duration.between(now, end).toMillis());
    return map;
  }
}
