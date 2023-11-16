package com.human.sample.db;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.human.sample.entity.User;

@Mapper
public interface UserDaoOracle {

	@Select("select * from users where \"uid\"=#{uid}")		// 안쓰면 바보
	public User getUser(String uid);
	
	//  mybatis를 쓰는 이유: 간단하게 사용가능함 ex) #{uid} --> user,getUid()
	@Insert("insert into users values (#{uid}, #{pwd}, #{uname}, #{email}, default, default)")
	public void insertUser(User user);
}
 