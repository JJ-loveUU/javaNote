package stream的基本用法;

import lamda基本有用法.Employee;
import lamda基本有用法.Status;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Author yh
 * @Date 2020/9/11 14:46
 * <p>
 * <p>
 * stream用来操作集合、数组，不会对数据源产生影响会生成新的stream
 * <p>
 * stream的三个操作步骤
 * 1.创建stream
 * <p>
 * 2.中间操作(中间操作可以连接为一个流水线，除非执行中止操作，否则中间操作不会执行任何代码，而在中止操作时一并执行，称为惰性求值)
 * 2.1 filter(Predicate p) 接受lamda,从中排除一些元素
 * 2.2 limit(n) 使其元素不超过给定的数量n（当找到满足条件的个数n,不再执行后面的迭代，称为短路）
 * 2.3 skip(n) 返回一个跳过前n个元素的流，若元素不足n个，则返回空流。与limit互补
 * 2.4 distinct 通过hashcode和equals方法去除掉重复的元素
 * <p>
 * 2.5 映射
 * 2.5.1 map 接受lambda,将元素转换成其他形式或提取信息。接受一个函数作为参数，该函数将被用到每个元素上，并将其映射成一个新的元素
 * 2.5.2 flatMap--接受一个函数作为参数，该函数将流中的每个值转成另一个流，然后把所有的流合并为一个流
 * <p>
 * 2.6 排序（从小到大）
 * 自然排序，根据comparable去排
 * 定制化，传入comparator接口去排序
 * <p>
 * 3.终止操作
 * allMatch-检查是否匹配所有元素
 * anyMatch-检查是否至少匹配一个元素
 * noneMatch检查是否没有任何元素匹配
 * findFirst返回第一个元素
 * count-返回流中元素的总个数
 * max返回流中的最大值
 * min返回流中的最小值
 * <p>
 * reduce 规约-将流中的元素反复结合，得到一个值
 * collector 收集-将流转换为其他形式,用于给stream中元素进行汇总的。配合Collectors类的静态方法使用
 * <p>
 * -------------------------------------------
 * 并行流和串行流：
 * 并行流就像是分开了多个线程并行执行任务
 */
public class Test {

  @org.junit.Test
  public void test() {

    //创建stream的方式：

    //1.通过collection集合提供的stream和parallelStream
    ArrayList<Object> list = new ArrayList<>();
    Stream<Object> stream = list.stream();

    //2.通过Arrays中的静态方法stream()获取
    Employee[] employees = new Employee[10];
    Stream<Employee> stream2 = Arrays.stream(employees);

    //3.通过stream中的静态方法of
    Stream<Integer> integerStream = Stream.of(1, 33, 4);

    //4.创建无限流
    //4.1迭代
    Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);
    iterate.limit(10).forEach(System.out::println);
    //4.2生成
    Stream.generate(() -> Math.random());


  }

  @org.junit.Test
  public void test2() {
    ArrayList<Employee> list = new ArrayList<>();
    list.add(new Employee("a", 10));
    list.add(new Employee("b", 20));
    list.add(new Employee("c", 30));
    list.add(new Employee("d", 40));
    list.add(new Employee("d", 40));
    list.add(new Employee("d", 40));
    List<Integer> collect = list.stream().map(Employee::getAge).collect(Collectors.toList());
    //中间操作
    List<Employee> stream1 = list.stream().filter(x -> {
      System.out.println("中间操作");
      return x.getAge() > 10;
    }).collect(Collectors.toList());

    //终止操作
//    stream1.limit(1).forEach(System.out::println);
//    stream1.distinct().forEach(System.out::println);


    //map映射
//    stream1.map((x) -> x.getName()).forEach(System.out::println);
    //或者
//    stream1.map(Employee::getName).forEach(System.out::println);


    //flatMap--接受一个函数作为参数，该函数将流中的每个值转成另一个流，然后把所有的流合并为一个流(简单的将流理解为一个list或数组即可，
    // 流只是用来简化操作的)
    List<String> strList = Arrays.asList("aaaa", "bbb", "cc");

    //原始写法
//    strList.stream().map(Test::getCharArr).forEach(e -> {
//      e.forEach(System.out::println);
//    });

    //简化写法
//    strList.stream().flatMap(Test::getCharArr).forEach(System.out::println);

    //sorted()排序
//    strList.stream().sorted().forEach(System.out::println);
    //sorted()根据comparator接口去排序
    Stream<String> stream = strList.stream();

    stream.sorted((x, y) -> -(x.length() - y.length())).forEach(System.out::println);//根据长度排序,长度越长排在最前面


  }

  public static Stream<Character> getCharArr(String str) {
    List<Character> list = new ArrayList<>();
    for (Character ele : str.toCharArray()) {
      list.add(ele);
    }
    return list.stream();
  }

  @org.junit.Test
  /* allMatch-检查是否匹配所有元素
   * anyMatch-检查是否至少匹配一个元素
   * noneMatch检查是否没有任何元素匹配
   * findFirst返回第一个元素
   * count-返回流中元素的总个数
   * max返回流中的最大值
   * min返回流中的最小值
   */
  public void test3() {
    ArrayList<Employee> list = new ArrayList<>();
    list.add(new Employee("a", 50, Status.A));
    list.add(new Employee("b", 20, Status.A));
    list.add(new Employee("c", 30, Status.B));
    list.add(new Employee("d", 40, Status.B));
    list.add(new Employee("e", 40, Status.B));
    list.add(new Employee("f", 40, Status.C));

    boolean b = list.stream().allMatch(e -> e.getAge() > 0);
    boolean b1 = list.stream().anyMatch(e -> e.getAge() > 30);
    boolean b2 = list.stream().noneMatch(e -> e.getAge() > 100);

    Optional<Employee> exist = list.stream().filter(e -> e.getAge() > 20).findFirst();
//    System.out.println(exist.isPresent()?exist.get():"not exist");


    long count1 = list.stream().count();
//    System.out.println(count1);

    Optional<Integer> max = list.stream().map(Employee::getAge).max(Integer::compare);
    System.out.println(max.get());

    //min方法类似

  }

  /*
   * reduce 规约-将流中的元素反复结合，得到一个值
   *
   * */

  @org.junit.Test
  public void test4() {
    ArrayList<Employee> list = new ArrayList<>();
    list.add(new Employee("a", 50, Status.A));
    list.add(new Employee("b", 20, Status.A));
    list.add(new Employee("c", 30, Status.B));
    list.add(new Employee("d", 40, Status.B));
    list.add(new Employee("e", 40, Status.B));
    list.add(new Employee("f", 40, Status.C));

    //求和
    Integer sum = list.stream().map(Employee::getAge).reduce(0, (x, y) -> x + y);
    //第二个方法
    Optional<Integer> reduce = list.stream().map(Employee::getAge).reduce(Integer::sum);
//    System.out.println(reduce.get());


    //collcet
    //转为list
    List<String> collect = list.stream().map(Employee::getName).collect(Collectors.toList());
//    System.out.println(collect);

    //转为set
    Set<String> collect2 = list.stream().map(Employee::getName).collect(Collectors.toSet());
//    System.out.println(collect2);

    //总数
    Long l = list.stream().collect(Collectors.counting());
//    System.out.println(l);

    //平均值
    Double collect1 = list.stream().collect(Collectors.averagingDouble(Employee::getAge));
//    System.out.println(collect1);

    //总和
    Double collect11 = list.stream().collect(Collectors.summingDouble(Employee::getAge));
//    System.out.println(collect11);

    //最大值
    Optional<Integer> collect3 = list.stream().map(Employee::getAge).collect(Collectors.maxBy(Integer::compare));
    //或者
    Optional<Employee> collect4 = list.stream().collect(Collectors.maxBy((x, y) -> x.getAge() - y.getAge()));
//    System.out.println(collect4);

    //分组
    Map<Status, List<Employee>> collect5 = list.stream().collect(Collectors.groupingBy(Employee::getStatus));
//    System.out.println(collect5);

    //多级分组
    Map<Status, Map<String, List<Employee>>> collect6 = list.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(Employee::getName)));
//    System.out.println(collect6);

    //分区,一个是true区，一个是false区
    Map<Boolean, List<Employee>> collect7 = list.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30));
//    System.out.println(collect7);

    //求平均值，总和，最小，最大等...
    IntSummaryStatistics collect8 = list.stream().collect(Collectors.summarizingInt(Employee::getAge));
//    System.out.println(collect8.getAverage() + "," +
//            collect8.getCount() + "," +
//            collect8.getMax() + "," +
//            collect8.getMin() + "," +
//            collect8.getSum());

    //将数组用分隔符分开
    String collect9 = list.stream().map(Employee::getName).collect(Collectors.joining(","));
    System.out.println(collect9);


  }

  /**
   * 练习
   */
  @org.junit.Test
  public void test5() {
    //1，2，3，4获取他们的平方
//    Arrays.stream(new int[]{1, 2, 3, 4}).map(x -> x * x).forEach(System.out::println);


    Trader a = new Trader("ABh", "北京");
    Trader b = new Trader("eCg", "天津");
    Trader c = new Trader("CDf", "北京");
    Trader d = new Trader("DEa", "北京");

    Stream<Transaction> stream = Arrays.asList(
            new Transaction(d, 2011, 300),
            new Transaction(a, 2012, 1000),
            new Transaction(a, 2011, 400),
            new Transaction(b, 2012, 710),
            new Transaction(b, 2012, 700),
            new Transaction(c, 2012, 950)
    ).stream();

    //1.找出2011年发生的所有交易，交易额从高到低排序
//    stream.filter(x -> x.getYear() == 2011).sorted((x, y) -> -(x.getValue() - y.getValue())).forEach(System.out::println);

    //2.交易员都在哪些不同的城市工作过
//    stream.map(Transaction::getTrader).map(Trader::getCity).distinct().forEach(System.out::println);

    //3.查找所有来自北京的交易员
//    stream.map(Transaction::getTrader).distinct().filter(x->x.getCity().equals("北京")).forEach(System.out::println);

    //4.返回所有交易员的姓名字符串，按字母顺序排序
//    stream.map(x -> x.getTrader().getName()).distinct().flatMap(Test::getStrArr).sorted((x, y) -> {
//      return x.toString().compareToIgnoreCase(y.toString());
//    }).forEach(System.out::println);

    //5.有没有交易员是在天津工作的
//    boolean exist = stream.anyMatch(e -> e.getTrader().getCity().equals("天津"));
//    System.out.println(exist);

    //6.打印生活在北京的交易员的所有交易额
    //方法 1
//    double sum = stream.filter(x -> x.getTrader().getCity().equals("北京")).collect(Collectors.summarizingDouble(Transaction::getValue)).getSum();
    //方法 2
//    Integer sum2 = stream.filter(x -> x.getTrader().getCity().equals("北京")).map(Transaction::getValue).reduce(0, (x, y) -> x + y);
//    System.out.println(sum2);

    //7.所有交易额中，最高的交易额是多少
//    Optional<Integer> max = stream.map(Transaction::getValue).max(Integer::compare);
//    System.out.println(max.get());

    //8.找到交易额最小的交易
    Optional<Integer> min = stream.map(Transaction::getValue).min(Integer::compare);
    System.out.println(min.get());

  }

  public static Stream<Character> getStrArr(String str) {

    ArrayList<Character> list = new ArrayList<>();
    for (Character ele : str.toCharArray()) {
      list.add(ele);
    }
    return list.stream();


  }

  /**
   * 并行流
   */
  @org.junit.Test
  public void test6() {
    Instant now = Instant.now();
    //不加parallel就是串行流，一个线程执行，并行就是分给多个线程执行
    long reduce = LongStream.range(0, 100000000000L).parallel().reduce(0, (x, y) -> x + y);
    Instant end = Instant.now();
    //获取时间间隔
    System.out.println(Duration.between(now, end).getSeconds());
  }

  @org.junit.Test
  public void test7(){
    ArrayList<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    List<String> collect = list.stream().filter(e -> e != "1").collect(Collectors.toList());
    list.forEach(System.out::println);
  }


}
