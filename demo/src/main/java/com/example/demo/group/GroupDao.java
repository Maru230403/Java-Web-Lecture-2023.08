package com.example.demo.group;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.blog.Blog;

@Component
public class GroupDao {
	@Value("${spring.datasource.url}") private String url;
	@Value("${spring.datasource.username}") private String username;
	@Value("${spring.datasource.password}") private String password;
	
	public Group getGroup(int gid) {
		String sql = "select * from group where gid=?";
		Group group = null;
		try {
				Connection conn = DriverManager.getConnection(url, username, password);
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gid);
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					gid = rs.getInt(1);
					String ggname= rs.getString(2);
					String profile1= rs.getString(3);
					String name= rs.getString(4);
					int age= rs.getInt(5);
					String position= rs.getString(6);
					String nationality= rs.getString(7);
					String entertainment= rs.getString(8);
					group = new Group(gid, ggname, profile1, name, age, position, nationality, entertainment);
				}
				rs.close(); pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return group;
	}
	
	public void insertGroup(Group group) {
		String sql = " insert into group(profile1) values (?, ?, ?)";
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, group.getGid());
			pstmt.setString(2, group.getEntertainment());
			pstmt.setString(3, group.getprofile1());
			pstmt.executeLargeUpdate();
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Group> getGroupList(String field, String query) {
		String sql = "select * from group where " + field + " like ? and isDeleted=0 ";
		List<Group> list = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int gid = rs.getInt(1);
				String ggname= rs.getString(2);
				String profile1= rs.getString(3);
				String name= rs.getString(4);
				int age= rs.getInt(5);
				String position= rs.getString(6);
				String nationality= rs.getString(7);
				String entertainment= rs.getString(8);
				Group group = new Group(gid, ggname, profile1, name, age, position, nationality, entertainment);
				
				list.add(group);
		}
			rs.close(); pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		public void updateGroup(Group group) {
			String sql = "update group set ggname=?, entertainment=?, profile1=? where gid=?";
			try {
				Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, group.getGgname());
				pstmt.setString(2, group.getEntertainment());
				pstmt.setString(3, group.getprofile1());
				pstmt.setInt(4, group.getGid());
				pstmt.executeUpdate();
				pstmt.close(); conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void deleteGroup(int Gid) {
			String sql = "update group set isDeleted=1 where gid=?";
			try {
				Connection conn = DriverManager.getConnection(url, username, password);
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Gid);
				pstmt.executeUpdate();
				pstmt.close(); conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
