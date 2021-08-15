package test.test;

import java.util.HashMap;

/**
 * @Author yh
 * @Date 2021/1/18 22:04
 */
public class User {
  private String username;
  private int age;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public static void main(String[] args) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("a", null);
    System.out.println(map.get("a"));

  }
}
