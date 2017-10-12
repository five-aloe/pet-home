/**
 * 
 */
package com.zhonglian.fuxi.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhonglian.douxin.common.entity.SysUser;
import com.zhonglian.fuxi.dal.mapper.SysUserMapper;
import com.zhonglian.fuxi.service.SysUserService;

/**
 * @author zyf
 *
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Resource
	private SysUserMapper sysUserMapper;
	
	@Override
	public SysUser findByUsername(String username) {
		return sysUserMapper.findByUsername(username);
	}

	@Override
	public SysUser findById(Long id) {
		return sysUserMapper.findById(id);
	}

}
