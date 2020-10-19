package Threads;

/**
 * 死锁的演示
 *
 * @Author yh
 * @Date 2020/9/29 22:29
 */
public class DeadLockTest {


  static class Thread1 implements Runnable {

    private String lock1;
    private String lock2;

    public Thread1(String lock1, String lock2) {
      this.lock1 = lock1;
      this.lock2 = lock2;
    }

    @Override
    public void run() {
      synchronized (lock1) {
        System.out.println(Thread.currentThread().getName() + "获取到了" + lock1);
        synchronized (lock2) {
          System.out.println(Thread.currentThread().getName() + "获取到了" + lock2);
        }
      }
    }
  }

  public static void main(String[] args) {
    String lockA = "锁A";
    String lockB = "锁B";
    new Thread(new Thread1(lockA, lockB), "线程1").start();
    new Thread(new Thread1(lockB, lockA), "线程2").start();

  }


}
