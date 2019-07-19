package com.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，
 * 返回该数组所有可能的子集（幂集）。
 */


public class SubSets {
	
    public List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> list=new ArrayList<>();
    	List<Integer> temp=new ArrayList<>();
	    if (nums.length==0) {
			return list;
		}
	    for(int size=0;size<=nums.length;size++) {
	    	df(0,nums,list,temp,size);
	    }
	    return list;
	    
    }

	
		
	private void df(int start, int[] nums, List<List<Integer>> list, List<Integer> temp, int size) {
		if (temp.size()==size) {
			list.add(new ArrayList<>(temp));
			return;
		}
		
		for(int j=start;j<nums.length;j++) {
			temp.add(nums[j]);
			df(j+1, nums, list, temp, size);
			temp.remove(temp.size()-1);	
	}



	}

	public static void main(String[] args) {

		int[] cands = { 1, 2, 3 };
		List<List<Integer>> list = new SubSets().subsets(cands);
		for (List<Integer> list2 : list) {
			System.out.println(list2);
		}

	}

}
