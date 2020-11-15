package 设计模式.建造者模式;

/**
 * @Author yh
 * @Date 2020/11/8 21:46
 */
public class Test {
  public static void main(String[] args) {
    Product product = new Director(new ConcreateBuilder()).construct();
    product.getParts().forEach(System.out::println);

    System.out.println("---------------------");
    Product product2 = new Director(new ConcreateBuilder2()).construct();
    product2.getParts().forEach(System.out::println);

  }
}
