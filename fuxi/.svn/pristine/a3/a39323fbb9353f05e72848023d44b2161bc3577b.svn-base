/**
 * Copyright (c) 2017, 满兜 . All rights reserved. Use is subject to license terms.
 */
package com.zhonglian.fuxi.web.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.common.utils.Assert;
import com.zhonglian.douxin.commom.vo.BasicQueryParams;
import com.zhonglian.douxin.common.constant.DateConstant;
import com.zhonglian.douxin.common.entity.FundsCommand;
import com.zhonglian.fuxi.service.FundsCommandService;
import com.zhonglian.fuxi.web.util.ExportUtil;
import com.zhonglian.jinjufin.support.annotation.Login;
import com.zhonglian.jinjufin.support.entity.IPagination;
import com.zhonglian.jinjufin.support.entity.JsonResult;

/**
 * 资金指令查询控制器
 * @author zyf
 *
 */
@RestController
@RequestMapping("/fundsCmd")
@Login
public class FundsCommandController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	private FundsCommandService fundsCommandService;
	
	
	/**
	 * 综合查询
	 * @param params
	 * @param cmd
	 * @return
	 */
	@RequestMapping("/find")
	public JsonResult find(BasicQueryParams params, FundsCommand cmd, HttpServletResponse response) {

		Assert.notNull(params.getBeginTime(), "开始时间不能为空");
		Assert.notNull(params.getEndTime(), "结束时间不能为空");
		
		//结束时间+1处理
		params.setEndTime(DateUtils.addDays(params.getEndTime(), 1));
		
		IPagination<FundsCommand> page = fundsCommandService.find(params, cmd);
		
		if (params.getExport()) {
			exportResult(page.getData(), response);
			return null;
			
		} else {
			return JsonResult.buildSuccessResult(page);
		}
	}


	private boolean exportResult(List<FundsCommand> result, HttpServletResponse response) {
		
		String sTitle = "创建时间,编号,帐务类型,指令类型,订单号,收款帐户,付款帐户,金额,状态,备注";

		String fName = "funds_command_" + DateFormatUtils.format(new Date(), DateConstant.DATE_FORMAT_NORMAL);
		String mapKey = "createDate,no,accountingType,type,orderNo,payeeAccountNo,payerAccountNo,money,state,remark";
		List<Map<String, Object>> dataList = new ArrayList<>();
		Map<String, Object> map;
		for (FundsCommand item : result) {
			map = new HashMap<>();
			map.put("createDate", DateFormatUtils.format(item.getCreateDate(), "yyyy/MM/dd HH:mm"));
			map.put("no", item.getNo());
			map.put("accountingType", item.getAccountingType().getText());
			map.put("type", item.getType().getText());
			map.put("orderNo", item.getOrderNo());
			map.put("payeeAccountNo", item.getPayeeAccountNo());
			map.put("payerAccountNo", item.getPayerAccountNo());
			map.put("money", item.getMoney().toString());
			map.put("state", item.getState().getText());
			map.put("remark", item.getRemark());
			
			dataList.add(map);
		}
		try (final OutputStream os = response.getOutputStream()) {
			ExportUtil.responseSetProperties(fName, response);
			ExportUtil.doExport(dataList, sTitle, mapKey, os);
			logger.info("导出成功");
			
			return true;
		} catch (Exception e) {
			logger.error("充值流水CSV失败", e);
			return false;
		}
		
	}
	
}
