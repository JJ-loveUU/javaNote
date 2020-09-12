package lamda基本有用法;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author yh
 * @Date 2020/9/11 13:08
 */
public class Test {

  public static void main(String[] args) {

    //一、匿名类：
    //写法1：
//    test1(1, new Consumer<Integer>() {
//      @Override
//      public void accept(Integer integer) {
//        System.out.println(integer);
//      }
//    });

    //用lamda代替：
    test1(1, i -> System.out.println(i));

    /*
    * 使用lamda表达式代替的接口只能有一个抽象方法，jdk用@FunctionalInterface注解了函数式接口
    * jdk内部提供了很多的函数式接口供我们使用，如
    * 1.Function:
    * public interface Function<T, R> {
        R apply(T t);
      }
      2.Supplier:
      public interface Supplier<T>
      T get();
      3.Consumer:
       public interface Consumer<T>
      void accept(T t);
      4.Predicate:
       public interface Predicate<T> {
        boolean test(T var1);
      *
    * */

    //lamda


  }

  public static void test1(int i, Consumer<Integer> com) {
    com.accept(i);
  }

  /**
   * 一、方法引用：
   * <p>
   * 主要有三种语法格式：
   * 如果lamda表示是方法体的内容是一个方法并且，该方法的参数列表和返回值与函数式接口的方法的参数列表和返回值一致时使用
   * 简单的理解：用方法引用的方式简化的你自己写，就是说你自己不用写了，引用已经帮你写好了
   * 1.对象::实例方法名
   * 2.类::静态方法名
   * <p>
   * 如果参数列表中第一个参数是实例方法的调用者，第二个参数是实例方法的参数是，使用   ClassName::method
   * 3.类::实例方法名
   * <p>
   * <p>
   * 二、构造器引用：
   * 格式：
   * ClassName::new
   * <p>
   * 三、数组引用：
   * 格式：
   * Type[]::new
   */

  //1.对象::实例方法名
  @org.junit.Test
  public void test2() {
    test1(1, System.out::println);
  }

  //2.类::静态方法名
  @org.junit.Test
  public void test3() {
    Comparator<Integer> com = Integer::compare;// public static int compare(int x, int y) 跟我要实现的效果是一样的,直接引用就可以了
  }

  //3.类::方法名
  //如果参数列表中第一个参数是实例方法的调用者，第二个参数是实例方法的参数是，使用   ClassName::method
  @org.junit.Test
  public void test4() {
    BiPredicate<String, String> b = (x, y) -> x.equals(y);
    //简化写法,效果是一样的
    BiPredicate<String, String> b1 = String::equals;
  }


  //二、构造器引用：jvm会根据上下文去找对应的构造器，其本质其实还是方法引用类似
  @org.junit.Test
  public void test5() {

    //1.
    Function<String, Employee> f = x -> new Employee();
    //简化写法
    Function<String, Employee> f2 = Employee::new;

    //2.
    Supplier<Employee> f3 = Employee::new;
  }

  //三、数组引用：
  @org.junit.Test
  public void test6() {

    Function<Integer, String[]> f = x -> new String[x];
    Function<Integer, String[]> f2 = String[]::new;
  }


}
