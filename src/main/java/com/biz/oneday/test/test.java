package com.biz.oneday.test;

import java.util.ArrayList;
import java.util.List;

public class test 
{
	public static void main(String[] args) 
	{
		List<String> q = new ArrayList<>();
		
		for(int i=q.size()-1; i<q.size()+1; ++i)
			System.out.println(q.get(i));
		
		
		String a = "d";
		if(a.equals("b") == false)
			System.out.println("dddd");
		
		System.out.println("dd");
	}
}
