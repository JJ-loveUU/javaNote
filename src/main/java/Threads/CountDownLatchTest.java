package Threads;

import java.util.concurrent.CountDownLatch;

/**]
 * CountDownLatchTest的测试
 * @Author yh
 * @Date 2020/9/28 17:35
 */
public class CountDownLatchTest {


  public static void main(String[] args) throws InterruptedException {
    CountDownLatch countDownLatch = new CountDownLatch(5);


    for (int i = 0; i < 5; i++) {
      int finalI = i;
      new Thread(()->{
        System.out.println(finalI+":离开教室");
        //进行减一操作
        countDownLatch.countDown();

        System.out.println(111111);
      }).start();
    }


    //只有当数字减为0的时候才能够执行await后面的方法
    countDownLatch.await();
    System.out.println("关门");


  }

}
