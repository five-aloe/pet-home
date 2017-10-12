/**
 * @author
 */
package com.zhonglian.fuxi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhonglian.douxin.common.entity.CompanyMessage;
import com.zhonglian.fuxi.dal.mapper.CompanyMessageMapper;
import com.zhonglian.fuxi.service.CompanyMessageService;

/**
 * @author zhangshun
 *
 * 
 */
@Service
public class CompanyMessageServiceImpl implements CompanyMessageService{

	@Resource
	private CompanyMessageMapper companyMessageMapper;
	
	@Override
	public CompanyMessage findCompanyMessage(Long userId) {
		
		return companyMessageMapper.findCompanyMessage(userId);
	}

}
