/**
 * @Author yh
 * @Date 2020/10/22 21:07
 */
public class Parent {

  static {
    System.out.println("父类的静态代码块");
  }

  {
    System.out.println("父类的非静态代码块");
  }

  public Parent() {
    System.out.println("父类构造器的代码");
  }

  public static void main(String[] args) {
    new Parent();
    new Parent();
  }
}

class Child extends Parent {
  static {
    System.out.println("子类的静态代码块");
  }

  {
    System.out.println("子类的非静态代码块");
  }

  public Child() {
    System.out.println("子类构造器的代码");
  }


}
