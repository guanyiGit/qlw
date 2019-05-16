package com.soholy.dogmanager.controller.fileManager;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.result.GlobalResult;
import com.soholy.dogmanager.service.fileManager.FileManagerService;
import com.soholy.dogmanager.service.fileManager.util.PictureResult;
import com.soholy.dogmanager.service.fileManager.util.UploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/** 
* 
* 项目名称：dogmanager-web 
* 类名称：FileManagerController 
* 类描述： 
* 创建人：YL
* 创建时间：2018年8月30日 下午7:59:43 
* 修改人：Administrator 
* 修改时间：2018年8月30日 下午7:59:43 
* 修改备注： 
* 
*/
@Controller
@RequestMapping("/biz/fileManager")
public class 	FileManagerController {
	
	@Autowired
	private FileManagerService fileManagerService;


	
	/**
	 * 
	 * from表单上传
	 *参数一：MultipartFile 文件对象
	 *参数二：业务对象id
	 *参数三:图片类型
	 * 
	 * */
	//@RequiresPermissions("/fileManager/uploadFile")
	@RequestMapping("/uploadFile")
	@ResponseBody
	public PictureResult uploadFile( MultipartFile attach,Long Id,Integer type) throws Exception{
		PictureResult result = fileManagerService.upPicture(attach, Id, type);
		return result;
	}
	/**
	 *
	 * from表单上传
	 *参数一：MultipartFile 文件对象
	 *参数二：业务对象id
	 *参数三:图片类型
	 *
	 * */
	//@RequiresPermissions("/fileManager/uploadFile")
	@RequestMapping("/uploadFileTxy")
	@ResponseBody
	public PictureResult uploadFileTxy( MultipartFile files,Long id,Integer type) throws Exception{
		PictureResult result = fileManagerService.upPicture(files, id, type);
		return result;
	}
	
	/**
	 * 支持批量上传
	 *参数一： HttpServletRequest 
	 *参数二：业务对象id
	 *参数三:图片类型
	 * 
	 * */
	@RequestMapping("/uploadFileBatch")
	@ResponseBody
	public DogResult uploadFileBatch( HttpServletRequest request,Long Id,Integer type) throws Exception{
		try {
			fileManagerService.upPictureBatch(request, Id, type);
			return DogResult.ok();
		} catch (Exception e) {
			return DogResult.build(400, "上传失败");
		}
	}

	/**
	 * 支持批量修改
	 *参数一： HttpServletRequest
	 *参数二：业务对象id
	 *参数三:图片类型
	 *
	 * */
	@RequestMapping("/editFileBatch")
	@ResponseBody
	public DogResult editFileBatch(@RequestParam("file") MultipartFile[] files, Long Id, Integer type, @RequestParam("urlList") List<String> urlList){
		try {
			fileManagerService.editPictureBatch(files,Id,type,urlList);
			return DogResult.ok();
		} catch (Exception e) {
			return DogResult.build(400, "上传失败");
		}
	}


	/**
	 * 根据文件rl删除文件信息
	 *参数一： HttpServletRequest
	 *参数二：业务对象id
	 *参数三:图片url
	 *
	 * */
	@RequestMapping("/deleteFile")
	@ResponseBody
	public DogResult deleteFile(Long Id, Integer type, @RequestParam("urlList") List<String> urlList){
		try {
			fileManagerService.deleteFile(Id,type,urlList);
			return DogResult.ok();
		} catch (Exception e) {
			return DogResult.build(400, "上传失败");
		}
	}





	/**
	 *  ajax请求返回图片url
	 * @param request
	 * @param Id
	 * @param type
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/uploadSinglePic")
	@ResponseBody
	public PictureResult uploadSinglePic(HttpServletRequest request){
		PictureResult result = new PictureResult();
		UploadResult urlresult= null;
		try {
			urlresult = fileManagerService.uploadSinglePic(request);
		} catch (Exception e) {
			result.setError(1);
			result.setMessage("上传失败！");
			return result;
		}
		result.setError(0);
		result.setUrl(urlresult.getUrl());
		return result;
	}

	/**
	 *  根据图片id删除图片信息
	 * @param picId 图片id  必填
	 * @return
	 */
	@RequestMapping(value = "/{picId}",method = RequestMethod.DELETE)
	public @ResponseBody
	String del(@PathVariable("picId") Long picId){
        GlobalResult result = new GlobalResult();
        if(null !=picId){
			return result.boolResultJSON(fileManagerService.removePicById(picId));
		}
		return result.failureJSON();
	}
}
