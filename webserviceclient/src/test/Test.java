package test;

/**
 * @Author yh
 * @Date 2020/10/19 20:33
 */
public class Test {

  public static void main(String[] args) {
    TestServiceImpl service = (new TestServiceImplService()).getTestServiceImplPort();
    String s = service.hiWebService("hi webService!");
    System.out.println(s);
  }
}
