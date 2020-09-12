package lamda基本有用法;

import lombok.Data;

import java.util.Objects;

/**
 * @Author yh
 * @Date 2020/9/11 14:28
 */
@Data
public class Employee {
  private String name;

  private int age;

  private Status status;


  public Employee() {
  }

  public Employee(String name) {
    this.name = name;
  }

  public Employee(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Employee(String name, int age, Status status) {
    this.name = name;
    this.age = age;
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return age == employee.age &&
            Objects.equals(name, employee.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, age);
  }
}
