package 设计模式.适配器模式;

/**
 * iphone手机需要5V的电压
 * @Author yh
 * @Date 2020/11/8 12:42
 */
public class Iphone {

  public void charging(Voltage5V voltage5V){
    voltage5V.give5v();
    System.out.println("开始充电");
  }

  public static void main(String[] args) {
    //测试
    new Iphone().charging(new ChangeVoltageAdaptor(new Voltage220VInstance()));
  }
}
