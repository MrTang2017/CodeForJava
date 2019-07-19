package com.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 对有重复的数组进行全排列
 * @author 汤吉
 *
 */
public class PeruteUnique {
	private static int[] visited;
	public List<List<Integer>> permuteUnique(int[] nums){
		
		List<List<Integer>> list=new ArrayList<>();
		if (nums.length==0) {
			return list;
		}
		Arrays.sort(nums);
		visited=new int[nums.length];
		List<Integer> temp=new ArrayList<>();
		df(list,temp,nums);
		return list;		
	}

	private void df(List<List<Integer>> list, List<Integer> temp, int[] nums) {
		if (temp.size()==nums.length) {
			list.add(new ArrayList<>(temp));
			return;
		}		
		for(int i=0;i<visited.length;i++) {
			
			if (i!=0 && nums[i]==nums[i-1] && visited[i-1]==0) {
				continue;
			}
			if (visited[i]==1) {
				continue;
			}
			temp.add(nums[i]);
			visited[i]=1;
			df(list, temp, nums);
			temp.remove(temp.size()-1);
			visited[i]=0;
		}
				
	}

	public static void main(String[] args) {
		
		
		int[] nums= {1,2,1};
		List<List<Integer>> list=new PeruteUnique().permuteUnique(nums);
		for(List<Integer> list2:list)
			System.out.println(list2);

	}

}
