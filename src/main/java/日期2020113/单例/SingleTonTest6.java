package 日期2020113.单例;

/**
 * 懒汉式：双重检查
 *
 * @Author yh
 * @Date 2020/11/3 22:21
 */
public class SingleTonTest6 {


  private SingleTonTest6() {
  }

  private static volatile SingleTonTest6 instance = null;


  public static SingleTonTest6 getInstance() {
    if (instance == null) {
      synchronized (SingleTonTest6.class) {
        if (instance == null) {
          instance = new SingleTonTest6();
        }
      }
    }
    return instance;
  }


  public static void main(String[] args) {

    System.out.println(getInstance());
  }

}
