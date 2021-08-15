package test;

/**
 * @Author yh
 * @Date 2021/1/13 21:14
 */
public class Child1 extends Parent {

  public static void main(String[] args) {
    Child1 child1 = new Child1();
    Child1 child2= new Child1();
    child1.test();
    child2.test();
  }
}
