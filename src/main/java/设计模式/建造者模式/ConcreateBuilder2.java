package 设计模式.建造者模式;

/**
 * @Author yh
 * @Date 2020/11/8 21:49
 */
public class ConcreateBuilder2 implements Builder {
  private Product product = new Product();

  @Override
  public void buildPart1() {
    product.getParts().add("1");
  }

  @Override
  public void buildPart2() {
    product.getParts().add("2");
  }

  @Override
  public void buildPart3() {
    product.getParts().add("3");
  }

  @Override
  public Product getProduct() {
    return product;
  }
}
