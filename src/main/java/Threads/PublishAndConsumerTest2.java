package Threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用condition方法来进行等待和唤醒操作
 *
 * @Author yh
 * @Date 2020/9/28 23:30
 */

public class PublishAndConsumerTest2 {

  private volatile int count = 0;

  private ReentrantLock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  public void produce() throws InterruptedException {
    //设置最多库存量为5个
    lock.lock();
    try {
      while (count >= 5) {
        System.out.println(Thread.currentThread().getId() + ",等待生产");
        condition.await();
      }
      count++;
      System.out.println(Thread.currentThread().getId() + "生产了一个商品,现在的库存量:" + count);
      condition.signalAll();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }


  }


  public void consume() throws InterruptedException {
    //设置最多库存量为5个
    lock.lock();
    try {
      while (count <= 0) {
        System.out.println(Thread.currentThread().getId() + ",等待消费");
        condition.await();
      }
      count--;
      System.out.println(Thread.currentThread().getId() + "消费了一个商品,现在的库存量:" + count);
      condition.signalAll();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }



  }


  public static void main(String[] args) {

    PublishAndConsumerTest2 publishAndConsumerTest = new PublishAndConsumerTest2();
    //生产者
    new Thread(() -> {
      for (int i = 0; i < 20; i++) {
        try {
          publishAndConsumerTest.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    //消费者
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        try {
          publishAndConsumerTest.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
    //消费者2
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        try {
          publishAndConsumerTest.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();


  }
}
