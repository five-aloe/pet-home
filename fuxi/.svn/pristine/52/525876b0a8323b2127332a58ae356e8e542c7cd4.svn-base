
package com.zhonglian.fuxi.web.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonglian.jinjufin.support.entity.JsonResult;
import com.zhonglian.jinjufin.support.exception.AuthException;
import com.zhonglian.jinjufin.support.exception.IBizCodeException;
import com.zhonglian.jinjufin.support.exception.IMandoException;
import com.zhonglian.jinjufin.support.exception.ISimpleException;


/**
 * AJAX 异常统一处理
 * 
 * @author 张云飞
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
	
	private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);
	
	
	/**
	 * 统一处理AJAX异常
	 * @param ex
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public JsonResult ajaxError(Throwable ex, HttpServletRequest request, HttpServletResponse response) 
	{
		
		String message = null;
		if (ex instanceof IBizCodeException || ex instanceof ISimpleException || ex instanceof IllegalArgumentException || ex instanceof IMandoException) {//业务异常， 异常消息可以直接显示
			message = ex.getMessage();
		
		} else {
			message = "未知错误, 请联系客服.";
		}
		

		JsonResult result = JsonResult.buildFailedResult(message);
		
		if (ex instanceof IBizCodeException) {
			IBizCodeException codeEx = (IBizCodeException) ex;
			result = JsonResult.buildFailedResult(codeEx.getCode());
		}
		
		if (LOGGER.isErrorEnabled() && !(ex instanceof AuthException)) {
			LOGGER.error(message, ex);
		}	

		return result;
		
	}

}
