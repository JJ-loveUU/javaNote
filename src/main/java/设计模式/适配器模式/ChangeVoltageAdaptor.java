package 设计模式.适配器模式;

/**
 * 将220V转换为5V的适配器
 *
 * @Author yh
 * @Date 2020/11/8 12:47
 */
public class ChangeVoltageAdaptor implements Voltage5V {
  private Voltage220VInstance voltage220VInstance;

  public ChangeVoltageAdaptor(Voltage220VInstance voltage220VInstance) {
    this.voltage220VInstance = voltage220VInstance;
  }

  @Override
  public void give5v() {
    voltage220VInstance.give220V();
    System.out.println("将220V的电压转换为5V");
  }
}
