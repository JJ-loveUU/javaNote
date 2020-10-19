package com.example.webservicetest;

/**
 * @Author yh
 * @Date 2020/10/19 20:20
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import javax.xml.ws.Endpoint;

@Service
public class BeforeStartUp implements ApplicationListener<ContextRefreshedEvent> {

  private Log log = LogFactory.getLog(BeforeStartUp.class);

  //    @Value("${spring.ws.address}")
  private static String address = "http://localhost:8002/ws/hello";

  @Autowired
  private TestService testService;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    Endpoint.publish(address, testService);
    log.info("webService 服务发布成功！！！");
    log.info("wsdl地址：" + address + "?wsdl");
  }
}
