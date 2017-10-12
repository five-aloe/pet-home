/**
 * Copyright (c) 2017, 满兜 . All rights reserved. Use is subject to license terms.
 */
package com.zhonglian.fuxi.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhonglian.douxin.commom.vo.BasicQueryParams;
import com.zhonglian.douxin.common.entity.FundsCommand;
import com.zhonglian.jinjufin.support.entity.IPagination;

/**
 * 资金指令数据层
 * 
 * @author zyf
 *
 */
public interface FundsCommandMapper {

	/**
	 * 统计记录数
	 * <p>查询参数需与 {@link FundsCommandMapper#find(BasicQueryParams, FundsCommand)}方法相同
	 * @param basic	基本参数
	 * @param cmd	指令参数
	 * @return
	 */
	int countFind(@Param("basic") BasicQueryParams basic, @Param("cmd") FundsCommand cmd);
	
	/**
	 * 指令查询
	 * 
	 * <p>记录数通过 {@link FundsCommandMapper#countFind(BasicQueryParams, FundsCommand)}方法获取
	 * 
	 * @param basic	基本参数
	 * @param cmd	指令参数
	 * @return
	 */
	List<FundsCommand> find(@Param("basic") BasicQueryParams basic, @Param("cmd") FundsCommand cmd);

	
	
}
