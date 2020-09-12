package jdk8其他的一些特性;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

/**
 * 如果是 JDK8 的应用，可以使用 Instant 代替 Date，LocalDateTime 代替 Calendar， DateTimeFormatter 代替 SimpleDateFormat，
 * 官方给出的解释：simple beautiful strong immutable thread-safe。
 *
 * @Author yh
 * @Date 2020/9/12 12:39
 */
public class Test {


  //传统时间格式化SimpleDateFormat的方法存在线程安全问题，使用date
  //localdate,localtime,localdatetime
  @org.junit.Test
  public void test1() {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate parse = LocalDate.parse("2018-11-01", dateTimeFormatter);
//    System.out.println(parse);


    //localdate,localtime,localdatetime
    LocalDate localDate = LocalDate.now();
    LocalTime localTime = LocalTime.now();
    LocalDateTime localDateTime = LocalDateTime.now();
    LocalDateTime of = LocalDateTime.of(2018, 11, 1, 1, 1, 1);
//    System.out.println(localDate);//2020-09-12
//    System.out.println(localTime);//13:21:13.131
//    System.out.println(localDateTime);//2020-09-12T13:21:13.131 上面两个的合并
//    System.out.println(of);//2018-11-01T01:01:01

    //格式化时间
    DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String format = localDateTime.format(dateTimeFormatter1);
//    System.out.println(format);
//    System.out.println(localDate.toString());
//    System.out.println(localTime.toString());
    localDateTime.getYear();
    localDateTime.getMonth();
    localDateTime.plusDays(1);
    DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
//    System.out.println(dayOfWeek);

    //Date转为localdatetime
    LocalDateTime localDateTime1 = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//    System.out.println(localDateTime1);

    //localdatetime转为Date
    Date from = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
//    System.out.println(from);


    //由于 LocalDate、LocalTime 或者只含有日期，或者只含有时间，因此，不能和Date直接进行转化。


  }

  @org.junit.Test
  //instant 时间戳
  //时间戳 : 指格林威治时间1970年01月01日00时00分00秒(北京时间1970年01月01日08时00分00秒)起至现在的总秒数
  public void test2() {

    Instant now = Instant.now(); //UTC时区，比我们玩了8小时

    //这几个方法都是获取时间戳的
    System.out.println(now.toEpochMilli());
    System.out.println(new Date().getTime());
    System.out.println(new Date().toInstant().toEpochMilli());
    System.out.println(System.currentTimeMillis());

  }

  /**
   * duration获取两个时间之间的间隔，比如instant之间或者localdatetime或者LocalTime
   */
  @org.junit.Test
  public void test3() throws InterruptedException {

    Instant start = Instant.now();
    Thread.sleep(3000);
    Instant end = Instant.now();
    System.out.println(Duration.between(start, end).toDays());
    System.out.println(Duration.between(start, end).getSeconds());

  }

  /**
   * period获取两个*日期*之间的时间间隔,两个localdate之间的时间间隔
   */
  @org.junit.Test
  public void test4() throws InterruptedException {

    LocalDate start = LocalDate.of(2018, 11, 1);
    LocalDate end = LocalDate.now();

    System.out.println(Period.between(start, end).getDays());

  }

  /**
   * 时间校正器
   */
  @org.junit.Test
  public void test5() {
    LocalDateTime now = LocalDateTime.now();
    //设置10号
    LocalDateTime localDateTime = now.withDayOfMonth(10);
//    System.out.println(localDateTime);


    //获取下一个星期一
    LocalDateTime nextMonday = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
//    System.out.println(nextMonday);

    //获取下一个工作日
    LocalDateTime nextWorkday = now.with(x -> {
      LocalDateTime x1 = (LocalDateTime) x;
      if (x1.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
        return x1.plusDays(2);
      }
      //...其他情况省略了
      return x;
    });
    System.out.println(nextWorkday);
  }

  /**
   * datetimefort时间格式化
   */
  @org.junit.Test
  public void test6() {
    LocalDateTime now = LocalDateTime.now();
    //默认的一些格式化形式
    DateTimeFormatter f1 = DateTimeFormatter.ISO_DATE;
    DateTimeFormatter f2 = DateTimeFormatter.ISO_DATE_TIME;
    String r1 = f1.format(now);
    String r2 = f2.format(now);
//    System.out.println(r1);
//    System.out.println(r2);

    //自定义格式化
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年 MM月 dd日 HH:mm:ss");
    String format = now.format(dateTimeFormatter);
    String format1 = dateTimeFormatter.format(now);
//    System.out.println(format);
//    System.out.println(format1);

    //解析
    LocalDateTime parse = LocalDateTime.parse("2020年 09月 12日 15:40:51", dateTimeFormatter);
    System.out.println(parse);
  }

  /**
   * 时区
   */
  @org.junit.Test
  public void test7() {

    //所有的时区信息,
    /*
    Mexico/General
    Pacific/Wallis
    Europe/Gibraltar
    Africa/Conakry
    Africa/Lubumbashi
    Asia/Istanbul
    America/Havana
    ...
    */
    Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
//    availableZoneIds.forEach(System.out::println);

    //获取某个时区的时间
    LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
    ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("Asia/Shanghai"));//携带时区
    System.out.println(now);//2020-09-12T15:54:32.218
    System.out.println(zonedDateTime);//2020-09-12T15:54:32.218+08:00[Asia/Shanghai]  携带时区

  }


  //重复注解和类型注解。。。暂时先不学了


}
