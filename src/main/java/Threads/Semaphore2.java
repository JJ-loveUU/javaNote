package Threads;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 * @Author yh
 * @Date 2020/9/28 18:47
 */
public class Semaphore2 {

  public static void main(String[] args) {

    Semaphore semaphore = new Semaphore(3);
    for (int i = 0; i < 6; i++) {
      new Thread(()->{
        long id = Thread.currentThread().getId();
        try {
          //尝试获取锁，获取不到等待
          semaphore.acquire();
          System.out.println(id+":获取到了锁");
          Thread.sleep(new Random().nextInt(5)*1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }finally {
          //释放
          semaphore.release();
        }
      }).start();
    }

  }
}
