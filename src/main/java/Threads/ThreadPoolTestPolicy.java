package Threads;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试拒绝策略
 *
 * @Author yh
 * @Date 2020/9/29 22:01
 */
public class ThreadPoolTestPolicy {

  public static void main(String[] args) {

    System.out.println(Runtime.getRuntime().availableProcessors());
    ThreadPoolExecutor pool = new ThreadPoolExecutor(2,
            2,
            0,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(2),
            new ThreadPoolExecutor.DiscardPolicy());
    try {
      for (int i = 0; i < 10; i++) {
        int finalI = i;
        pool.execute(() -> {
          System.out.println(Thread.currentThread().getName() + "," + finalI);
        });

      }
      Thread.sleep(1000);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      pool.shutdown();
    }


  }
}
