package 泛型的学习.泛型类;

/**
 * 泛型类的类型一般是在实例化的时候指定的，好处：1.编译时期的报错，2.不需要类型转换了，不指定泛型是object
 * @Author yh
 * @Date 2020/9/9 20:24
 */
public class Generic<T> {

  private T data;


  public void setData(T t) {
    this.data = t;
  }

  public T getData() {
    return data;
  }

  public Generic(T t) {
    this.data = t;
  }
}
