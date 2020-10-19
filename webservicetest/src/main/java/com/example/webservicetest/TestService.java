package com.example.webservicetest;

/**
 * @Author yh
 * @Date 2020/10/19 20:18
 */
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface TestService {

  @WebMethod
  String hiWebService(@WebParam(name = "hi") String s);
}