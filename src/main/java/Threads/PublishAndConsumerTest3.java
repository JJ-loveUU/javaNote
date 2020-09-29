package Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用blockingQueue来实现生产者和消费者
 *
 * @Author yh
 * @Date 2020/9/28 23:30
 */

public class PublishAndConsumerTest3 {

  private volatile int count = 0;

  private ArrayBlockingQueue queue = new ArrayBlockingQueue(5);


  public void produce() throws InterruptedException {
    queue.put("a");
    System.out.println("放入成功");
  }


  public void consume() throws InterruptedException {
    queue.take();
    System.out.println("获取陈宫");

  }


  public static void main(String[] args) {

    PublishAndConsumerTest3 publishAndConsumerTest = new PublishAndConsumerTest3();
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
