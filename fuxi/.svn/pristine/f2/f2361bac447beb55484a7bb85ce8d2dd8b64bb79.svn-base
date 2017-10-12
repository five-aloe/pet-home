/**
 * 版   本 ：    1.0
 * 创建日期 ：    2014年11月24日
 * 作   者 ：    张云飞  
 */
package com.zhonglian.fuxi.web.filter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.common.utils.Assert;
import com.zhonglian.douxin.common.constant.ErrorCodeConstants;
import com.zhonglian.douxin.common.utils.UserContextHolder;
import com.zhonglian.fuxi.service.SysUserService;
import com.zhonglian.jinjufin.support.annotation.Login;
import com.zhonglian.jinjufin.support.entity.IUser;
import com.zhonglian.jinjufin.support.exception.AuthException;

/**
 * 登录过滤器
 * 
 * @author zyf
 *
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Resource
	private SysUserService sysUserService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (!(handler instanceof HandlerMethod)) { // 跳 过普通资源（静态文件）的访问
			return true;
		}
		HandlerMethod handlers = (HandlerMethod) handler;

		boolean login = handlers.getMethod().isAnnotationPresent(Login.class)// 方法级注解处理
				|| handlers.getBeanType().isAnnotationPresent(Login.class); // 类级别注解处理

		if (login) {
			
			IUser user = (IUser) request.getSession().getAttribute(UserContextHolder.SESSION_USER_KEY);
			
			if (user != null) {
				user = sysUserService.findById(user.getId());

				Assert.notNull(user, "会话中的用户在数据库中不存在");

				UserContextHolder.putUser(user);
			} else {
				throw new AuthException(ErrorCodeConstants.USER_NON_LOGIN);
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		UserContextHolder.clean();
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
