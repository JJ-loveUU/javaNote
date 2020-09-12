package 泛型的学习.泛型类;

/**
 * @Author yh
 * @Date 2020/9/9 20:26
 */
public class Test {
  public static void main(String[] args) {
    Generic<String> g = new Generic<>("a");
    g.setData("b");
    System.out.println(g.getData());

    //如果不设置泛型，默认会是object,会出问题
  }
}
