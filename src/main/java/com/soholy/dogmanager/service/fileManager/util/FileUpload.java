package com.soholy.dogmanager.service.fileManager.util;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

//文件上传工具类
public class FileUpload {
   
//    public static void main(String[] args){
//        byte[] bs = null;
//        try {
//            bs = HttpCaller.get("E:/ceshi.png", null);
//            UploadResult uploadResult = FileUpload.uploadImgReturnUrls(bs,"png",null);
//        } catch (Exception e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//    }

    /**
     * 上传图片调用此方法返回原图和缩略图的url
     * @param fileContent 图片的byte数组
     * @param extName 图片后缀名
     * @param metas 图片说明数组
     * @return
     * @throws Exception
     */
    public static UploadResult uploadImgReturnUrls(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception{
        String url=null;
        String thumbnailUrl=null;
        UploadResult uploadResult = new UploadResult();
        url=uploadUrl(fileContent,extName,metas);
        thumbnailUrl=uploadThumbnailUrl(fileContent,extName,metas);
        uploadResult.setUrl(url);
        uploadResult.setThumbnailUrl(thumbnailUrl);
        return uploadResult;
    }

    public static String uploadUrl(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception{
        ByteArrayInputStream intputStream = new ByteArrayInputStream(fileContent);
        Thumbnails.Builder<? extends InputStream> builder = Thumbnails.of(intputStream).scale(0.5f);
        BufferedImage bufferedImage = builder.asBufferedImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, extName, baos);//extName:"png"
        byte[] byteArray = baos.toByteArray();
        FastDFSClient fastDFSClient = new FastDFSClient("classpath:/resource/client.conf");
        String imgPath = fastDFSClient.uploadFile(byteArray,extName,metas);
//        System.out.print(imgPath);
        
        return imgPath;
    }
    public static String uploadThumbnailUrl(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception{
        ByteArrayInputStream intputStream = new ByteArrayInputStream(fileContent);
        Thumbnails.Builder<? extends InputStream> builder = Thumbnails.of(intputStream).size(120, 120);
        BufferedImage bufferedImage = builder.asBufferedImage();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, extName, baos);//extName:"png"
        byte[] byteArray = baos.toByteArray();
        FastDFSClient fastDFSClient = new FastDFSClient("classpath:/resource/client.conf");
        String imgPath = fastDFSClient.uploadFile(byteArray,extName);
//        System.out.print(imgPath);
        return imgPath;
    }

    public static int deleteFile(List<String> urls)throws Exception{
        FastDFSClient fastDFSClient = new FastDFSClient("classpath:/resource/client.conf");
        Integer count = 0;
        if (urls != null && urls.size() > 0){
            for (String url:urls) {
                String group_name = StringUtils.substringBefore(url, "/");
                String file_url = StringUtils.substringAfter(url, "/");
                Integer integer = fastDFSClient.delete_file(group_name,file_url);
                if (integer >= 0){
                    count += integer;
                }
            }
        }
        return count;
    }

    public static void deletePic(String group_name,String file_url){

        FastDFSClient fastDFSClient = null;
        try {
            fastDFSClient = new FastDFSClient("classpath:/resource/client.conf");
            fastDFSClient.delete_file(group_name,file_url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
