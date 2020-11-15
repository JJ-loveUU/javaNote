import com.sun.javaws.Main;
import org.junit.Test;
import stream的基本用法.Trader;
import sun.nio.cs.SingleByte;

import javax.swing.text.html.Option;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author yh
 * @Date 2020/11/9 21:56
 */
public class test {

  @Test
  public void test() {
    ArrayList<String> list = new ArrayList<>();
    list.add("ccc");
    System.out.println(Optional.ofNullable(list).filter(lists -> lists.size() > 0).map(e -> "aaa").orElse("bbb"));

    Trader a = new Trader("ABh", "北京");
    Trader b = new Trader("ABhc", "天津");
    Trader c = new Trader("CDf", "北京");
    Trader d = new Trader("DEa", "北京");

//    ArrayList<Trader> list2 = new ArrayList<>();
//    list2.add(a);
//    list2.add(b);
//    list2.add(c);
//    list2.add(d);
//    Map<String, Trader> collect = list2.stream().collect(Collectors.toMap(e -> e.getName(), Function.identity()));
//    System.out.println(collect);

    long l = new Date().getTime() / 1000;
    long r = Instant.now().getEpochSecond();
    System.out.println(l);
    System.out.println(r);
  }
}

enum EnumClz {

  A("a", 1), B("b", 2);

  private String msg;
  private int age;

  EnumClz(String msg, int age) {
    this.msg = msg;
    this.age = age;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public static void main(String[] args) {
//    Arrays.asList(EnumClz.values()).forEach(e-> System.out.println(e.getMsg()));
  }
}