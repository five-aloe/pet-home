/**
 * 
 */
package com.zhonglian.fuxi.service;

import com.zhonglian.douxin.commom.vo.UserAddEnterpriseVo;
import com.zhonglian.douxin.commom.vo.UserAddVo;
import com.zhonglian.douxin.commom.vo.UserVo;
import com.zhonglian.douxin.common.bo.UserFuXiBo;
import com.zhonglian.douxin.common.bo.UserMobileBo;
import com.zhonglian.jinjufin.support.entity.Pagination;
import com.zhonglian.jinjufin.support.entity.IUser;

/**
 * @author zhangshun
 *
 */
public interface UserService {
	
	/**
	 * 个人账户代注册
	 * 
	 *@author zhangshun
	 * @date 2017年8月23日 下午12:06:44
	 */
	void addUser(UserAddVo userAddVo);
	/**
	 * 企业账户注册
	 * 
	 * @date 2017年8月23日 下午12:08:13
	 */
	void addCompanyUser(UserAddEnterpriseVo userAddEnterpriseVo);
	
	/**
	 * 根据手机号查询
	 * @param mobile
	 *        手机号
	 */
	public UserMobileBo findUserMobile(String mobile);
	
	/**
	 * 查询账户注册信息
	 * @param userVo 账户注册信息查询参数
	 */
	public Pagination<UserFuXiBo> findUser(UserVo params);
	
	/**
	 * 更新账户信息
	 * @param userAddEnterpriseVo
	 *        企业参数
	 * @param  userAddVo
	 *        个人参数      
	 * 
	 */
	public void updateUser(UserAddEnterpriseVo userAddEnterpriseVo, UserAddVo userAddVo);

}
