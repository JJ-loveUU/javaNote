package 泛型的学习.泛型接口;

/**
 * @Author yh
 * @Date 2020/9/9 21:43
 */
public class Child2<T, E> implements ParentInterface<T> {

  public Child2(T t, E e) {
    this.t = t;
    this.e = e;
  }

  private T t;

  private E e;

  @Override
  public T get() {
    return t;
  }

  public E getE() {
    return e;
  }
}
