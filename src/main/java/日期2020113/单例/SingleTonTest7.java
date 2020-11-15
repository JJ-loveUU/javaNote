package 日期2020113.单例;

/**
 * 静态内部类，SingleTonTest7被加载时不会立即实例化，在调用getInstance方法的时候才会装载SingltTonInnerClass然后进行实例化，并且只会有一个线程去加载类，
 * 保证了线程的安全性
 *
 * @Author yh
 * @Date 2020/11/3 22:21
 */
public class SingleTonTest7 {


  private SingleTonTest7() {
  }

  private static class SingleTonInnerClass {
    private static final SingleTonTest7 INSTANCE = new SingleTonTest7();
  }

  public SingleTonTest7 getInstance() {
    return SingleTonInnerClass.INSTANCE;
  }
}
