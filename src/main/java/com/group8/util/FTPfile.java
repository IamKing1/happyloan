package com.group8.util;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.Map;
import java.util.UUID;

/**
 * className:FTPfile
 * discriptoin: Ftp上传服务器的步骤：
 * 第一步，创建一个客户端对象，
 * 第二步，连接服务器，地址，端口，
 * 第三步，实现登录信息，用户名，密码
 * 第四步，创建上传的文件文件夹 同时创建上传路径
 * 第五步，指定ftp上传路径
 * 第六步，指定上传文件类型为二进制类型
 * 第七步，读取要上传的本地文件路径，同时创建输入流
 * 第八步，用客户端上传本地文件，参数设置文件名跟输入流
 * 第九步，处理异常，关闭文件流，断开服务器连接。

 * author:丁启斌
 * createTime:2018-12-03 14:09
 */
public class FTPfile {

    static Map configPara = ConfigUtil.getConfigMap();
    static String ip=configPara.get("ip")+"";
    static int port=Integer.valueOf(configPara.get("port")+"");
    static String username=configPara.get("username")+"";
    static String password=configPara.get("password")+"";
    static String pathname=configPara.get("pathname")+"";
    static String path1=configPara.get("path")+"";

    /**
     * 将图片上传到ftp远程服务器
     */
    public static String upLoad(MultipartFile multipartFile){
        //创建客户端对象
        FTPClient ftp = new FTPClient();
        InputStream local = null;
        try {
            //连接ftp服务器
            ftp.connect(ip,port);
            //登录
            ftp.login(username,password);
            //设置上传路径
            String path = path1;
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
            File file =new File(pathname+File.separator+newFileName);
            //multipartFile.transferTo(file);
            org.apache.commons.io.FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),file);
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
