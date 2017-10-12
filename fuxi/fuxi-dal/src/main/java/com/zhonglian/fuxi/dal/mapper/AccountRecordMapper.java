/**
 * @author
 */
package com.zhonglian.fuxi.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhonglian.douxin.commom.vo.AccountRecordVo;
import com.zhonglian.douxin.common.bo.AccountRecordBo;
import com.zhonglian.douxin.common.entity.AccountRecord;
import com.zhonglian.douxin.common.enums.AccountRecordTypeEnums;
import com.zhonglian.fuxi.dal.support.Mapper;

/**
 * @author zhangshun
 *
 * 
 */
public interface AccountRecordMapper extends Mapper<AccountRecord>{
	
	/**
	 * 
	 * 资金明细变动总数
	 *@param AccountRecordVo 
	 *       请求参数
	 *
	 */
	int CountAccountRecord(@Param("params")AccountRecordVo params, @Param("type")AccountRecordTypeEnums type);
	
	/**
	 * 资金明细变动分页查询
	 * @param AccountRecordVo 
	 *       请求参数
	 *
	 */
	List<AccountRecordBo> findAccountRecordList(@Param("params")AccountRecordVo params, @Param("type")AccountRecordTypeEnums type);

}
