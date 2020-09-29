package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单线程线程池的创建
 *
 * @Author yh
 * @Date 2020/9/29 19:20
 */
public class SingleThreadPoolTest {

  public static void main(String[] args) {
    ExecutorService pool = Executors.newSingleThreadExecutor();
    try {
      for (int i = 0; i < 10; i++) {
        int finalI = i;
        pool.execute(() -> {
          System.out.println(Thread.currentThread().getName() + "执行任务:" + finalI);
        });
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      //记得要关闭线程池
      pool.shutdown();
    }

  }

}
