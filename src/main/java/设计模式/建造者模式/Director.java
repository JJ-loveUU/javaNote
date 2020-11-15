package 设计模式.建造者模式;

/**
 *指挥者
 * @Author yh
 * @Date 2020/11/8 21:40
 */
public class Director {
  private Builder builder;

  public Director(Builder builder) {
    this.builder = builder;
  }

  public Product construct(){
    builder.buildPart1();
    builder.buildPart2();
    builder.buildPart3();
    return builder.getProduct();
  }
}
