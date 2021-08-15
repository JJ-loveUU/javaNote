package snow;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static snow.LocalIPUtil.getLocalIP;

/**
 * 通用ServiceImpl
 */
public class BaseServiceImpl {


  SnowflakeIdWorker idWorker = null;

  private Long workerId;

  private Long dataCenterId;

  public Long generateSnowflakeId() {
    if (idWorker == null) {
      if (workerId == null) {
        workerId = 0l;
      }
      if (dataCenterId == null) {
        dataCenterId = 0l;
      }
      try {
        String[] ip = getLocalIP().split("\\.");
        workerId = Long.parseLong(ip[3]) % SnowflakeIdWorker.getMaxWorkerId();
      } catch (Exception e) {
        e.printStackTrace();
      }
      idWorker = new SnowflakeIdWorker(workerId, dataCenterId);
    }
    return idWorker.nextId();
  }

  public static void main(String[] args) {
    BaseServiceImpl baseService = new BaseServiceImpl();
    Long aLong = baseService.generateSnowflakeId();
    Long aLong2 = baseService.generateSnowflakeId();
    System.out.println(aLong);
    System.out.println(aLong2);
  }
}
