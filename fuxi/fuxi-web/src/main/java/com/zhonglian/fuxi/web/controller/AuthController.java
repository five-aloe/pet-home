/**
 * 
 */
package com.zhonglian.fuxi.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhonglian.douxin.common.entity.SysUser;
import com.zhonglian.douxin.common.utils.UserContextHolder;
import com.zhonglian.fuxi.service.SysUserService;
import com.zhonglian.fuxi.service.impl.Sha256PasswordEncoder;
import com.zhonglian.jinjufin.support.annotation.Login;
import com.zhonglian.jinjufin.support.entity.JsonResult;

/**
 * 认证控制器
 * 
 * @author zyf
 *
 */
@RestController
public class AuthController {

	@Resource
	SysUserService sysUserService;
	
	@RequestMapping("/login")
	public JsonResult login(String username, String password, HttpSession session) {
		
		
		SysUser user = sysUserService.findByUsername(username);
		
		if (user == null) {
			return JsonResult.buildFailedResult("用户不存在或密码错误");
		}
		
		if (!new Sha256PasswordEncoder().matches(password, user.getPassword())) {
			return JsonResult.buildFailedResult("密码错误");
		}

		session.setAttribute(UserContextHolder.SESSION_USER_KEY, user);
		
		return JsonResult.buildResult(true, "登录成功");
		
	}
	
	@RequestMapping("/logout")
	public JsonResult logout(HttpSession session) {
		
		session.invalidate();
		return JsonResult.buildResult(true, "用户已退出");
		
	}
	
	
	@RequestMapping("test")
	@Login
	public JsonResult test() {
		
		SysUser user = (SysUser) UserContextHolder.getUser();
		
		return JsonResult.buildSuccessResult(user);
		
	}
	
}
