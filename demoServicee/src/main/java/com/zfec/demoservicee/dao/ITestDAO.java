package com.zfec.demoservicee.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;

import com.dnote.common.dto.service1DTO.TestABC;

//import com.zfec.common.dto.service1DTO.TestABC;

@Mapper
public interface ITestDAO {
    @Insert("INSERT INTO test_hrd(a,b) VALUES(#{a}, #{b})")
    void insert(TestABC user);
    
    @Insert("INSERT INTO test_hrd(a,b) VALUES(#{a}, #{b})")
    void insert2(@Param("a") String a, @Param("b") String b);
    
    @Update("update test_hrd set b=#{b} where a=#{a}")
    String update(@Param("a") String a, @Param("b") String b);
}
