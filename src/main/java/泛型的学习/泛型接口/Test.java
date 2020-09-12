package 泛型的学习.泛型接口;

import 泛型的学习.泛型类.泛型类的派生子类.Children2;

/**
 * @Author yh
 * @Date 2020/9/9 21:44
 */
public class Test {
  public static void main(String[] args) {
    Child1 child1 = new Child1();
    child1.get();

    //---------------------
    Child2<String, Integer> child2 = new Child2<>("a",2);
    String s = child2.get();
    Integer e = child2.getE();
    System.out.println(s+":"+e);

  }
}
