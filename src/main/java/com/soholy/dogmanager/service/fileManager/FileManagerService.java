package com.soholy.dogmanager.service.fileManager;

import com.soholy.dogmanager.service.fileManager.util.PictureResult;
import com.soholy.dogmanager.service.fileManager.util.UploadResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
* 
* 项目名称：dogmanager-fileManager 
* 类名称：FileManagerService 
* 类描述： 
* 创建人：YL
* 创建时间：2018年8月31日 上午8:37:55 
* 修改人：Administrator 
* 修改时间：2018年8月31日 上午8:37:55 
* 修改备注： 
* 
*/
public interface FileManagerService {
	
	PictureResult upPicture(MultipartFile attach,Long Id,Integer type);
	
	
	void upPictureBatch(HttpServletRequest request,Long Id,Integer type)throws Exception;

	UploadResult uploadSinglePic(HttpServletRequest request) throws Exception;

	/**
	 *  根据图片id删除图片
	 * @param picId 图片id
	 * @return
	 */
    boolean removePicById(Long picId);

	/**
	 * 批量修改图片
	 * @param files
	 * @param Id
	 * @param type
	 * @return
	 */
	void editPictureBatch(MultipartFile[] files,Long Id,Integer type, List<String> urlList)throws Exception;

	/**
	 * 根据url删除文件
	 * @param id
	 * @param type
	 * @param url
	 */
    void deleteFile(Long id, Integer type,  List<String> urlList) throws Exception;
}
