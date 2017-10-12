package com.zhonglian.fuxi.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhonglian.douxin.commom.vo.FundAccountVo;
import com.zhonglian.douxin.common.bo.FundAccountBo;
import com.zhonglian.douxin.common.entity.SysUser;
import com.zhonglian.douxin.common.utils.UserContextHolder;
import com.zhonglian.fuxi.dal.mapper.FundAccountMapper;
import com.zhonglian.fuxi.service.FundAccountService;
import com.zhonglian.jinjufin.support.entity.IUser;
import com.zhonglian.jinjufin.support.entity.Pagination;

@Service
public class FundAccountServiceImpl implements FundAccountService {

	@Resource
	private FundAccountMapper fundAccountMapper;
	
	@Override
	public Pagination<FundAccountBo> findPage(FundAccountVo param) {
		Pagination<FundAccountBo> pagination = new Pagination<FundAccountBo>(param.getPage(), param.getPageSize());
		
		int pageCount = fundAccountMapper.findPageCount(param);
		List<FundAccountBo> page = fundAccountMapper.findPage(param);
		
		pagination.setTotal(pageCount);
		pagination.setData(page);
		return pagination;
	}

	@Override
	public Pagination<FundAccountBo> findAttentionPage(FundAccountVo param) {
		
		//获取当前登录管理员
		SysUser sysUser = (SysUser) UserContextHolder.getUser();
		
		Pagination<FundAccountBo> pagination = new Pagination<FundAccountBo>(param.getPage(), param.getPageSize());
		
		int pageCount = fundAccountMapper.findAttentionPageCount(param,sysUser.getId());
		List<FundAccountBo> page = fundAccountMapper.findAttentionPage(param,sysUser.getId());
		
		pagination.setTotal(pageCount);
		pagination.setData(page);
		return pagination;
	}

	@Override
	public int getTotalNumber() {
		return fundAccountMapper.getTotalNumber();
	}

	@Override
	public BigDecimal getTotalUsableMoney() {
		return fundAccountMapper.getTotalUsableMoney();
	}

	@Override
	public BigDecimal getFreezedMoney() {
		return fundAccountMapper.getFreezedMoney();
	}

	@Override
	public BigDecimal getTotalMoney() {
		return fundAccountMapper.getFreezedMoney();
	}
	
	
	
}
