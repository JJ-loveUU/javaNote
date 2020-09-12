package 泛型的学习.类型通配符;

import 泛型的学习.泛型类.Generic;

/**
 * @Author yh
 * @Date 2020/9/10 10:50
 */
public class GenricGeneral {


  public static void main(String[] args) {
    GeneralChar<String> stringGeneralChar = new GeneralChar<>();
    stringGeneralChar.setT("a");

    //通过
    test2(stringGeneralChar);
  }

  //这样就限定了Integer类型
  public static void test(GeneralChar<Integer> g){
    System.out.println(g.getT());
  }

  //使用了类型通配符，这样就可以传任意类型了
  public static void test2(GeneralChar<?> g){
    System.out.println(g.getT());
  }

}
