package com.example.demo.group;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface GroupDaoOracle {
		
		@Select("select * from group where gid=#{gid}")
		Group getGroup(int gid);
		
		@Select("select * from blog where ${field} like #{query} and isDeleted=0")
		List<Group> getGroupgpage(String field, String query);
		
		@Insert("insert into group(gid, entertainment, profile1) values (#{gid}, #{entertainment}, #{profile1})")
		void insertGroup(Group group);
		
		@Update("update group set ggname=#{ggname}, entertainment=#{entertainment}, profile1=#{profile1, jdbcType=VARCHAR} where gid=?")
		void updateGroup(Group group);
		
		@Update("update blog set isDeleted=1 where gid={gid}")
		void deleteGroup(int gid);
}
