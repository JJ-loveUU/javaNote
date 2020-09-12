package 泛型的学习.类型通配符.类型通配符上限;

import lombok.Data;

/**
 * @Author yh
 * @Date 2020/9/10 11:09
 */
@Data
public class Cat extends Animal {
  private String age;

  public Cat() {

  }

  public Cat(String name, String age) {
    super(name);
    this.age = age;
  }
}
