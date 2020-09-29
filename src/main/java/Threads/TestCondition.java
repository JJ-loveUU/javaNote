package Threads;

import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多条件唤醒：
 * 多线程之间按顺序调用,A,B,C三个线程
 * A打印5次，B打印10次，C打印15次，按这种顺序循环两次
 *
 * @Author yh
 * @Date 2020/9/29 2:38
 */
public class TestCondition {

  private ReentrantLock lock = new ReentrantLock();
  private Condition cA = lock.newCondition();
  private Condition cB = lock.newCondition();
  private Condition cC = lock.newCondition();
  private int number = 1;

  public void print5() {
    lock.lock();
    try {
      while (number != 1) {
        cA.await();
      }
      System.out.println("A打印5次");
      number = 2;
      cB.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void print10() {
    lock.lock();
    try {
      while (number != 2) {
        cB.await();
      }
      System.out.println("B打印10次");
      number = 3;
      cC.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public void print15() {
    lock.lock();
    try {
      while (number != 3) {
        cC.await();
      }
      System.out.println("C打印15次");
      number = 1;
      cA.signal();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  public static void main(String[] args) {
    TestCondition testCondition = new TestCondition();

    new Thread(() -> {
      for (int i = 0; i < 2; i++) {
        testCondition.print5();
      }
    }).start();
    new Thread(() -> {
      for (int i = 0; i < 2; i++) {
        testCondition.print10();
      }
    }).start();
    new Thread(() -> {
      for (int i = 0; i < 2; i++) {
        testCondition.print15();
      }
    }).start();

  }
}
