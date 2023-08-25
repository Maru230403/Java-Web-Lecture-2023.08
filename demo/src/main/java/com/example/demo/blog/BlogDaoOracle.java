package com.example.demo.blog;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BlogDaoOracle {

		@Select("select * from blog where bid=#{bid}") //#{bid}을 사용하면  Blog getBlog(int bid)의 bid값이 들어가진다
		Blog getBlog(int bid);
		
		//"select * from blog where " + field + " like ? and isDeleted=0 "
		// + " order by modTime desc"
		
		@Select("select * from blog where ${field} like #{query} and isDeleted=0"
				+ " order by modTime desc")
		List<Blog> getBlogList(String field, String query);
		
		@Insert("insert into blog(penName, title, content)"
				+ " values (#{penName}, #{title}, #{content, jdbcType=VARCHAR})")
		void insertBlog(Blog blog);
		
		@Update("update blog set penName=#{penName}, title=#{title}, content=#{content, jdbcType=VARCHAR},"
				+ " modTime=current_timestamp where bid=#{bid}")
		void updateBlog(Blog blog);
		
		@Update("update blog set isDeleted=1 where bid=#{bid}")
		void deleteBlog(int bid);
		
		@Update("update blog set viewCount=viewCount +1 where bid=#{bid}")
		void increaseViewCount(int bid);
}
