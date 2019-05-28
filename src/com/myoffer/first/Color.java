package com.myoffer.first;

import java.util.ArrayList;
import java.util.HashSet;

public class Color {

	public static void main(String[] args) {
	
ArrayList<String> list=new ArrayList<>();
HashSet<String> set=new HashSet<>();
list.add("33");
list.add("33");
list.addAll(set);
System.out.println(list.size());
	}

}
