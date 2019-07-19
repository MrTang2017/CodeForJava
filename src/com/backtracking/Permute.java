package com.backtracking;

import java.util.ArrayList;

import java.util.List;

/**
 * 求一个无重复数字数组的全排列
 * @author 汤吉
 *
 */
public class Permute {
	
	  static List<List<Integer>> list=new ArrayList<>();
	  static int[] visited;
	  public List<List<Integer>> permute(int[] nums) {
	     if (nums.length==0) {
			return list;
		}
	     visited=new int[nums.length];
	     List<Integer> list2=new ArrayList<>();
	     df(nums,list2);
	     return list;   
	    }
	  

	private void df(int[] nums,List<Integer> list3) {
        if (list3.size()==nums.length) {
			list.add(new ArrayList<Integer>(list3));
			return;
		}
		for(int j=0;j<nums.length;j++){
			if (visited[j]!=0) {
				continue;
			}
			list3.add(nums[j]);
			visited[j]=1;
			df(nums,list3);
			list3.remove(list3.size()-1);
			visited[j]=0;
		}		
	}

	public static void main(String[] args) {
		int[] nums = { 1,3,6,7,9,0};
		Permute permute = new Permute();
		List<List<Integer>> list=permute.permute(nums);
		for(List<Integer> list2:list) {
			System.out.println(list2);
		}
	}

}
