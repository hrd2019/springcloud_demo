package com.dnote.demoserviced.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zfec.common.dto.service1DTO.User;


@Mapper
public interface IQueryAccount {
	@Select("select a.seller_name,a.status,b.username,b.real_name from t_seller a,sys_user b where a.user_id=b.id and a.name=#{name}")
	public User getUserByName(@Param("name") String name);
}
