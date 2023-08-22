package com.example.demo.oracle;

import java.util.ArrayList;
import java.util.List;

public class Ex99_ListApp {
	
	public static void main(String[] args) {
		Customer c1 = new Customer();
		c1.setCustId(101);
		c1.setName("박찬호");
		c1.setAddr("미국 LA");
		c1.setPhone("010-2345-6789");
		Customer c2 = new Customer(102, "박인비", "대한민국 서울", "010-3456-7890");
		// System.out.println(c1); System.out.println(c2);
		
		List<Customer> list = new ArrayList<>();
		list.add(c1); list.add(c2);
		System.out.println(list.get(0)); System.out.println(list.get(1));
		
		for(Customer c: list)		//list에서 element를 빼면 그것은 customer 타입
			System.out.println(c);
		
		list.forEach(x -> System.out.println(x));
	}
}
