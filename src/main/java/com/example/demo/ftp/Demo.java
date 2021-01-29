package com.example.demo.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(1000*30);//设置连接超时时间
        ftpClient.setControlEncoding("utf-8");//设置ftp字符集
        ftpClient.enterLocalPassiveMode();//设置被动模式，文件传输端口设置
        ftpClient.connect("20.26.37.168");
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//设置文件传输模式为二进制，可以保证传输的内容不会被改变
        ftpClient.login("bomc","bomc");
        int replyCode = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(replyCode)){
            ftpClient.disconnect();
        }

        ftpClient.changeWorkingDirectory("/data/logs/larkbird/");
        FTPFile[] ftpFiles = ftpClient.listFiles("/data/logs/larkbird/kefu");
        for (FTPFile ftpFile : ftpFiles) {
            FTPFile[] files = ftpClient.listFiles("/data/logs/larkbird/kefu/" + ftpFile.getName());
            for (FTPFile file : files) {
                if (file.getName().equals("100093412detail_deploy.json")) {
                    String path = "/data/logs/larkbird/kefu/" + ftpFile.getName() + "/100093412detail_deploy1.json";
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    boolean b = ftpClient.retrieveFile(path, out);
                    System.out.println(b);
                    out.close();
                }
            }
        }
    }

}
