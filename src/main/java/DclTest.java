/**
 * double checked locking  DCL单例模式
 *
 * @Author yh
 * @Date 2020/10/11 1:22
 */
public class DclTest {

  /*
  为什么要使用
  memory=allocate(); 	//1.分配对象内存空间
  instance(memory)	//2.初始化对象
  instance=memory;	//3.设置instance指向刚分配的内存地址，此时instance!=null

  为什么要使用volatile,因为2，3可能会指令重拍，导致指向一个空的地址，然后其他线程直接拿到了空地址，报空指针错误
  */
  private static volatile DclTest INSTANCE = null;

  public static DclTest getInstance() {
    if (INSTANCE == null) {
      synchronized (DclTest.class) {
        if (INSTANCE == null) {
          INSTANCE = new DclTest();
        }
      }
    }
    return INSTANCE;
  }

}
