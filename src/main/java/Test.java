
import org.apache.http.HttpResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yh
 * @Date 2020/10/2 18:33
 */
public class Test {

  public static void main(String[] args) {
    String host = "http://yzx.market.alicloudapi.com";
    String path = "/yzx/sendSms";
    String method = "POST";
    String appcode = "15a5a47577bd4b61b12b210b1a276f6d";
    Map<String, String> headers = new HashMap<String, String>();
    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
    headers.put("Authorization", "APPCODE " + appcode);
    Map<String, String> querys = new HashMap<String, String>();
    querys.put("mobile", "17361735206");
    querys.put("param", "code:22231123");
    querys.put("tpl_id", "TP1710262");
    Map<String, String> bodys = new HashMap<String, String>();


    try {
      /**
       * 重要提示如下:
       * HttpUtils请从
       * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
       * 下载
       *
       * 相应的依赖请参照
       * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
       */
      HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
      System.out.println(response.toString());
      //获取response的body
      //System.out.println(EntityUtils.toString(response.getEntity()));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
