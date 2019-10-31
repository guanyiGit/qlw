package com.soholy.dogmanager.exception;

import com.soholy.dogmanager.common.pojo.DogResult;
import com.soholy.dogmanager.common.result.GlobalResult;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName GlobalExceptionResolver
 * @Description TODO(全局异常捕获-gy)
 * @author guanY
 * @Date 2017年11月15日 上午9:59:09
 * @version 1.0.0
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		 	ex.printStackTrace();
	        if (GyException.class.isInstance(ex)) {
	            ModelAndView view = new ModelAndView();
	            view.addObject(new GlobalResult().boolResultJSON(false));
	            return view;
	        }else if(ex instanceof UnauthorizedException){
	        	ModelAndView view = new ModelAndView();
	        	view.addObject(DogResult.build(400, "无操作权限"));
	        	return view;
	        }
	        return null;
		
	}
	
    
    
    
    

}
