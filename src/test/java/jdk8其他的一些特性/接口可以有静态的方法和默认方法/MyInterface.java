package jdk8其他的一些特性.接口可以有静态的方法和默认方法;

/**
 * @Author yh
 * @Date 2020/9/12 12:45
 */
public interface MyInterface {

  default void print(){
    System.out.println("接口默认方法");
  }

  static void print2(){
    System.out.println("接口静态方法");
  }
}
