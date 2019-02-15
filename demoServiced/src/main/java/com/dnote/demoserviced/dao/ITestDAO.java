package com.dnote.demoserviced.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import com.zfec.common.dto.service1DTO.TestABC;

//import com.zfec.common.dto.service1DTO.TestABC;

@Mapper
public interface ITestDAO {
    @Insert("INSERT INTO test_c(a,b) VALUES(#{a}, #{b})")
    void insert(TestABC user);
    
    @Insert("INSERT INTO test_c(a,b) VALUES(#{a}, #{b})")
    void insert2(@Param("a") String a, @Param("b") String b);
    
    @Select("select b from test_c b  where b.a=#{a}")
    String sel(@Param("a") String a);
}
