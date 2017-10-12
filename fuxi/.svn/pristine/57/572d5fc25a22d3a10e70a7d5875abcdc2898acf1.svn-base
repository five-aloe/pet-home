package com.zhonglian.fuxi.dal.support;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.zhonglian.jinjufin.support.mybatis.DaoSQLCreator;

public interface Mapper<T> {

	@InsertProvider(type = DaoSQLCreator.class, method = "insert")
	@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	int insert(T entity);

	@InsertProvider(type = DaoSQLCreator.class, method = "insertAll")
	@Options(useGeneratedKeys = false)
	int insertAll(@Param("list") List<T> entitys);

	@UpdateProvider(type = DaoSQLCreator.class, method = "updateByPK")
	int updateByPrimaryKey(T entity);

	@Select("call nextval(#{name},#{length})")
	int selectSeq(@Param("name") String name, @Param("length") int length);

	@Select("call nextval_all(#{name},#{length})")
	int getSeqNum(@Param("name") String name, @Param("length") int length);
}
