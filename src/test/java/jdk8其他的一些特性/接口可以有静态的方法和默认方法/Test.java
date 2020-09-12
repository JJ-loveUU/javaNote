package jdk8其他的一些特性.接口可以有静态的方法和默认方法;

/**
 * @Author yh
 * @Date 2020/9/12 12:46
 */
public class Test implements MyInterface {
  public static void main(String[] args) {
    //可以直接调用接口中的默认方法
    new Test().print();

    //接口静态方法
    MyInterface.print2();
  }


}
