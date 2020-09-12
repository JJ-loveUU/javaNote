package lamda基本有用法;

import lombok.Data;

/**
 * @Author yh
 * @Date 2020/9/11 18:39
 */
public enum Status {

  A("A"),
  B("B"),
  C("C");

  private String status = "";

  Status(String status) {
    this.status = status;
  }

  public String getValue() {
    return status;
  }


}
