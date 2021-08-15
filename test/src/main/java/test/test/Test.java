package test.test;

import com.jcraft.jsch.ChannelSftp;

/**
 * @Author yh
 * @Date 2021/4/13 23:01
 */
public class Test {

  public static void main(String[] args) throws Exception {

    ChannelSftp channelSftp = StfpUtil.sftpConnection("47.117.131.124", 22, "user1", "123456");
    StfpUtil.downSftpFile(channelSftp, "bbb.txt","/upload/test/","aaa.txt","D:");
    StfpUtil.sessionClose();
  }
}
