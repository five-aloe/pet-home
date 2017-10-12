/**
 * 
 */
package com.zhonglian.fuxi.dal.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import com.zhonglian.douxin.common.entity.SysUserAttention;
import com.zhonglian.fuxi.dal.support.Mapper;

/**
 * @author lvmeng
 *
 */
public interface SysUserAttentionMapper extends Mapper<SysUserAttention>{

	@Delete("DELETE FROM sys_user_attention WHERE sysUserId=#{userId} and accountId=#{id}")
	int cancelAttention(@Param("id")String id, @Param("userId")Long userId);
	


}
