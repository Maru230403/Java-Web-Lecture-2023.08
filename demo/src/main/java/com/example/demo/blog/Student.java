package com.example.demo.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString				//ToString
@Getter					//Getter	
@Setter					//Setter
@NoArgsConstructor		//기본생성자
@AllArgsConstructor		// 생성자
public class Student {
	private int sid;
	private String name;
	private String gender;
}
