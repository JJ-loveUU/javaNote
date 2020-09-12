package 泛型的学习.泛型和数组;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成泛型数组工具类
 *
 * @Author yh
 * @Date 2020/9/10 14:11
 */
public class GenricUtils<T> {

  private T[] tArr;

  public GenricUtils(Class<T> clz, int length) {
    this.tArr = (T[]) Array.newInstance(clz, length);
  }

  public void add(int index, T t) {
    tArr[index] = t;
  }

  public T get(int index) {
    return tArr[index];
  }

  public static void main(String[] args) {
    GenricUtils<String> arr = new GenricUtils<String>(String.class, 10);
    arr.add(0, "a");
  }


}
