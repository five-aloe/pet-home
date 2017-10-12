/**
 * @author
 */
package com.zhonglian.fuxi.web.controller;

import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhonglian.douxin.commom.vo.AccountRecordVo;
import com.zhonglian.douxin.common.bo.AccountRecordBo;
import com.zhonglian.douxin.common.enums.AccountRecordTypeEnums;
import com.zhonglian.fuxi.service.AccountRecordService;
import com.zhonglian.fuxi.web.util.ExportUtil;
import com.zhonglian.jinjufin.support.annotation.Login;
import com.zhonglian.jinjufin.support.common.Commons;
import com.zhonglian.jinjufin.support.entity.JsonResult;
import com.zhonglian.jinjufin.support.entity.Pagination;
import com.zhonglian.jinjufin.support.exception.ResponseExceptionMessage;
import com.zhonglian.jinjufin.support.utils.MandoAssert;

/**
 * 资金变动详情
 * @author zhangshun
 *
 * 
 */
@Controller
@RequestMapping("accountRecord")
@Login
public class AccountRecordController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountRecordController.class);
	
	List<Map<String, Object>> dataList = null;
	
	@Resource
	private AccountRecordService accountRecordService;
	/**
	 *   资金变动明细查询
	 * @author zhangshun
	 *@param AccountRecordVo
	 *        请求参数
	 * @return       
	 */
	@RequestMapping("findAccountRecord")
	@ResponseBody
	public JsonResult findAccountRecord(AccountRecordVo params, HttpServletResponse response) {
		MandoAssert.notNull(params.getType(), "资金类型不能为空");
		MandoAssert.notNull(params.getAccountNo(), "订单编号不能为空");
		try {
			Pagination<AccountRecordBo> pagination = accountRecordService.findAccountRecord(params, params.getType());
			if (params.getExport() != null && params.getExport()) {
				String sTitle = null;
				String fName = null;
				List<AccountRecordBo> accountRecordBo = pagination.getData();
				if(params.getType().equals(AccountRecordTypeEnums.DEDUCTION)){
					 sTitle = "订单号,资金编号,手机号码,变动时间,变动金额,变动前总金额,变动后总金额,变动原因";
					 fName = "资金明细记录_";	
				}else{
					sTitle = "订单号,资金编号,手机号码,变动时间,变动金额,变动前冻结金额,变动后冻结金额,变动原因";
					 fName = "资金冻解记录_";
				}				
				String mapKey = "accountNo,commandNo,mobile,modifyDate,money,beforeMoney,afterMoney,remark";
				dataList = new ArrayList<>();
				Map<String, Object> map;
				if (!pagination.getData().isEmpty()) {
					for (AccountRecordBo AccountRecord : accountRecordBo) {
						StringBuffer buffer = new StringBuffer();
						buffer.append("'");
						buffer.append(AccountRecord.getNotation().getText());
						buffer.append(AccountRecord.getMoney().divide(new BigDecimal(1), 2, BigDecimal.ROUND_DOWN));
						map = new HashMap<>();
						map.put("accountNo", AccountRecord.getAccountNo());
						map.put("commandNo",AccountRecord.getCommandNo());
						map.put("name", AccountRecord.getName());
						map.put("mobile", AccountRecord.getMobile());
					    map.put("modifyDate", AccountRecord.getModifyDate() == null ? "--" : DateFormatUtils.format(AccountRecord.getModifyDate(), Commons.DATE_FORMAT_NORMAL));
						map.put("money", buffer);
						map.put("beforeMoney", AccountRecord.getBeforeMoney());
						map.put("afterMoney", AccountRecord.getAfterMoney());
						map.put("remark", AccountRecord.getRemark() == null ? "--" : AccountRecord.getRemark());
						dataList.add(map);
					}
				}
				try (final OutputStream os = response.getOutputStream()) {
					ExportUtil.responseSetProperties(fName, response);
					ExportUtil.doExport(dataList, sTitle, mapKey, os);
					return null;

				} catch (Exception e) {
					logger.error("资金变动明细CSV失败", e);
				}
				return JsonResult.buildFailedResult("数据导出出错");
			}
			return JsonResult.buildSuccessResult(pagination);
		} catch (Exception e) {
			String mgs = "资金变动明细查询失败";
			return ResponseExceptionMessage.getResponseExceptionMessage(logger, mgs, e);
		}
	}

}
