package 泛型的学习.类型通配符.类型通配符上限;

import lombok.Data;

/**
 * @Author yh
 * @Date 2020/9/10 11:10
 */
@Data
public class MiniCat extends Cat {
  private String addr;

  public MiniCat(String addr) {
    this.addr = addr;
  }

  public MiniCat(String name, String age, String addr) {
    super(name, age);
    this.addr = addr;
  }
}
