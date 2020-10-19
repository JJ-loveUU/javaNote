package com.example.webservicetest;

/**
 * @Author yh
 * @Date 2020/10/19 20:19
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@WebService
@Service
public class TestServiceImpl implements TestService{

  private Log log = LogFactory.getLog(TestServiceImpl.class);

  @Override
  public String hiWebService(String s) {
    String msg = "获取内容："+s;
    log.info(msg);
    return msg;
  }
}
