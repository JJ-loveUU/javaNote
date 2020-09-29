package Threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏类
 *
 * @Author yh
 * @Date 2020/9/28 17:55
 */
public class CyclicBarrierTest {

  private static volatile List<String> list = Collections.synchronizedList(new ArrayList<>());

  public static void main(String[] args) {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
      //只有当所有人都准备就绪了才执行这个方法
      System.out.println("list的大小:" + list.size());
    });

    for (int i = 0; i < 5; i++) {
      int finalI = i;
      new Thread(() -> {

        try {

          System.out.println("等待:" + finalI);
          list.add(UUID.randomUUID().toString());
          cyclicBarrier.await();
          //只有当所有人都准备就绪了才执行后面的代码
          System.out.println("等待结束:" + finalI);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
      }).start();
    }
  }
}
