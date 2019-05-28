package com.myoffer.first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortMinNumber {

	public static String sortMinNumber(int[] numbers) {
		
		StringBuilder sBuilder=new StringBuilder();
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<numbers.length;i++) {
			list.add(numbers[i]);
		}	
		Collections.sort(list, new SortredComparator());
		for(Integer number:list) {
			sBuilder.append(Integer.toString(number));
		}	
		String result=sBuilder.toString();
		return result;		
	}
	
	static class SortredComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			String s1=Integer.toString(o1)+Integer.toString(o2);
			String s2=Integer.toString(o2)+Integer.toString(o1);
			Integer x1=Integer.parseInt(s1);
			Integer x2=Integer.parseInt(s2);
			return x1.compareTo(x2);	
		}
	}
	
	public static void main(String[] args) {
		int[] a= {3,32,321,323,234,231,324,124,125,231};
		System.out.println(sortMinNumber(a));

	}

}
