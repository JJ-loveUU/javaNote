package test.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@Controller
public class TestApplication {

  public static void main(String[] args) {
    SpringApplication.run(TestApplication.class, args);
  }


  @RequestMapping("/test1")
  @ResponseBody
  public Map test(){
    System.out.println(1111);
    HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    objectObjectHashMap.put("name", "11");
    return objectObjectHashMap ;
  }

  @PostMapping("/test2")
  @ResponseBody
  public Map test2( User user){
    System.out.println(1111);
    HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    objectObjectHashMap.put("name", "11");
    return objectObjectHashMap ;
  }

  @PostMapping("/test3")
  @ResponseBody
  public Map test2(@RequestBody TestDTO test){
    System.out.println(1111);
    return new HashMap() ;
  }
}
