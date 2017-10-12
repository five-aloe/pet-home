package com.zhonglian.fuxi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhonglian.douxin.common.entity.SysUserAttention;
import com.zhonglian.fuxi.dal.mapper.SysUserAttentionMapper;
import com.zhonglian.fuxi.service.SysUserAttentionService;

@Service
public class SysUserAttentionServiceImpl implements SysUserAttentionService {

	@Resource
	private SysUserAttentionMapper sysUserAttentionMapper;
	
	@Override
	public int add(SysUserAttention attention) {
		return sysUserAttentionMapper.insert(attention);		
	}

	@Override
	public int addAll(List<SysUserAttention> list) {
		if(list.size() == 0 || list == null){
			return 0;
		}
		return sysUserAttentionMapper.insertAll(list);
	}

	@Override
	public int cancelAttention(String id, Long userId) {
		return sysUserAttentionMapper.cancelAttention(id,userId);
	}

	
}
