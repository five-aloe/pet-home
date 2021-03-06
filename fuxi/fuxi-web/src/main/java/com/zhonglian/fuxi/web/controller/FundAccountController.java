/**
 * 
 */
package com.zhonglian.fuxi.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonglian.douxin.commom.vo.FundAccountVo;
import com.zhonglian.douxin.common.entity.SysUser;
import com.zhonglian.douxin.common.entity.SysUserAttention;
import com.zhonglian.douxin.common.utils.UserContextHolder;
import com.zhonglian.fuxi.service.FundAccountService;
import com.zhonglian.fuxi.service.SysUserAttentionService;
import com.zhonglian.jinjufin.support.annotation.Login;
import com.zhonglian.jinjufin.support.entity.JsonResult;
import com.zhonglian.jinjufin.support.utils.MandoAssert;

/**
 * @author lvmeng
 *
 */
@Controller
@RequestMapping("fundAccount")
@Login
public class FundAccountController {

	private static final Logger logger = LoggerFactory.getLogger(FundAccountController.class);

	@Resource
	private FundAccountService fundAccountService;

	@Resource
	private SysUserAttentionService sysUserAttentionService;

	@RequestMapping("findPage")
	@ResponseBody
	public JsonResult findPage(FundAccountVo param) {
		try {

			fundAccountService.getTotalNumber();
			
			fundAccountService.getTotalUsableMoney();
			
			fundAccountService.getFreezedMoney();
			
			fundAccountService.getTotalMoney();
			
			return JsonResult.buildSuccessResult(fundAccountService.findPage(param))
							.setModel("totalNumber", fundAccountService.getTotalNumber())
							.setModel("totalUsableMoney", fundAccountService.getTotalUsableMoney())
							.setModel("totalFreezedMoney", fundAccountService.getFreezedMoney())
							.setModel("totalMoney", fundAccountService.getTotalMoney());
		} catch (Exception e) {
			String mgs = "资金账户列表查询失败";
			logger.error(mgs, e);
			return JsonResult.buildFailedResult(mgs);
		}
	}

	@RequestMapping("addAttention")
	@ResponseBody
	public JsonResult addAttention(String idList){
		MandoAssert.isNull(idList, "所选id不能为空");
		try {
			//获取当前登录管理员
			SysUser sysUser = (SysUser) UserContextHolder.getUser();
			
			String[] split = idList.split(",");
			SysUserAttention attention ;
			
			List<SysUserAttention> list = new ArrayList<SysUserAttention>();
			
			for (String accountId : split) {
				attention = new SysUserAttention(new Long(accountId), sysUser.getId());
				list.add(attention);
			}
			
			sysUserAttentionService.addAll(list);
			
			return JsonResult.buildSuccessResult("关注成功");
		} catch (Exception e) {
			String mgs = "关注失败";
			logger.error(mgs, e);
			return JsonResult.buildFailedResult(mgs);
		}
	}
	
	@RequestMapping("findAttentionPage")
	@ResponseBody
	public JsonResult findAttentionPage(FundAccountVo param) {
		try {

			return JsonResult.buildSuccessResult(fundAccountService.findAttentionPage(param));
		} catch (Exception e) {
			String mgs = "资金账户关注列表查询失败";
			logger.error(mgs, e);
			return JsonResult.buildFailedResult(mgs);
		}
	}
	
	/**
	 * 根据账户id取消关注
	 * @param idList
	 * @return
	 */
	@RequestMapping("cancelAttention")
	@ResponseBody
	@Transactional
	public JsonResult cancelAttention(String idList) {
		MandoAssert.isNull(idList, "所选id不能为空");
		try {
			//获取当前登录管理员
			SysUser sysUser = (SysUser) UserContextHolder.getUser();
			
			String[] split = idList.split(",");
			for (String id : split) {
				sysUserAttentionService.cancelAttention(id,sysUser.getId());
			}
			return JsonResult.buildSuccessResult("ok");
		} catch (Exception e) {
			String mgs = "取消关注失败";
			logger.error(mgs, e);
			return JsonResult.buildFailedResult(mgs);
		}
	}
	
}
