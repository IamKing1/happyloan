package com.group8.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.UUID;

/**
 * className:FtpUtil
 * discriptoin:
 * author:zz
 * createTime:2018-12-03 14:13
 */
public class FtpUtil {

    @Value("${remoteIp}")
    private  String remoteIp;

    @Value("${uploadPort}")
    private  int uploadPort;

    @Value("${ftpUserName}")
    private static String ftpUserName;

    @Value("${ftpPassWord}")
    private static String ftpPassWord;

    @Value("${remotePath}")
    private static String remotePath;

    /**
     * 将图片上传到ftp远程服务器
     */
    public static String  upLoad(MultipartFile multipartFile){
        System.out.println(new FtpUtil().remoteIp+"....");
        //创建客户端对象
        FTPClient ftp = new FTPClient();
        InputStream local = null;
        try {
          //  System.out.println(new FileUpAndDown().remoteIp);
            //连接ftp服务器
            ftp.connect("172.16.22.65",21);
            //登录
            ftp.login("userlilongwei","aaalilongwei");
            //设置上传路径
            String path = "/";
            //检查上传路径是否存在 如果不存在返回false
            boolean flag = ftp.changeWorkingDirectory(path);
            if(!flag){
                //创建上传的路径 该方法只能创建一级目录,在这里如果/home/ftpadmin存在则可以创建image
                ftp.makeDirectory(path);
            }
            //指定上传路径
            ftp.changeWorkingDirectory(path);
            //指定上传文件的类型 二进制文件
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            // MultipartFile multipartFile=null;
            //获取文件的绝对路径
            //String absolutePath = multipartFile.getResource().getFile().getAbsolutePath();
            //System.out.println(absolutePath+"绝对路径。。。。。。。。。。。");

            String originalFilename = multipartFile.getOriginalFilename();
            String newFileName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
            //读取本地文件
            File file =new File("D:/images/"+File.separator+newFileName);
            multipartFile.transferTo(file);
           // org.apache.commons.io.FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),file);
            System.out.println(file.length()+"............");
            local = new FileInputStream(file);
            //第一个参数是文件名
            ftp.storeFile(file.getName(),local);
            return newFileName;
        }catch (SocketException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //关闭文件流
                if(local!=null)
                    local.close();
                //退出
                if(ftp!=null) {
                    ftp.logout();
                    //断开连接
                    ftp.disconnect();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

}
