/**
 * 
 */
package com.zhonglian.fuxi.dal.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhonglian.douxin.commom.vo.UserAddEnterpriseVo;
import com.zhonglian.douxin.common.entity.CompanyMessage;
import com.zhonglian.fuxi.dal.support.Mapper;

/**
 * @author zhangshun
 *
 */
public interface CompanyMessageMapper extends Mapper<CompanyMessage> {
	
	/**
	 * 根据userId查询企业信息
	 * @param userId 用户ID
     * @return
	 */
	@Select("SELECT *FROM company_message WHERE userId =#{userId}")
	CompanyMessage findCompanyMessage(Long userId);
	
	/**
	 * 更新企业信息
	 * 
	 *
	 */
	void updateCompanyMessage(@Param("parpams")UserAddEnterpriseVo parpams, @Param("userId") Long userId);

}
