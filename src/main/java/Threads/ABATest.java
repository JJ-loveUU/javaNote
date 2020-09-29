package Threads;


import Threads.domain.ChilldUser;
import Threads.domain.User;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 测试aba问题
 * @Author yh
 * @Date 2020/9/27 23:46
 */
public class ABATest {

  private static AtomicReference<User> atomicUser = new AtomicReference<>();
  private static AtomicStampedReference<User> atomicStampedReference ;

  public static void main(String[] args) {


    User user = new User();
    user.setName("user");
    atomicUser.set(user);

    atomicStampedReference= new AtomicStampedReference<>(user,1);

    User user2 = new User();
    user.setName("user2");

//    new Thread(()->{
//
//      boolean b = atomicUser.compareAndSet(user, user2);
//      boolean b2 = atomicUser.compareAndSet(user2, user);
//
//    }).start();
//    new Thread(()->{
//
//      try {
//        TimeUnit.SECONDS.sleep(3);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//      //不能够解决aba的问题，线程1修改了两次，然后线程2修改的时候发现没变化，就成功了
//      boolean b = atomicUser.compareAndSet(user, user2);
//
//      System.out.println(b);
//    }).start();


    new Thread(()->{

      boolean b = atomicStampedReference.compareAndSet(user, user2,1,2);
      boolean b2 = atomicStampedReference.compareAndSet(user2, user,2,3);

    }).start();
    new Thread(()->{

      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      //附带一个标签
      boolean b = atomicStampedReference.compareAndSet(user, user2,1,2);

      System.out.println(b);
    }).start();
  }

}
