import java.util.Optional;

/**
 * @Author yh
 * @Date 2020/11/11 8:23
 */
public enum TestEnum {

  A("a");

  TestEnum(String msg) {
    this.msg = msg;
  }

  private String msg;

  public String getMsg(){
    return msg;
  }

  public static void main(String[] args) {
    String str = null;
    System.out.println(Optional.ofNullable(str).map(e ->"aa").orElseGet(()->"bbb"));;
  }

}
