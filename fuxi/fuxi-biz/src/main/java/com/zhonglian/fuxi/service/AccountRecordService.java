/**
 * @author
 */
package com.zhonglian.fuxi.service;

import com.zhonglian.douxin.commom.vo.AccountRecordVo;
import com.zhonglian.douxin.common.bo.AccountRecordBo;
import com.zhonglian.douxin.common.entity.AccountRecord;
import com.zhonglian.douxin.common.enums.AccountRecordTypeEnums;
import com.zhonglian.jinjufin.support.entity.Pagination;

/**
 * @author zhangshun
 *
 * 
 */
public interface AccountRecordService {
	
	/**
	 * 资金变动明细分页查询
	 * @param AccountRecordVo params
	 *                         请求参数
	 *@return
	 */
	Pagination<AccountRecordBo> findAccountRecord(AccountRecordVo params, AccountRecordTypeEnums type);

}
