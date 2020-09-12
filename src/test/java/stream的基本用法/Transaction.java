package stream的基本用法;

import lombok.Data;

/**
 * 交易类
 * @Author yh
 * @Date 2020/9/11 22:17
 */
@Data
public class Transaction {
  private Trader trader;
  private int year;
  private int value;

  public Transaction() {
  }

  public Transaction(Trader trader, int year, int value) {
    this.trader = trader;
    this.year = year;
    this.value = value;
  }
}
