package 泛型的学习.泛型接口;

/**
 * 实现类不是泛型，需要明确接口的数据类型
 * @Author yh
 * @Date 2020/9/9 21:42
 */
public class Child1 implements ParentInterface<String> {

  @Override
  public String get() {
    return "str";
  }
}
