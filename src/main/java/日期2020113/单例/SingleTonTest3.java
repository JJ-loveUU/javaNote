package 日期2020113.单例;

/**
 * 懒汉式：线程不安全
 *
 * @Author yh
 * @Date 2020/11/3 22:21
 */
public class SingleTonTest3 {

  private SingleTonTest3() {
  }

  private static SingleTonTest3 instance = null;


  public static SingleTonTest3 getInstance() {
    if (instance == null) {
      instance = new SingleTonTest3();
    }
    return instance;
  }


  public static void main(String[] args) {

    System.out.println(getInstance());
  }

}
