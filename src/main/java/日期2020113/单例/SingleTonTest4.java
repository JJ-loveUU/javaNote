package 日期2020113.单例;

/**
 * 懒汉式：线程安全，同步方法
 *
 * @Author yh
 * @Date 2020/11/3 22:21
 */
public class SingleTonTest4 {

  private SingleTonTest4() {
  }

  private static SingleTonTest4 instance = null;


  public static synchronized SingleTonTest4 getInstance() {
    if (instance == null) {
      instance = new SingleTonTest4();
    }
    return instance;
  }


  public static void main(String[] args) {

    System.out.println(getInstance());
  }

}
