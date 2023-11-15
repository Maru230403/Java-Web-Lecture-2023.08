package com.example.demo.group;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.blog.Blog;

@Service
public class GroupServiceOracleImpl implements GroupService{
	@Autowired private GroupDaoOracle groupDao;

	@Override
	public Group getGroup(int gid) {
		Group group = groupDao.getGroup(gid);
		return group;
	}

	@Override
	public List<Group> getGroupList(String field, String query) {
		query = "%" + query + "%";
		List<Group> list =groupDao.getGroupList(field, query);
		return list;
	}

	@Override
	public void insertGroup(Group group) {
		groupDao.insertGroup(group);
	}

	@Override
	public void updateGroup(Group group) {
		groupDao.updateGroup(group);
	}

	@Override
	public void deleteGroup(int gid) {
		groupDao.deleteGroup(gid);
	}

}
