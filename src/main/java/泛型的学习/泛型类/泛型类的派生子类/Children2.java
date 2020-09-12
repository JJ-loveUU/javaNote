package 泛型的学习.泛型类.泛型类的派生子类;

import 泛型的学习.泛型类.Generic;

/**
 *
 * 2.子类不是泛型，必须要明确泛型的数据类型
 * @Author yh
 * @Date 2020/9/9 21:16
 */
public class Children2 extends Generic<Integer> {

  public Children2(Integer integer) {
    super(integer);
  }

  @Override
  public void setData(Integer integer) {
    super.setData(integer);
  }
}
