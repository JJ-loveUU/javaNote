package Threads;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * arraylist不安全的问题
 * @Author yh
 * @Date 2020/9/28 0:59
 */
public class ArraylistTest {

  public static void main(String[] args) throws InterruptedException {
//    List list =Collections.synchronizedList(new ArrayList<>());
//    for(int i=0;i<100;i++){
//     new Thread(()->{
//       list.add(UUID.randomUUID().toString());
//     }).start();
//    }
//
//    Thread.sleep(2000);
//    list.forEach(System.out::println);
    java.util.concurrent.CopyOnWriteArrayList list =new java.util.concurrent.CopyOnWriteArrayList();
    for(int i=0;i<100;i++){
     new Thread(()->{
       list.add(UUID.randomUUID().toString());
     }).start();
    }

    Thread.sleep(2000);
    list.forEach(System.out::println);




  }
}
