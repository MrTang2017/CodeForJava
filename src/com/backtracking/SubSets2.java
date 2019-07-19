package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author ÌÀ¼ª
 *
 */
public class SubSets2 {

	public List<List<Integer>> subsetsWithDup(int[] nums){
		
		List<List<Integer>> list=new ArrayList<>();
    	List<Integer> temp=new ArrayList<>();
    	int[] visited;
	    if (nums.length==0) {
			return list;
		}
	    Arrays.sort(nums);
	    for(int size=0;size<=nums.length;size++) {
	    	visited=new int[nums.length];
	    	df(0,nums,list,temp,size,visited);
	    }
	    return list;
		
		
		
	}

	private void df(int start, int[] nums, List<List<Integer>> list, List<Integer> temp, int size, int[] visited) {
		if (temp.size()==size) {
			list.add(new ArrayList<>(temp));
		}
		
		for(int j=start;j<nums.length;j++) {
			if (visited[j]==1) {
				continue;
			}
			if (j!=0 && nums[j]==nums[j-1] && visited[j-1]==0) {
				continue;
			}
			visited[j]=1;
			temp.add(nums[j]);
			df(j+1, nums, list, temp, size, visited);
			temp.remove(temp.size()-1);
			visited[j]=0;
			
		}
		
	}

}
