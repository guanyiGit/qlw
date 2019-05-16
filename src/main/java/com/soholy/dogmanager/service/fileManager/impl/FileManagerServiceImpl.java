package com.soholy.dogmanager.service.fileManager.impl;

import com.soholy.dogmanager.entity.TImages;
import com.soholy.dogmanager.entity.TImagesRef;
import com.soholy.dogmanager.entity.TImagesRefExample;
import com.soholy.dogmanager.mapper.TImagesMapper;
import com.soholy.dogmanager.mapper.TImagesRefMapper;
import com.soholy.dogmanager.service.fileManager.FileManagerService;
import com.soholy.dogmanager.service.fileManager.util.FileUpload;
import com.soholy.dogmanager.service.fileManager.util.PictureResult;
import com.soholy.dogmanager.service.fileManager.util.UploadResult;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * 项目名称：dogmanager-fileManager
 * 类名称：FIleManagerService
 * 类描述：
 * 创建人：YL
 * 创建时间：2018年8月30日 下午8:44:07
 * 修改人：Administrator
 * 修改时间：2018年8月30日 下午8:44:07
 * 修改备注：
 */
@Service
public class FileManagerServiceImpl implements FileManagerService {

    @Autowired
    private TImagesMapper imagesMapper;

    @Autowired
    private TImagesRefMapper imagesRefMapper;

    @Value("${BASE_URL_PIC}")
    public String BASE_URL_PIC;//url前缀

    @Transactional
    @Override
    public PictureResult upPicture(MultipartFile attach, Long Id, Integer type) {

        PictureResult result = new PictureResult();
        // 1.获取文件后缀名
        String ext = attach.getOriginalFilename().substring(attach.getOriginalFilename().lastIndexOf(".") + 1);
        NameValuePair[] meta_list = new NameValuePair[4];
        meta_list[0] = new NameValuePair("fileName", attach.getOriginalFilename());
        meta_list[1] = new NameValuePair("fileLength", String.valueOf(attach.getSize()));
        meta_list[2] = new NameValuePair("fileExt", ext);
        meta_list[3] = new NameValuePair("fileAuthor", "");
        try {
            //2.上传
            UploadResult uploadResult = FileUpload.uploadImgReturnUrls(attach.getBytes(), ext, meta_list);
            //3.入库
            TImages images = new TImages();
            images.setImageExt(ext);
            images.setImageName(attach.getOriginalFilename());
            images.setImageSize((double) attach.getSize());
            images.setImageTitile("");
            images.setImageUrl(BASE_URL_PIC + uploadResult.getUrl());
            images.setThumbnailSize(0.0);
            images.setThumbnailUrl(BASE_URL_PIC + uploadResult.getThumbnailUrl());
            images.setCrationTime(new Date());
            imagesMapper.insertSelective(images);

            TImagesRef imagesRef = new TImagesRef();
            imagesRef.setImageId(images.getImageId());
            imagesRef.setRefId(Id);
            imagesRef.setCreationTime(new Date());
            imagesRef.setTargetType(type);
            imagesRefMapper.insertSelective(imagesRef);
            result.setError(0);
            result.setUrl(BASE_URL_PIC + uploadResult.getThumbnailUrl());
        } catch (Exception e) {
            e.printStackTrace();
            result.setError(1);
            result.setMessage("图片上传失败");
        }
        return result;

    }


    //批量上传
    @Override
    @Transactional
    public void upPictureBatch(HttpServletRequest request, Long Id, Integer type) throws Exception {

        MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = Murequest.getFileMap();//得到文件map对象

        for (String key : files.keySet()) {
            MultipartFile attach = files.get(key);
            // 1.获取文件后缀名
            String ext = attach.getOriginalFilename().substring(attach.getOriginalFilename().lastIndexOf(".") + 1);
            NameValuePair[] meta_list = new NameValuePair[4];
            meta_list[0] = new NameValuePair("fileName", attach.getOriginalFilename());
            meta_list[1] = new NameValuePair("fileLength", String.valueOf(attach.getSize()));
            meta_list[2] = new NameValuePair("fileExt", ext);
            meta_list[3] = new NameValuePair("fileAuthor", "");

            //2.上传
            UploadResult uploadResult = FileUpload.uploadImgReturnUrls(attach.getBytes(), ext, meta_list);
            //3.入库
            TImages images = new TImages();
            images.setImageExt(ext);
            images.setImageName(attach.getOriginalFilename());
            images.setImageSize((double) attach.getSize());
            images.setImageTitile("");
            images.setImageUrl(BASE_URL_PIC + uploadResult.getUrl());
            images.setThumbnailSize(0.0);
            images.setThumbnailUrl(BASE_URL_PIC + uploadResult.getThumbnailUrl());
            images.setCrationTime(new Date());
            imagesMapper.insertSelective(images);

            TImagesRef imagesRef = new TImagesRef();
            imagesRef.setImageId(images.getImageId());
            imagesRef.setRefId(Id);
            imagesRef.setCreationTime(new Date());
            imagesRef.setTargetType(type);
            imagesRefMapper.insertSelective(imagesRef);
        }
    }

    //返回url
    @Override
    @Transactional
    public UploadResult uploadSinglePic(HttpServletRequest request) throws Exception {

        MultipartHttpServletRequest Murequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> files = Murequest.getFileMap();//得到文件map对象
        UploadResult uploadResult = null;
        for (String key : files.keySet()) {
            MultipartFile attach = files.get(key);
            // 1.获取文件后缀名
            String ext = attach.getOriginalFilename().substring(attach.getOriginalFilename().lastIndexOf(".") + 1);
            NameValuePair[] meta_list = new NameValuePair[4];
            meta_list[0] = new NameValuePair("fileName", attach.getOriginalFilename());
            meta_list[1] = new NameValuePair("fileLength", String.valueOf(attach.getSize()));
            meta_list[2] = new NameValuePair("fileExt", ext);
            meta_list[3] = new NameValuePair("fileAuthor", "");

            //2.上传
            uploadResult = FileUpload.uploadImgReturnUrls(attach.getBytes(), ext, meta_list);
            //3.入库
            TImages images = new TImages();
            images.setImageExt(ext);
            images.setImageName(attach.getOriginalFilename());
            images.setImageSize((double) attach.getSize());
            images.setImageTitile("");
            images.setImageUrl(BASE_URL_PIC + uploadResult.getUrl());
            images.setThumbnailSize(0.0);
            images.setThumbnailUrl(BASE_URL_PIC + uploadResult.getThumbnailUrl());
            images.setCrationTime(new Date());
            imagesMapper.insertSelective(images);
            uploadResult.setUrl(BASE_URL_PIC + uploadResult.getUrl());
            uploadResult.setThumbnailUrl(BASE_URL_PIC + uploadResult.getThumbnailUrl());
//			TImagesRef imagesRef = new TImagesRef();
//			imagesRef.setImageId(images.getImageId());
//			imagesRef.setCreationTime(new Date());
//			imagesRefMapper.insertSelective(imagesRef);
        }
        return uploadResult;
    }

    @Override
    @Transactional
    public boolean removePicById(Long picId) {
        if (picId != null) {
            int imgCount = imagesMapper.deleteByPrimaryKey(picId);
            TImagesRefExample example = new TImagesRefExample();
            example.createCriteria().andImageIdEqualTo(picId);
            int imgRefCount = imagesRefMapper.deleteByExample(example);
            if (imgCount > 0 && imgRefCount > 0) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public void deletePicture(Long Id, Integer type, List<String> urlList)  {
        try {
            List<Long> pids = new ArrayList<>();
            List<TImagesRef> imagesRefs = imagesRefMapper.slelctByRefIdAndType(Id, type);
            if (imagesRefs != null && imagesRefs.size() > 0) {
                //获取pic信息
                List<String> urls = new ArrayList<>();
                imagesRefs.stream().forEach(item -> {
                    TImages image = imagesMapper.selectByPrimaryKey(item.getImageId());
                    boolean flag = true;   //判断当前图片是否需要删除  true:删除  false:不删除
                    if (urlList != null && urlList.size()>0){
                        for (String url:urlList) {
                            if (url.equals(image.getImageUrl())){
                                flag = false;
                            }
                        }
                    }
                    if (flag){
                        String imageUrl = image.getImageUrl().substring(image.getImageUrl().indexOf("group"));  //原图url
                        String thumbnailUrl = image.getThumbnailUrl().substring(image.getThumbnailUrl().indexOf("group")); //缩略图url
                        urls.add(imageUrl);
                        urls.add(thumbnailUrl);
                        //删除图片关联信息
                        imagesRefMapper.deleteByPrimaryKey(item.getImageRefId());
                        //删除本地数据库数据
                        imagesMapper.deleteByPrimaryKey(image.getImageId());
                    }
                });
                //删除文件服务器数据
                FileUpload.deleteFile(urls);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @SuppressWarnings("all")
    @Transactional
    @Override
    public void editPictureBatch(MultipartFile[] files, Long Id, Integer type, List<String> urlList){
        try {
            //删除原来的图片
            this.deletePicture(Id, type,urlList);
            //添加新图片
            Arrays.asList(files).stream().forEach(file -> {
                // 1.获取文件后缀名
                String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                NameValuePair[] meta_list = new NameValuePair[4];
                meta_list[0] = new NameValuePair("fileName", file.getOriginalFilename());
                meta_list[1] = new NameValuePair("fileLength", String.valueOf(file.getSize()));
                meta_list[2] = new NameValuePair("fileExt", ext);
                meta_list[3] = new NameValuePair("fileAuthor", "");
                try {
                    UploadResult uploadResult = FileUpload.uploadImgReturnUrls(file.getBytes(), ext, meta_list);
                    //3.入库
                    TImages images = new TImages();
                    images.setImageExt(ext);
                    images.setImageName(file.getOriginalFilename());
                    images.setImageSize((double) file.getSize());
                    images.setImageTitile("");
                    images.setImageUrl(BASE_URL_PIC + uploadResult.getUrl());
                    images.setThumbnailSize(0.0);
                    images.setThumbnailUrl(BASE_URL_PIC + uploadResult.getThumbnailUrl());
                    images.setCrationTime(new Date());
                    imagesMapper.insertSelective(images);

                    TImagesRef imagesRef = new TImagesRef();
                    imagesRef.setImageId(images.getImageId());
                    imagesRef.setRefId(Id);
                    imagesRef.setCreationTime(new Date());
                    imagesRef.setTargetType(type);
                    imagesRefMapper.insertSelective(imagesRef);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteFile(Long id, Integer type, List<String> urlList) throws Exception {
        List<Long> pids = new ArrayList<>();
        List<TImagesRef> imagesRefs = imagesRefMapper.slelctByRefIdAndType(id, type);
        if (imagesRefs != null && imagesRefs.size() > 0) {
            //获取pic信息
            List<String> urls = new ArrayList<>();
            imagesRefs.stream().forEach(item -> {
                TImages image = imagesMapper.selectByPrimaryKey(item.getImageId());
                boolean flag = false;   //判断当前图片是否需要删除  true:删除  false:不删除
                if (urlList != null && urlList.size()>0){
                    for (String url:urlList) {
                        if (url.equals(image.getImageUrl())){
                            flag = true;
                        }
                    }
                }
                if (flag){
                    String imageUrl = image.getImageUrl().substring(image.getImageUrl().indexOf("group"));  //原图url
                    String thumbnailUrl = image.getThumbnailUrl().substring(image.getThumbnailUrl().indexOf("group")); //缩略图url
                    urls.add(imageUrl);
                    urls.add(thumbnailUrl);
                    //删除图片关联信息
                    imagesRefMapper.deleteByPrimaryKey(item.getImageRefId());
                    //删除本地数据库数据
                    imagesMapper.deleteByPrimaryKey(image.getImageId());
                }
            });
            //删除文件服务器数据
            FileUpload.deleteFile(urls);
        }
    }
}

