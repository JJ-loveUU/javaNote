package Threads;

import java.util.concurrent.SynchronousQueue;

/**
 * 同步队列
 * @Author yh
 * @Date 2020/9/28 20:29
 */
public class SynchronousQueueTest {
  public static void main(String[] args) throws InterruptedException {

    /*
    * 同步队列,内部不存储元素，如果一个线程尝试获取元素，那么他会一直阻塞知道一个线程存放一个元素；
    * 反之亦然
    * */
    SynchronousQueue<String> list = new SynchronousQueue<>();

    list.put("aaaa");


  }
}
