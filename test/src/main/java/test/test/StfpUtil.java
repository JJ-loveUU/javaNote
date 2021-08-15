package test.test;

import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @Author yh
 * @Date 2021/4/13 23:01
 */
public class StfpUtil {
  private static Session sshSession;

  /**
   * 连接sftp服务器
   * @param host  ftp地址
   * @param port  端口
   * @param userName 账号
   * @param password 密码
   * @return
   */
  public static ChannelSftp sftpConnection(String host, int port, String userName, String password){
    JSch jsch = new JSch();
    ChannelSftp channelSftp = null;
    try {
      jsch.getSession(userName, host, port);
      sshSession = jsch.getSession(userName, host, port);
      sshSession.setPassword(password);
      Properties properties = new Properties();
      properties.put("StrictHostKeyChecking", "no");
      sshSession.setConfig(properties);
      sshSession.connect();
      Channel channel = sshSession.openChannel("sftp");
      channel.connect();
      channelSftp = (ChannelSftp) channel;
    }catch (JSchException e){
      e.printStackTrace();
    }
    return channelSftp;
  }

  /**
   *@description 退出Sftp服务器登录
   *@return
   **/
  public static void sftpClose(ChannelSftp channelSftp){
    if (channelSftp != null) {
      if (channelSftp.isConnected()){
        channelSftp.disconnect();
      }
    }
  }

  /**
   * 关闭session
   */
  public static void sessionClose(){
    if (sshSession != null) {
      if (sshSession.isConnected()){
        sshSession.disconnect();
        sshSession = null;
      }
    }
  }
  /**
   * 下载sftp文件
   * @param sftp
   * @param newFileName 新文件名称
   * @param path 文件路径
   * @param fileName 文件名称
   * @param downUrl 下载到本地的路径
   * @throws Exception
   */
  public static void downSftpFile(ChannelSftp sftp, String newFileName,String path, String fileName, String downUrl) throws Exception {


    OutputStream os=null;
    try {
      File localFile = new File(downUrl + "/" + newFileName);
      if (!localFile.getParentFile().exists()) {
        localFile.getParentFile().mkdirs();
        localFile.createNewFile();
      }

      if (path != null && !"".equals(path)) {
        sftp.cd(path);//进入所在路径
      }
      os = new FileOutputStream(localFile);
      sftp.get(path + fileName, os);
      os.close();
    }catch (Exception e){
      e.printStackTrace();
    }
  }

}
