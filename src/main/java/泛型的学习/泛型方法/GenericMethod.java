package 泛型的学习.泛型方法;

import java.util.ArrayList;

/**
 * 只有在方法上加上泛型参数列表的才是泛型方法，泛型方法上的泛型独立于类上的泛型，泛型参数列表在public和返回值之间
 * @Author yh
 * @Date 2020/9/9 22:03
 */
public class GenericMethod<T> {
  private T t;

  public void setT(T t) {
    this.t = t;
  }

  public T getT(){
    return t;
  }

  public <T> T getT2(T t2) {
    return t2;
  }

  public <E> void getT3(T tt,E e){
    System.out.println(tt+":"+e);
  }


  //如果static方法要使用泛型的能力，就必须使其成为泛型方法
  //只有泛型方法上的泛型才能在静态方法中使用，下面这种写法会报错
//  public static  void getT4(T e){
//    System.out.println(e);
//  }

  //这样写才对
  public static <E> void getT5(E e){
    System.out.println(e);
  }

  //泛型可变参数的定义
  public static <E> void getT6(E... arr){
    for (int i =0;i<arr.length;i++){
      System.out.println(arr[i]);
    }
  }


//  测试
  public static void main(String[] args) {
    GenericMethod<String> g1 = new GenericMethod<>();
    g1.setT("a");
    System.out.println(g1.getT());

    //----------------------------------------------
    //调用泛型方法，参数和泛型类的方法互不影响
    System.out.println(g1.getT2(2));

    //-----------------------------
    g1.getT3("c", 1);


    //泛型方法可变参数----------------------
    GenericMethod.getT6("a","b");

  }
}
