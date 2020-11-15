package 设计模式.建造者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体要生成的类
 * @Author yh
 * @Date 2020/11/8 21:35
 */
public class Product {

  private List<String> parts = new ArrayList<>();

  public List<String> getParts() {
    return parts;
  }
}
