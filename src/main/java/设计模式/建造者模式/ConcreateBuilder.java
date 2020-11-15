package 设计模式.建造者模式;

/**
 * Builder的具体实现  1
 *
 * @Author yh
 * @Date 2020/11/8 21:32
 */
public class ConcreateBuilder implements Builder {

  private Product product = new Product();

  @Override
  public void buildPart1() {
    product.getParts().add("partA");
  }

  @Override
  public void buildPart2() {
    product.getParts().add("partB");
  }

  @Override
  public void buildPart3() {
    product.getParts().add("partC");
  }
  @Override
  public Product getProduct() {
    return product;
  }
}
