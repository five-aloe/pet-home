/**
 * Copyright (c) 2017, 满兜 . All rights reserved. Use is subject to license terms.
 */
package com.zhonglian.fuxi.service;

import com.zhonglian.douxin.commom.vo.BasicQueryParams;
import com.zhonglian.douxin.common.entity.FundsCommand;
import com.zhonglian.jinjufin.support.entity.IPagination;

/**
 * 资金指令服务
 * 
 * @author zyf
 *
 */
public interface FundsCommandService {

	/**
	 * 资金指令综合查询
	 * @param basic	基本参数
	 * @param cmd	指令参数
	 * @return
	 */
	IPagination<FundsCommand> find(BasicQueryParams basic, FundsCommand cmd);

}
