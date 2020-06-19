package com.example.demo.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import com.example.demo.entity.User;

/**
 * @author czq
 * @Date 2020-06-19 16:06:12
 */
@Component
public interface UserMapper {

	@Select("select * from users where username=#{username}")
	User findByUserName(@Param("username") String username);
}
