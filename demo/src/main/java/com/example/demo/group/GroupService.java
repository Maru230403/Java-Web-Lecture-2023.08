package com.example.demo.group;

import java.util.List;

public interface GroupService {
	
	Group getGroup(int gid);
	
	List<Group> getGroupList(String field, String query);
	
	void insertGroup(Group group);
	
	void updateGroup(Group group);
	
	void deleteGroup(int gid);

}
