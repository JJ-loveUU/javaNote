package Threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 测试callable,使用callable创建线程
 *
 * @Author yh
 * @Date 2020/9/29 18:44
 */
public class CallableTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    FutureTask<Integer> task = new FutureTask<>(() -> {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
      }
      return 1;
    });

    new Thread(task).start();

    //判断是否完成
    while (!task.isDone()) {
      System.out.println("未完成");
    }


    System.out.println("--------");
    Integer integer = task.get();
    //会一直阻塞直到有结果来
    System.out.println(integer);
  }
}
