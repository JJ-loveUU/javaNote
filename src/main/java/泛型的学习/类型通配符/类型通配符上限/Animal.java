package 泛型的学习.类型通配符.类型通配符上限;

import lombok.Data;

/**
 * @Author yh
 * @Date 2020/9/10 11:09
 */
@Data
public class Animal {
  private String name;

  public Animal() {
  }

  public Animal(String name) {
    this.name = name;
  }
}
