/**
 * 
 */
package com.zhonglian.fuxi.dal.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zhonglian.douxin.commom.vo.FundAccountVo;
import com.zhonglian.douxin.common.bo.FundAccountBo;
import com.zhonglian.douxin.common.entity.Account;
import com.zhonglian.fuxi.dal.support.Mapper;

/**
 * @author lvmeng
 *
 */
public interface FundAccountMapper extends Mapper<Account>{
	
	int findPageCount(FundAccountVo param);
	
	List<FundAccountBo>  findPage(FundAccountVo param);

	List<FundAccountBo> findAttentionPage(@Param("param")FundAccountVo param, @Param("id")Long id);

	int findAttentionPageCount(@Param("param")FundAccountVo param, @Param("id")Long id);

	@Select("SELECT SUM(ac.usableMoney) FROM account ac")
	BigDecimal getTotalUsableMoney();

	@Select("SELECT SUM(ac.freezeMoney) FROM account ac")
	BigDecimal getFreezedMoney();
	
	@Select("SELECT SUM(ac.balance) FROM account ac")
	BigDecimal getTotalMoney();
	
	@Select("SELECT COUNT(ac.id) FROM account ac")
	int getTotalNumber();


}
