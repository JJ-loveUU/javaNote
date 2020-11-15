package 日期2020113.单例;

/**
 * 饿汉式：静态代码块
 *
 * @Author yh
 * @Date 2020/11/3 22:21
 */
public class SingleTonTest2 {

  private SingleTonTest2() {
  }

  private static final SingleTonTest2 INSTANCE;

  static {
    INSTANCE = new SingleTonTest2();
  }

  public static void main(String[] args) {
    System.out.println(INSTANCE);
  }

}
