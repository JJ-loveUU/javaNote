package optional的基本用法;

import jdk.nashorn.internal.runtime.options.Option;
import lamda基本有用法.Employee;
import lamda基本有用法.Status;

import java.util.Optional;

/**
 * 静态方法：
 * Optional.of(T t)创建一个Optional实例
 * Optional.empty()创建一个空的optional实例
 * Optional.ofNullable(T t)若t不为null,创建Optional实例，否则创建空实例
 * <p>
 * 实例方法：
 * isPresent():判断是否包含值
 * orElse(T t) 如果调用对象包含值，返回该值，否则返回t
 * orElseGet(Supplier s): 如果对象包含值，则返回值，否则返回s获取的值
 * map（Function f）:如果有值对其进行处理，并返回处理后的Optional,否则返回Optional.empty()
 * flatMap(Function mapper): 与map类似，要求返回值必须是Optional
 *
 * @Author yh
 * @Date 2020/9/12 11:15
 */
public class Test {

  @org.junit.Test
  public void test1() {

//    Optional<Employee> employee = Optional.ofNullable(null);
//    System.out.println(employee.orElse(new Employee()).getName());

    Optional<Employee> employee1 = Optional.ofNullable(new Employee());
    //这里就少了一个if判断了
    Optional<String> s = employee1.map(e -> e.getName());
//    如果name的值不存在就返回default的值
    System.out.println(s.orElse("default"));
  }
}
