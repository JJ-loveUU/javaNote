package test;

/**
 * @Author yh
 * @Date 2021/1/13 21:13
 */
public abstract class Parent {
  public Parent() {
    System.out.println("parent constructor");
  }

  public void test(){
    System.out.println(this);
  }

}
