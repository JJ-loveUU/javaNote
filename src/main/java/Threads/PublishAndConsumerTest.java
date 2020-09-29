package Threads;

/**
 * @Author yh
 * @Date 2020/9/28 23:30
 */

public class PublishAndConsumerTest {

  private volatile int count = 0;

  public synchronized void produce() throws InterruptedException {
    //设置最多库存量为5个
    while (count >= 5) {
      System.out.println(Thread.currentThread().getId() +",等待生产");
      this.wait();
    }
    count++;
    System.out.println(Thread.currentThread().getId() + "生产了一个商品,现在的库存量:" + count);
    notifyAll();
  }


  public synchronized void consume() throws InterruptedException {
    while (count <=0) {
      System.out.println(Thread.currentThread().getId() +",等待消费");
      this.wait();
    }
    count--;
    System.out.println(Thread.currentThread().getId() + "消费了一个商品,现在的库存量:" + count);
    notifyAll();
  }


  public static void main(String[] args) {

    PublishAndConsumerTest publishAndConsumerTest = new PublishAndConsumerTest();
    //生产者
    new Thread(()->{
      for (int i = 0; i < 20; i++) {
        try {
          publishAndConsumerTest.produce();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    //消费者
    new Thread(()->{
      for (int i = 0; i < 10; i++) {
        try {
          publishAndConsumerTest.consume();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
    //消费者2
    new Thread(()->{
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
