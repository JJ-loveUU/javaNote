package 泛型的学习.泛型类.泛型类的派生子类;

import 泛型的学习.泛型类.Generic;

/**
 * 1.子类也是泛型，子类的泛型中要包含父类的泛型，可以大于等于父类的泛型
 * @Author yh
 * @Date 2020/9/9 21:12
 */
public class Children1<T> extends Generic<T> {

  public Children1(T t) {
    super(t);
  }

  @Override
  public void setData(T t) {
    super.setData(t);
  }
}
