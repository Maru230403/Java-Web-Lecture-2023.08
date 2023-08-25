package com.example.demo.group;

public class Group {
	private int gid;
	private String ggname;
	private String  profile1;
	private String name;
	private int age;
	private String position;
	private String nationality;
	private String entertainment;
	
	public Group() {
	}
// 	Insert 생성자 메소드
	public Group(String ggname, String profile1) {
		this.ggname = ggname;
		this.profile1 = profile1;
	}

	public Group(int gid, String ggname, String profile1, String name, int age, String position, String nationality,
			String entertainment) {
		this.gid = gid;
		this.ggname = ggname;
		this.profile1 = profile1;
		this.name = name;
		this.age = age;
		this.position = position;
		this.nationality = nationality;
		this.entertainment = entertainment;
	}

	@Override
	public String toString() {
		return "group [gid=" + gid + ", ggname=" + ggname + ", profile1=" + profile1 + ", name=" + name + ", age=" + age
				+ ", position=" + position + ", nationality=" + nationality + ", entertainment=" + entertainment + "]";
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGgname() {
		return ggname;
	}

	public void setGgname(String ggname) {
		this.ggname = ggname;
	}

	public String getprofile1() {
		return profile1;
	}

	public void setprofile1(String profile1) {
		this.profile1 = profile1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEntertainment() {
		return entertainment;
	}

	public void setEntertainment(String entertainment) {
		this.entertainment = entertainment;
	}

}
