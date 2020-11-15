package 日期2020113.单例;

/**
 * 懒汉式：线程安全，同步代码块
 *
 * @Author yh
 * @Date 2020/11/3 22:21
 */
public class SingleTonTest5 {

  private SingleTonTest5() {
  }

  private static SingleTonTest5 instance = null;


  public static SingleTonTest5 getInstance() {
    synchronized (SingleTonTest5.class) {
      if (instance == null) {
        instance = new SingleTonTest5();
      }
    }
    return instance;
  }


  public static void main(String[] args) {

    System.out.println(getInstance());
  }

}
