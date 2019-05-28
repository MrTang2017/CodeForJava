package com.myoffer.first;

import java.util.ArrayList;

public class ContinousSum {
	public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int mid = sum / 2 + 1;
		int i = 1, s = 0, j = 0;
		while (i < mid) {
			s = i;//49
			j = i + 1;//50
			while (s != sum && j<= mid) {
				s += j;
				j++;
			}
			if (s == sum) {
				ArrayList<Integer> list1 = new ArrayList<>();
				for (int k = i; k <= j-1; k++) {
					list1.add(k);
				}
				list.add(list1);
				if (j-1!=mid) {
				   i=(i+j-1)/2;
				}
				else {
					break;
				}
				
			}
			else {
				i = i + 1;
			}	
		}
		return list;   
	}
	        
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> list=ContinousSum.FindContinuousSequence(30);
		for(int i=0;i<list.size();i++) {
			ArrayList<Integer> list2=list.get(i);
			for(Integer j:list2)
				System.out.print(j+" ");
			System.out.println();
		}
	}

}
