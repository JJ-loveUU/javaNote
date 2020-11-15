package 日期2020113.单例;

import java.time.Instant;

/**
 * 饿汉式：静态常量
 * @Author yh
 * @Date 2020/11/3 22:21
 */
public class SingleTonTest1 {

  private SingleTonTest1() {
  }

  public static SingleTonTest1 INSTANCE = new SingleTonTest1();

  public static void main(String[] args) {
    System.out.println(INSTANCE);
  }

}
