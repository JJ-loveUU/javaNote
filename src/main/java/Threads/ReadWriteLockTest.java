package Threads;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁：写的时候只有一个人进行，读的时候有很多个人进行
 *
 * @Author yh
 * @Date 2020/9/28 16:33
 */

public class ReadWriteLockTest {

  private static volatile HashMap<String, Object> map = new HashMap<>();

  private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

  public static void changeMap() throws InterruptedException {
    //当没有任何一个线程持有锁时，可以获取到写锁，写锁具有排他性
    readWriteLock.writeLock().lock();
    System.out.println(Thread.currentThread().getId() + ",取到了写锁");
    map.put("aaa", UUID.randomUUID().toString());
    System.out.println(Thread.currentThread().getId() + ",释放了写锁");
    readWriteLock.writeLock().unlock();

  }

  public static void readMap() throws InterruptedException {
    //只要没有线程获取了写锁，就可以获取到读锁
    readWriteLock.readLock().lock();
    System.out.println(Thread.currentThread().getId() + ",取到了读锁");
    map.put("aaa", UUID.randomUUID().toString());
    System.out.println(Thread.currentThread().getId() + ",释放了读锁");
    readWriteLock.readLock().unlock();
  }

  public static void main(String[] args) {


    for (int i = 0; i < 5; i++) {
      new Thread(() -> {
        try {
          ReadWriteLockTest.readMap();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }

    for (int i = 0; i < 5; i++) {
      new Thread(() -> {
        try {
          ReadWriteLockTest.changeMap();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }).start();
    }

  }


}
