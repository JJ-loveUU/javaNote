package 泛型的学习.类型通配符.类型通配符上限;

import lombok.Data;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author yh
 * @Date 2020/9/10 11:03
 */
public class GenericUpLimit<T> {



  public static void main(String[] args) {

    ArrayList<Cat> cats = new ArrayList<Cat>();
    ArrayList<MiniCat> miniCats = new ArrayList<MiniCat>();
    ArrayList<Animal> animals = new ArrayList<Animal>();

    test(cats);
    //报错
//    test(animals);

    test2(cats);
    test2(animals);
    //报错
//    test2(miniCats);


    //测试treeset
    TreeSet<Cat> cats1 = new TreeSet<Cat>(new comp1());

    //这样就报错了TreeSet(Comparator<? super E> comparator) 这里的E就是cat类
//    TreeSet<Cat> cats2 = new TreeSet<Cat>(new comp2());


  }

  //只能传Cat以及cat的子类
  public static void test(List<? extends Cat> list){
    for (int i = 0; i < list.size(); i++) {
      //类型为cat
      Cat cat = list.get(i);
    }

  }

  //只能传Cat以及Cat的父类
  public static void test2(List<? super Cat> list){
    for (int i = 0; i < list.size(); i++) {
      //类型为object和上面的有区别，因为这里不确定父类是哪个类
      Object object = list.get(i);
    }
  }


  static class comp1 implements Comparator<Cat>{

    public int compare(Cat o1, Cat o2) {
      return 0;
    }
  }
  static class comp2 implements Comparator<MiniCat>{

    public int compare(MiniCat o1, MiniCat o2) {
      return 0;
    }
  }






}
