package 泛型的学习.泛型和数组;

import java.util.ArrayList;

/**
 * @Author yh
 * @Date 2020/9/10 13:53
 */
public class Test {
  public static void main(String[] args) {
    //可以创建带泛型的数组引用，单不能创建带泛型的数组对象

    //报错了，右边直接创建了带泛型的数组对象
//    ArrayList<String>[] listArr2=new ArrayList<String>[5];


    //定义带泛型的数组对象正确方式,类型为arraylist的数组,数组大小为5
    ArrayList<String>[] listArr = new ArrayList[5];

    ArrayList<String> strings = new ArrayList<String>();
    strings.add("a");
    listArr[0] = strings;

    ArrayList<Integer> ints = new ArrayList<Integer>();
    ints.add(1);
    //报错
//    listArr[0] = ints;


  }
}
