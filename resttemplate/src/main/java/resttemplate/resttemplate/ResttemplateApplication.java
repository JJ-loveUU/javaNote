package resttemplate.resttemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ResttemplateApplication {

  public static void main(String[] args) {
    SpringApplication.run(ResttemplateApplication.class, args);
  }

  @RequestMapping("/test1")
  @ResponseBody
  public Map test(){
    System.out.println(1111);
    HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    objectObjectHashMap.put("name", "11");
    return objectObjectHashMap ;
  }

}

