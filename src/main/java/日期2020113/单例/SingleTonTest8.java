package 日期2020113.单例;

/**
 * 枚举
 *推荐
 * @Author yh
 * @Date 2020/11/3 22:21
 */
public class SingleTonTest8 {

  public static void main(String[] args) {
    SingleTon.INSTANCE.sayOk();
  }

}

enum SingleTon {
  INSTANCE;

  public void sayOk() {
    System.out.println("ok");
  }
}
