package Threads;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自定义自旋锁
 * @Author yh
 * @Date 2020/9/28 3:02
 */
public class MySpinLock {

  AtomicReference<Thread> atomicReference = new AtomicReference<>();

  public void getLock(){
    Thread thread = Thread.currentThread();
    System.out.println(thread.getId()+":尝试获取锁");
    while(!atomicReference.compareAndSet(null, thread)){

    }
    System.out.println(thread.getId()+":获取到了锁");
  }

  public void unlock(){
    Thread thread = Thread.currentThread();
    atomicReference.compareAndSet(thread, null);
    System.out.println(thread.getId()+":释放了锁");
  }

  public static void main(String[] args) {
    MySpinLock mySpinLock = new MySpinLock();
    new Thread(()->{
      mySpinLock.getLock();
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      mySpinLock.unlock();
    }).start();


    new Thread(()->{
      mySpinLock.getLock();
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      mySpinLock.unlock();
    }).start();
  }

}
