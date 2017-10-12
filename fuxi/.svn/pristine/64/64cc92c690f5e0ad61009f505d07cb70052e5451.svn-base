/**
 * Copyright (c) 2017, 满兜 . All rights reserved. Use is subject to license terms.
 */
package com.zhonglian.fuxi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhonglian.douxin.commom.vo.BasicQueryParams;
import com.zhonglian.douxin.common.entity.FundsCommand;
import com.zhonglian.fuxi.dal.mapper.FundsCommandMapper;
import com.zhonglian.fuxi.service.FundsCommandService;
import com.zhonglian.jinjufin.support.entity.IPagination;
import com.zhonglian.jinjufin.support.entity.Pagination;
import com.zhonglian.jinjufin.support.exception.SimpleException;

/**
 * 资金指令后台服务实现
 * 
 * @author zyf
 *
 */
@Service
public class FundsCommandServiceImpl implements FundsCommandService {

	@Resource
	FundsCommandMapper mapper;

	@Override
	public IPagination<FundsCommand> find(BasicQueryParams basic, FundsCommand cmd) {

		try {

			int total = mapper.countFind(basic, cmd);

			List<FundsCommand> items = mapper.find(basic, cmd);

			Pagination<FundsCommand> result = new Pagination<>(basic.getPage(), basic.getPageSize());

			result.setData(items);
			result.setTotal(total);

			return result;

		} catch (Exception e) {

			throw new SimpleException("查询指金指令失败", e);
		}
	}

}
