package stream的基本用法;

import lombok.Data;

/**
 * 交易员
 *
 * @Author yh
 * @Date 2020/9/11 22:16
 */
@Data
public class Trader {

  private String name;
  private String city;

  public Trader() {
  }

  public Trader(String name, String city) {
    this.name = name;
    this.city = city;
  }

}
