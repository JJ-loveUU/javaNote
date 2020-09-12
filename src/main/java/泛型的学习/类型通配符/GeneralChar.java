package 泛型的学习.类型通配符;

/**
 * @Author yh
 * @Date 2020/9/10 10:51
 */
public class GeneralChar<T> {
  private T t ;
  public void setT(T t){
    this.t = t;
  }
  public T getT(){
    return t;
  }
}
