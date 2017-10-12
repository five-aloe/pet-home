/**
 * 
 */
package com.zhonglian.fuxi.dal.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhonglian.douxin.common.entity.SysUser;

/**
 * @author zyf
 *
 */
public interface SysUserMapper {

	/**
	 * 按用户名获取用户
	 * @param username
	 * @return
	 */
	@Select("SELECT * FROM sys_user WHERE username = #{username}")
	public SysUser findByUsername(@Param("username") String username);

	/**
	 * 按用户ID获取用户
	 * @param id
	 * @return
	 */
	@Select("SELECT * FROM sys_user WHERE id=#{id}")
	public SysUser findById(@Param("id") Long id);
	
}
