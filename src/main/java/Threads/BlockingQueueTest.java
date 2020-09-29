package Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列测试，底部是定长的数组
 *
 * @Author yh
 * @Date 2020/9/28 20:01
 */
public class BlockingQueueTest {

  public static void main(String[] args) throws InterruptedException {
    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
    //queue.take();

    queue.poll(3L, TimeUnit.SECONDS);

    queue.add("a");
    queue.add("b");
    queue.add("c");
    //检查是否有元素，并且返回首个head元素,不会移除head元素
    queue.element();


    //queue.put("aa");
    queue.offer("aaa", 3L, TimeUnit.SECONDS);


  }
}
