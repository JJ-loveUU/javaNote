package 设计模式.建造者模式;

/**
 * 构建接口，指定了构建的方法
 *
 * @Author yh
 * @Date 2020/11/8 21:29
 */
public interface Builder {

  void buildPart1();

  void buildPart2();

  void buildPart3();

  /**
   * 获取产品
   *
   * @return
   */
  Product getProduct();


}
